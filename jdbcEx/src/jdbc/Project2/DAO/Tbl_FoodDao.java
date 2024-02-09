package jdbc.Project2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Project2.VO.TBL_FoodVo;

public class Tbl_FoodDao {
     public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

//메뉴 검색-이름 , 카테고리
public List<TBL_FoodVo> searchMenu_name(String user){
    List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
    String sql=null;
    sql = "SELECT *\r\n" + //
        "FROM TBL_FOOD\r\n" + //
        "WHERE FNAME LIKE '%'||?||'%'";   
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){pstmt.setString(1, user);
          ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
                list.add(new TBL_FoodVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getInt(6)));
        }  
    } catch (Exception e) {
        System.out.println("메뉴 이름 검색 오류 : "+e.getMessage());
    }
    return list;
}

public List<TBL_FoodVo> searchMenu_category(String category){
    List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
    String sql=null;
    sql = "SELECT *\r\n" + //
        "FROM TBL_FOOD\r\n" + //
        "WHERE CATEGORY = ?";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){pstmt.setString(1, category);
          ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
                list.add(new TBL_FoodVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getInt(6)));
        }  
    } catch (Exception e) {
        System.out.println("메뉴 - 카테고리 검색 오류 : "+e.getMessage());
    }
    return list;
}



//전체 메뉴 조회 - viewMenu
public List<TBL_FoodVo> viewMenu(){
    List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
    String sql = "SELECT * FROM TBL_FOOD";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();)
        {
        while (rs.next()) {
               list.add(new TBL_FoodVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getInt(6)));
        }  
    } catch (Exception e) {
        System.out.println("메뉴 검색 오류 : "+e.getMessage());
    }
    return list;
}



//저렴한 메뉴 추천 cheapbuger 

    
}
