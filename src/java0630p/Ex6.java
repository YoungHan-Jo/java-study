package java0630p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import domain.MembersVO;

//UPDATE members
//SET first_name = ?, last_name = ?, gender = ?, dob = ?, email = ?
//WHERE member_id = ?;


public class Ex6 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		MembersVO membersVO = new MembersVO();
		membersVO.setMemberId(1001);
		membersVO.setFirstName("춘향");
		membersVO.setLastName("성");
		membersVO.setGender("F");
		membersVO.setDob(new Timestamp(System.currentTimeMillis()));
		membersVO.setEmail("sungchunhyang@daum.net");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, passwd);
			
			String sql ="";
			sql +=" UPDATE members ";
			sql +=" SET first_name = ?, last_name = ?, gender = ?, dob = ?, email = ? ";
			sql +=" WHERE member_id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, membersVO.getFirstName());
			pstmt.setString(2, membersVO.getLastName());
			pstmt.setString(3, membersVO.getGender());
			pstmt.setTimestamp(4, membersVO.getDob());
			pstmt.setString(5, membersVO.getEmail());
			pstmt.setInt(6, membersVO.getMemberId());
			
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
