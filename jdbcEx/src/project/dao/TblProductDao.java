package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.ProductVo;

public class TblProductDao {
     public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


public List<ProductVo> selectAll(){
        List<ProductVo> list = new ArrayList<ProductVo>();
        String sql ="SELECT DISTINCT * FROM TBL_PRODUCT";
        try (Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(sql);)
            {
            pstmt.executeUpdate();
            while(rs.next()){
                list.add(new ProductVo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
                    
                }
            }
            catch (SQLException e) {
                System.out.println("join 실행 예외 발생 : " + e.getMessage());
            }
           return list;
        }



public List<ProductVo> selectByCategeory(String category){
    List<ProductVo> list = new ArrayList<ProductVo>();
    String sql ="SELECT DISTINCT * FROM  TBL_PRODUCT WHERE CATEGORY = ? ORDER BY PNAME";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        )
        {pstmt.setString(1, category);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
                list.add(new ProductVo(rs.getString(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getInt(4)));
            }
        }
        catch (SQLException e) {
            System.out.println("카테고리 상품 실행 예외 발생 : " + e.getMessage());
        }
       return list;
    }




public List<ProductVo> selectByPname(String pname){
    List<ProductVo> list = new ArrayList<ProductVo>();
    String sql ="SELECT *FROM TBL_PRODUCT tp WHERE PNAME LIKE '%'||?||'%'";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);)
        {pstmt.setString(1, pname);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
                list.add(new ProductVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        }
        catch (Exception e) {
            System.out.println("이름 검색 실행 예외 발생 : " + e.getMessage());
        }
       return list;
    }
}





