package SS.bugerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SS.bugerVo.BuyListVo;


public class BuyListDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    
    //구매 메소드
    public int insList(BuyListVo vo){
        String sql = "INSERT INTO TBL_BUYLIST                "+ 
                     "VALUES(LIST_SEQ.NEXTVAL,?,?,?,sysdate)";
        int chk = 0;
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getFcode());
            pstmt.setInt(3, vo.getQuantity());    
            
            chk = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("주문 실행 예외 :" + e.getMessage());
        }
        return chk;
    }

    public int insertMany(List<BuyListVo> cart){                // 여러번 (cart 크기)의 insert 를 실행합니다.
        String sql="INSERT INTO TBL_BUYLIST \r\n" +             // 위의 insert 복붙하세요.
                   "VALUES (LIST_SEQ.nextval, ?,?,?,sysdate)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for(BuyListVo vo: cart){
                pstmt.setString(1, vo.getId());
                pstmt.setString(2, vo.getFcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();               // sql 을 batch 메소드로 메모리에 모아두었다가  for 문이 끝나면 executebatch 로 실행
                count++;
            }
        pstmt.executeBatch();       // 모아둔 sql 을 일괄 실행하기. 실행중에 무결성 오류 생기면
        conn.commit();              // catch에서 rollback
        }catch(SQLException e){     // 예외발생 : xmfoswortus cjfl
            try {
                conn.rollback();
            } catch (Exception e1) {}
            count = -1;
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외: " + e.getMessage());
        }finally{
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {}
        }
        return count;
    }


    //주문 취소 메소드
    public int delList(int idx){
        int chk = 0;
        String sql = "DELETE FROM TBL_BUYLIST "+
                     "WHERE idx = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idx);
            chk = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("주문 취소 실행 예외 : "+e.getMessage());
        }
        return chk;
    }

    public int upList(int idx,int quantity){
        int chk = 0;
        String sql = "UPDATE TBL_BUYLIST "+
                     "SET QUANTITY = ?   "+
                     "WHERE idx = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, idx);
            chk = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("주문 취소 실행 예외 : "+e.getMessage());
        }
        return chk;
    }
    public String selChk(int idx){
        String sql = "SELECT ID         "+ 
                     "FROM TBL_BUYLIST  "+
                     "WHERE IDX = ?";
        String chk = null;
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {       
                pstmt.setInt(1, idx);    
                
                ResultSet rs = pstmt.executeQuery();

                while(rs.next()){
                chk = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("주문 내역 조회 실행 예외 :" + e.getMessage());
        }
        return chk;
    }

    public List<BuyListVo> selList(String id){
        String sql = "SELECT *         "+ 
                     "FROM TBL_BUYLIST "+
                     "WHERE id = ?";
        List<BuyListVo> list = new ArrayList<>();
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) { 
                pstmt.setString(1, id);   
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                BuyListVo vo = new BuyListVo(rs.getInt(1),
                                             rs.getString(2), 
                                             rs.getString(3),
                                             rs.getInt(4),
                                             rs.getDate(5));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("주문 내역 조회 실행 예외 :" + e.getMessage());
        }
        return list;
    }
}
