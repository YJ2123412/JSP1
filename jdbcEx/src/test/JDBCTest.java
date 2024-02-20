package test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TestConnection() {
		try (Connection conn = 
            	DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", 
                    "$ID",
                    "$PASSWORD")) {
        	log.info(conn);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
