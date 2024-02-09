package jdbc.Project2_SS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Project2_SS.VO.TBL_BuyListVo;


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

public int orderMenu2(String id, String fcode, int num){
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
    return 1;
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
        String sql = "SELECT IDX ,ID, FNAME, TBL_BUYLIST.FCODE ,QUANTITY ,BUY_DATE \r\n" + //
                        "FROM TBL_BUYLIST\r\n" + //
                        "JOIN TBL_FOOD\r\n" + //
                        "ON TBL_BUYLIST.FCODE = TBL_FOOD.FCODE\r\n" + //
                        "WHERE ID = ?";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);    
        ) {pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new TBL_BuyListVo(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getInt(5),
                                            rs.getDate(6)));
            }
        } catch (SQLException e) {
            System.out.println("구매내역 조회 오류"+e.getMessage());
        }return list;

    }

  //세트메뉴 구매확인
  public int buyHistory2(String pcode){
    boolean run1 = true;
    String sql = "SELECT FCODE\r\n" + //
                "FROM TBL_FOOD \r\n" + //
                "WHERE FCODE = ?";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);    
    ) {pstmt.setString(1, pcode);
        ResultSet rs = pstmt.executeQuery();
        run1 = rs.next();
    } catch (SQLException e) {
        System.out.println("구매내역 조회 오류"+e.getMessage()
        );
    } if(run1==true) return 1;
    else return 0;

}
//세트구매
public int insertMany (List<TBL_BuyListVo> cart){ 
    String sql = "INSERT INTO TBL_BUYLIST (IDX, ID, FCODE, QUANTITY, BUY_DATE)\r\n" + //
                "VALUES(LIST_SEQ.NEXTVAL, ?, ?, ?, TO_DATE(sysdate,'yyyy-mm-dd'))";
    int count =0;
    Connection connection=null;
    PreparedStatement pstmt=null;

    try {connection = getConnection();      
        pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);  
            for(TBL_BuyListVo vo:cart){
                pstmt.setString(1, vo.getId());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();
                count++;
                }
                pstmt.executeBatch();   
                connection.commit();
        } catch (SQLException e) { 
            try {             
                connection.rollback();
               
            } catch (Exception e1) {}
            count= -1;  
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외 발생 : " + e.getMessage());
         }finally{  
            try{    
                pstmt.close();
                connection.close();
            }catch (Exception e1) {}
        }
    return count;
    } 
  
}