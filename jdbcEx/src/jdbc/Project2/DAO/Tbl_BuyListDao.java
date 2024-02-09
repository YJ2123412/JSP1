package jdbc.Project2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Project2.VO.TBL_BuyListVo;


public class Tbl_BuyListDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

//주문하기 - 이름, 개수

public void orderMenu(String id, String fcode, int num){
    String sql ="INSERT INTO TBL_BUYLIST\r\n" + //
            "(IDX, ID, FCODE, QUANTITY, BUY_DATE)\r\n" + //
            "VALUES(LIST_SEQ.NEXTVAL, ?, ?, ?, TO_DATE(sysdate,'yyyy-mm-dd'))";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)
    ) { fcode.toUpperCase();
        pstmt.setString(1, id);
        pstmt.setString(2, fcode);
        pstmt.setInt(3, num);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println("주문하기 오류 " +e.getMessage());
    }

}

   
//삭제
    public void cancelOrder(int idx){
        String sql ="DELETE TBL_BUYLIST \r\n" + //
                "WHERE IDX = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql))
            {pstmt.setInt(1, idx);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("주문하기 오류 " +e.getMessage());
        }

    }

//주문수정 - IDX, 개수변경 

    public void modifyOrder(int idx, int quantity){
        String sql ="UPDATE TBL_BUYLIST \r\n" + //
                "SET QUANTITY = ?\r\n" + //
                "WHERE IDX = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql))
            {pstmt.setInt(1, quantity);
            pstmt.setInt(2, idx);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("주문하기 오류 " +e.getMessage());
        }

    }

    //구매내역
    public List<TBL_BuyListVo> buyHistory(String id){
        List<TBL_BuyListVo> list = new ArrayList<TBL_BuyListVo>();
        String sql = "SELECT IDX ,ID,FCODE ,QUANTITY ,BUY_DATE \r\n" + //
                "FROM TBL_BUYLIST\r\n" + //
                "WHERE ID =?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);    
        ) {pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new TBL_BuyListVo(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getInt(4),
                                            rs.getDate(5)));
            }
        } catch (SQLException e) {
            System.out.println("구매내역 조회 오류"+e.getMessage());
        }return list;

    }

}