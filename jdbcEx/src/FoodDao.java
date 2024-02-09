package SS.bugerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SS.bugerVo.BuyListVo;
import SS.bugerVo.FoodVo;
import oracle.jdbc.OracleDriver;

public class FoodDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";
    

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //전체 메뉴 검색 데이터
    public List<FoodVo> selAll(){
        String sql = "SELECT * "+
                     "FROM TBL_FOOD";
        List<FoodVo> list = new ArrayList<>();                
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
                FoodVo vo = new FoodVo(rs.getString(1),
                                       rs.getString(2),
                                       rs.getString(3),
                                       rs.getInt(4),
                                       rs.getInt(5),
                                       rs.getInt(6));
                list.add(vo);
            } 
        } catch (SQLException e) {
            System.out.println("버거 출력 실행 예외: " + e.getMessage());
        }
        return list;
    }

    //저렴한 버거 데이터 추출
    public void cheapsbuger(){
        String sql = "SELECT * "+
                     "FROM TBL_FOOD WHERE CATEGORY = 'BUGER' "+
                     "AND PRICE <= 5000 "+
                     "ORDER BY PRICE ASC";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                FoodVo vo = new FoodVo(rs.getString(1),
                                       rs.getString(2),
                                       rs.getString(3),
                                       rs.getInt(4),
                                       rs.getInt(5),
                                       rs.getInt(6));
                                       System.out.println(vo);
            } 
        } catch (SQLException e) {
            System.out.println("버거 출력 실행 예외: " + e.getMessage());
        }
    }

    // 저칼로리 버거 데이터 추출
    public void lowkcal(){
        String sql = "SELECT * "+
                     "FROM TBL_FOOD WHERE CATEGORY = 'BUGER' "+
                     "AND KAL < 400 "+
                     "ORDER BY KAL ASC";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                FoodVo vo = new FoodVo(rs.getString(1),
                                       rs.getString(2),
                                       rs.getString(3),
                                       rs.getInt(4),
                                       rs.getInt(5),
                                       rs.getInt(6));
                                       System.out.println(vo);
            } 
        } catch (SQLException e) {
            System.out.println("버거 출력 실행 예외: " + e.getMessage());
        }
    }
    public List<FoodVo> selCategory(String category){                      
        String sql = "SELECT * "+ 
                     "FROM TBL_FOOD "+
                     "WHERE CATEGORY = ?";
        List<FoodVo> list = new ArrayList<>();

        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                   FoodVo vo = new FoodVo(rs.getString(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getInt(4),
                                          rs.getInt(5),
                                          rs.getInt(6));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("실행 예외 :" + e.getMessage());
        }
        return list;
    }
    public String foodChk(String code){
        String sql ="SELECT FCODE "+
                    "FROM TBL_FOOD "+
                    "WHERE FCODE = ?";
        String chk = null;
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                chk = rs.getString(1);
            };
        } catch (Exception e) {
            // TODO: handle exception
        }
        return chk;
    }
    public List<FoodVo> selCode(String fcode){                      
        String sql = "SELECT * "+ 
                     "FROM TBL_FOOD "+
                     "WHERE FCODE LIKE '%'||?||'%'";
        List<FoodVo> list = new ArrayList<>();

        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fcode.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                   FoodVo vo = new FoodVo(rs.getString(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getInt(4),
                                          rs.getInt(5),
                                          rs.getInt(6));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("실행 예외 :" + e.getMessage());
        }
        return list;
    }
    public List<FoodVo> selName(String FNAME){                      
        String sql = "SELECT * "+ 
                     "FROM TBL_FOOD "+
                     "WHERE FNAME LIKE '%'||?||'%'";
        List<FoodVo> list = new ArrayList<>();

        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, FNAME.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                   FoodVo vo = new FoodVo(rs.getString(1),
                                          rs.getString(2),
                                          rs.getString(3),
                                          rs.getInt(4),
                                          rs.getInt(5),
                                          rs.getInt(6));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println("실행 예외 :" + e.getMessage());
        }
        return list;
    }
}
