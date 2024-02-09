package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {
    public static void main(String[] args) {
        //1)ojdbc11.jar 라이브러리 프로젝트에 추가
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String ur1 = "jdbc:oracle:thin:@//localhost:1521/XE"; //localhost는 서버의 ip가 될 수 있음
        String user = "C##IDEV";
        String password = "1234";

        try { //2) ojdbc11.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            //JAVA6부터 JBDC 4.0버전이 지원되고 그때부터 생략. DriveManger가 드라이버 클래스를 알아서 로드
            Class.forName(driver);  //런타임 시점에 지정된 클래스이름 로드
                                    //ClassNotFoundException 체크드 익셉션 ->처리필요

            //3) connection 구현 객체를 생성 - DriverManager는 드라이버 관리하는 유틸리티 클래스
            conn = DriverManager.getConnection(ur1, user, password);
            //SQLException 예외 처리 필요

            //connection 인터페이스에 대한 구현은 드라이버에 따라 정해짐
            System.out.println("데이터베이스 연결 객체: " +conn);
            if(conn !=null){
                System.out.println("Connection 객체의 구현 클랫: " + conn.getClass().getName()); //connection 구현 클래스 이름 확인 
                                                                                                //oracle.jdbc.driver.T4CConnection@20322d26는 오라클의 connection구현 클래스
                System.out.println("오라클 데이터 베이스 연결 성공");
            }
        }catch (Exception e) {
            System.out.println("오라클 데이터 베이스 연결 실패");
            System.out.println("예외 발생: "+e.getMessage());
        }finally{
            try {
                if(conn!=null) conn.close();
            } catch (Exception e) {}
        }



        
    }



}
