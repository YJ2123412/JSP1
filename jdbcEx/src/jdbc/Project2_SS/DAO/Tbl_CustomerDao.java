package jdbc.Project2_SS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tbl_CustomerDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

   public int login2(String id){
    String sql = "SELECT ID \r\n" + //
            "FROM TBL_CUSTOMER\r\n" + //
            "WHERE ID = ?";
    boolean idnum1=true;

    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
            
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        idnum1 = rs.next();
        
    } catch (SQLException e) {
        System.out.println("로그인 오류: "+e.getMessage());
    }
        if(idnum1 == true) return 1;
        else return 0;
   }


    
}
