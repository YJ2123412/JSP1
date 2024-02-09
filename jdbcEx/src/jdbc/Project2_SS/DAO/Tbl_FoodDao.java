package jdbc.Project2_SS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Project2_SS.VO.TBL_FoodVo;

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
    public List<TBL_FoodVo> cheapbuger(){
        List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
        String sql= "SELECT *\r\n" + //
                    "FROM TBL_FOOD WHERE CATEGORY = 'BUGER' "+
                    "AND PRICE <= 5000 "+
                    "ORDER BY PRICE ASC";
        try (Connection connection = getConnection();
            PreparedStatement stmt= connection.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new TBL_FoodVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println("저렴한 메뉴 추천 오류"+e.getMessage());
        }return list;
    }
    
    public List<TBL_FoodVo> lowkcal(){
        List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
        String sql= "SELECT *\r\n" + //
                    "FROM TBL_FOOD tf \r\n" + //
                    "WHERE KAL <500 AND CATEGORY NOT IN ('SAUCE','TOPPING')\r\n" + //
                    "ORDER  BY KAL";
        try (Connection connection = getConnection();
            PreparedStatement stmt= connection.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new TBL_FoodVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println("저칼로리 제품 추천 오류"+e.getMessage());
        }return list;
    }
    
    public void random(){
        List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
        String sql= "SELECT *\r\n" + //
                    "FROM TBL_FOOD WHERE CATEGORY = 'BUGER' "+
                    "ORDER BY PRICE ASC";
        try (Connection connection = getConnection();
            PreparedStatement stmt= connection.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new TBL_FoodVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getInt(6)));    
            }
            int max=list.size();
            int a = (int)(Math.random() * max);  
            System.out.println(list.get(a)); 
        } catch (SQLException e) {
            System.out.println("랜덤 버거 추천 오류"+e.getMessage());
        }
    }

    public List<TBL_FoodVo> recommend(int select){
        List<TBL_FoodVo> list = new ArrayList<TBL_FoodVo>();
        if(select == 1) list = lowkcal();
        else if(select == 2) list = cheapbuger();
        else if(select == 3) random();
        return list;
    }
    public void print2(){
        System.out.println(String.format("\n%10s %19s %41s %8s %9s %8s","[코드]","[상품명]","[항목]","[가격]","[중량]","[칼로리]")+"\n");
    }


}