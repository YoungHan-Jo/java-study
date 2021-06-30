package java0630;

//SELECT* 
//FROM members
//WHERE member_id>=900
//AND gender = 'M'
//AND first_name LIKE '%M%'
//ORDER BY member_id DESC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ex4 {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "hr";
		String passwd = "1234";

		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null; 

		// 검색에 사용할 데이터(사용자가 입력하는 데이터로 가정함)
		int searchId = 900;
		String searchGender = "M";
		String searchFname = "m";

		try {
			// 1단계. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계 . DB연결(접속)
			con = DriverManager.getConnection(url, user, passwd);

			// 3단계. sql 생성
			//preparedStatement 방식으로
			String sql = ""; 
			sql = "SELECT * ";
			sql += " FROM members ";// 공백 들어가야함.
			sql += " WHERE member_id >= ? "; // <- 값 들어갈 부분에 ? 로 채워줌
			sql += " AND gender = ? "; // ''같은거 전부 떼야함
			sql += " AND first_name LIKE ? "; 
			sql += " ORDER BY member_id DESC ";
			

			// sql 문장객체 준비
			pstmt = con.prepareStatement(sql); // prepare Statement 는 sql문장을 미리요구함
			
			// pstmt의 ?자리에 데이터 설정
			pstmt.setInt(1, searchId); // 1번째 물음표 자리에
			pstmt.setString(2, searchGender); // '' 는 없어도 됨.
			pstmt.setString(3, "%"+searchFname+"%"); // %% 필요하기 때문에 넣어줌
			
			
			// 4단계 sql문 실행
			rs = pstmt.executeQuery(); // 이미 가지고 있어서 (sql)을 들고올 필요없음 

			// 5단계. rs 데이터를 꺼내서 사용
			// 행 단위로 가지고 옴,

			while (rs.next()) { 
				int memberId = rs.getInt("member_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String gender = rs.getString("gender");
				Date dob = rs.getDate("dob"); // getTimestamp 는 시,분,초 까지 다 나옴.
				String email = rs.getString("email");
				System.out.println(memberId + "\t" + firstName + ", " + lastName + ", " + gender + ", " + dob.toString()
						+ "," + email);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// JDBC 자원 닫기 ( 사용의 역순으로 닫음)

			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	} // end of main

}
