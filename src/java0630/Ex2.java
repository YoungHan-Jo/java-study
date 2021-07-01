package java0630;

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

		Connection con = null; // 접속. connection을 기준으로 statement,resultset를 만든다.
		Statement stmt = null; // sql 문장객체 타입 / 인터페이스라서 new로 만드는게 아니다
		ResultSet rs = null; // select문 실행 결과를 담고 있는 결과집합 타입

		try {
			// 1단계. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계 . DB연결(접속)
			con = DriverManager.getConnection(url, user, passwd);

			// 3단계. sql 생성
			String sql = "SELECT* FROM MEMBERS ORDER BY MEMBER_ID DESC"; // sql문장에는 세미콜론 없어야함

			// sql 문장객체 준비
			stmt = con.createStatement();

			// 4단계 sql문 실행
			rs = stmt.executeQuery(sql); // sql select 문이 DB서버에 전송 후 결과를 ResultSet 타입으로 받음

			// 5단계. rs 데이터를 꺼내서 사용
			// 행 단위로 가지고 옴,

			while (rs.next()) { // 커서를 다음 행으로 옮겨서 행의 유무에 따라 true/false로 리턴
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
		} finally {
			// JDBC 자원 닫기 ( 사용의 역순으로 닫음)

			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	} // end of main

}
