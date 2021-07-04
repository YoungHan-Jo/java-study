package java0630pp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex3 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 127.0.0.1
		String user = "hr";
		String passwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, passwd);
			
			String sql = "";
			sql += "SELECT * ";
			sql += " FROM members ";
			sql += " WHERE member_id >= ? ";
			sql += " AND gender = ? ";
			sql += " AND first_name LIKE ? ";
			sql += " ORDER BY member_id DESC ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 900);
			pstmt.setString(2, "M");
			pstmt.setString(3, "%m%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int memberId = rs.getInt("member_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String gender = rs.getString("gender");
				Date dob = rs.getDate("dob"); // getTimestamp 는 시,분,초 까지 다 나옴.
				String email = rs.getString("email");
				System.out.println(memberId + "\t" + firstName + "," + lastName + "," + gender + "," + dob.toString()
						+ "," + email);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
