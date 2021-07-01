package java0630p;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2 {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 127.0.0.1
		String user = "hr";
		String passwd = "1234";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1단계. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계 . DB연결(접속)
			con = DriverManager.getConnection(url, user, passwd);
			// 3 단계. sql 생성
			String sql = "SELECT * FROM members ORDER BY member_id DESC ";
			
			// sql 문장 객체 준비
			stmt = con.createStatement();
			
			// 4단계 sql문 실행
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int memberId = rs.getInt("member_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String gender = rs.getString("gender");
				Date dob = rs.getDate("dob"); // getTimestamp 는 시,분,초 까지 다 나옴.
				String email = rs.getString("email");
				System.out.println(memberId + "," + firstName + "," + lastName + "," + gender + "," + dob.toString()
						+ "," + email);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	} // end of main

}
