package java0630;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex1 {

	public static void main(String[] args) {
		// 데이터베이스 연동
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 127.0.0.1
		String user = "hr";
		String passwd = "1234";
		
		Connection con = null;
		
		try {
			// 1단계. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계. DB연결( DB주소, DB아이디 ,DB비밀번호)
			con = DriverManager.getConnection(url, user, passwd);
			System.out.println("연결 성공!");
						
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close(); // 입출력 작업 객체는 운영체제 자원을 사용하므로 썼으면 close로 자원을 메모리에서 내리기
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	} // end of main
}
