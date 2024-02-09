package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionUtil {
    public static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/XE";
    public static final String USERNAME ="C##IDEV";
    private static final String PASSWORD= "1234";


    //connection 타입 객체 생성하는 메소드
    //Connection conn = OracleConnectionUtil.getConnection();  로 사용할 것
    public static Connection getConnection(){
         Connection conn = null;
        try { 
            Class.forName(DRIVER);  
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(Exception e){
            System.out.println("데이터베이스 연결 예외 발생했습니다. \n\t : "+e.getMessage());
        }
        return conn;
    }
    //실행순서: 1)getConnection  2)sql 실행  3) close 
    //SQL 실행: 개발프로그램에서 가장 많이 실행하는 SQL은 DML(select,insert,delect,update)
    //          OracleConnectionUtil는 1, 3 단계에서 사용될 것



    //인자로 전달된 connection 객체를 close. sql 실행이 종료되면 close 해야 함.
    public static void close(Connection conn){
        try {
            if(conn !=null) conn.close();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 해제 예외 발생\n\t: "+e.getMessage());
        }
    }

}
