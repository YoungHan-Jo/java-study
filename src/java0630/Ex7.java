package java0630;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import domain.MembersVO;

//DELETE FROM members
//WHERE member_id = ?;

public class Ex7 {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "1234";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 수정(UPDATE)에 사용할 데이터(사용자가 입력하는 데이터로 가정함)
		MembersVO membersVO = new MembersVO();
		membersVO.setMemberId(1001);
		membersVO.setFirstName("춘향");
		membersVO.setLastName("성");
		membersVO.setGender("F");
		membersVO.setDob(new Timestamp(System.currentTimeMillis()));
		membersVO.setEmail("sungchunhyang@daum.net");

		try {
			// 1단계. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계 . DB연결(접속)
			con = DriverManager.getConnection(url, user, passwd);

			// 3단계. sql 생성
			// preparedStatement 방식으로
			String sql = "";
			sql = "DELETE FROM members ";
			sql += " WHERE member_id = ? ";
			
			// sql 문장객체 준비
			pstmt = con.prepareStatement(sql); // prepare Statement 는 sql문장을 미리요구함

			// pstmt의 ?자리에 데이터 설정

			pstmt.setInt(1, membersVO.getMemberId());

			// 4단계 sql문 실행
			int count = pstmt.executeUpdate(); // preparedStatement는 (sql)를 이미 가지고 있음
			// 변경된 행의 갯수 리턴
			// pstmt.executeQuery(); <- 질의, select에만 사용
			// pstmt.executeUpdate(); <- 갱신, insert,update,delete
			System.out.println("count : " + count);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// JDBC 자원 닫기 ( 사용의 역순으로 닫음)

			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	} // end of main

}
