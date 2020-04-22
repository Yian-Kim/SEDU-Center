package Student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
//반복될 것같은 코드들만 빼놓기!
	
	public Connection connect() {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@211.63.89.51:1521:xe";
		String id = "hr";
		String password = "java1234";
		
	
		try {		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url,id,password);
			
			return conn;									
		} catch (Exception e) {
			System.out.println("Connection : " + e.toString() );		
		}
		
		
		return null;
		

	}
	

	
	//오버로딩
	public Connection connect(String server, String id, String password) {
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@"+server+":1521:xe";

		
		try {		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url,id,password);
			
			return conn;									
		} catch (Exception e) {
			System.out.println("Connection : " + e.toString() );		
		}
		
		
		return null;
		

	}
	
}
