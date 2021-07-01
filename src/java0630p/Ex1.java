package java0630p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex1 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";

		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, passwd);
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null)
					con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} // end of main

}
