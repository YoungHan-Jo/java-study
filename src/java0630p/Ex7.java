package java0630p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//DELETE FROM members
//WHERE member_id = ?;

public class Ex7 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, passwd);
			
			String sql = "";
			sql +=" DELETE FROM members ";
			sql +=" WHERE member_id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1001);
			
			int count = pstmt.executeUpdate();
			
			System.out.println("삭제한 행 개수 : " + count);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	} // end of main

}
