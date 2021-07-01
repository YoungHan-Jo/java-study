package java0630p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import domain.MembersVO;

public class Ex5 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "hr";
		String passwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		MembersVO membersVO = new MembersVO();
		membersVO.setMemberId(1001);
		membersVO.setFirstName("길동");
		membersVO.setLastName("홍");
		membersVO.setGender("M");
		membersVO.setDob(new Timestamp(System.currentTimeMillis()));
		membersVO.setEmail("honggildong1@naver.com");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, passwd);
			
			String sql ="";
			sql +=" INSERT INTO members (member_id, first_name, last_name, gender, dob, email) ";
			sql +=" VALUES(?,?,?,?,?,?) ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membersVO.getMemberId());
			pstmt.setString(2, membersVO.getFirstName());
			pstmt.setString(3, membersVO.getLastName());
			pstmt.setString(4, membersVO.getGender());
			pstmt.setTimestamp(5, membersVO.getDob());
			pstmt.setString(6, membersVO.getEmail());
			
			int count = pstmt.executeUpdate();
			
			System.out.println("count : " + count);
			
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
