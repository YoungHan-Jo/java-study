package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.domain.MemberVO;

// DAO(Data Access Object) : 데이터 접근 오브젝트 역할

public class MemberDAO {
	// DB접속
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "MYUSER";
	private final String PASSWD = "1234";

	// DB접속 후 커넥션 객체 가져오는 메소드
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// 호출하는곳에서 try 직접처리 하고 있기 때문에 던지기
		Connection con = null;

		// 1단계. JDBC 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2단계 . DB연결(접속)
		con = DriverManager.getConnection(URL, USER, PASSWD);

		return con;
	}

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try { // catch 는
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // close()

//===================================insert()=====================================================
	public int insert(MemberVO memberVO) {
		int count = 0;

		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장 객체 타입

		try {
			con = getConnection(); // 1,2 단계 수행

			// 3단계.
			String sql = ""; // null보다는 빈 문자열로 초기화
			sql = "INSERT INTO member(id, passwd, name, email, recv_email, reg_date) ";
			sql += " VALUES(?,?,?,?,?,?) ";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPasswd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getRecvEmail());
			pstmt.setTimestamp(6, memberVO.getRegDate());

			// 4단계. sql문 실행
			count = pstmt.executeUpdate(); // 여기에 sql 넣으면 다시 ??? 들어있는거 불러와서 안됨.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return count;
	} // insert()

	// ============================================deleteAll()============================================
	public int deleteAll() {
		int count = 0;

		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장 객체 타입

		try {
			con = getConnection();

			String sql = "DELETE FROM member";

			// 3단계. pstmt 문장객체 생성
			pstmt = con.prepareStatement(sql);

			// 4단계. sql 문장 실행
			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return count;
	}

//=============================================deleteById()====================================================

//	DELETE FROM member
//	WHERE id = ?;
	public int deleteById(String id) {
		int count = 0;

		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장 객체 타입

		try {
			con = getConnection();

			String sql = "";
			sql += " DELETE FROM member ";
			sql += " WHERE id = ? ";

			// 3단계. pstmt 문장객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			// 4단계. sql 문장 실행
			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return count;
	}// deleteById()

	// ===================================================updateById()======================================================
	// UPDATE member
	// SET passwd = ?, name = ?, email = ?, recv_email = ?, reg_date = ?
	// WHERE id = ? ;

	public int updateById(MemberVO memberVO) {
		int count = 0;

		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장 객체 타입

		try {
			con = getConnection();
			String sql = "";
			sql += " UPDATE member ";
			sql += " SET passwd = ?, name = ?, email = ?, recv_email = ?, reg_date = ? ";
			sql += " WHERE id = ? ";
			// 3단계. pstmt 문장객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "4321");
			pstmt.setString(2, "성춘향");
			pstmt.setString(3, "bbb@b.com");
			pstmt.setString(4, "N");
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(6, "user9");

			// 4단계. sql 문장 실행
			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return count;
	}// updateById()

	
	// SELECT COUNT(*)
	// FROM member
	// WHERE id = ?
	
	// ==============================================getCountById==========================================

	public int getCountById(String id) {
		int count = 0;
		
		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "";
			sql += " SELECT COUNT(*) ";
			sql += " FROM member ";
			sql += " WHERE id = ? ";
						
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); // rs.getInt("cnt")

			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return count;
	}

	// ==============================================getCountAll============================================

	// SELECT COUNT(*) AS cnt FROM member ;
	public int getCountAll() {
		int count = 0;

		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) AS cnt FROM member ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1); // rs.getInt("cnt")

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return count;
	}

	// ===========================================================================================
	// SELECT * FROM member WHERE id = 'bbb' ;
	// 기본키 컬럼값을 기준으로 레코드(행) 최대 1개 가져오기
	public MemberVO getMemberById(String id) {
		MemberVO memberVO = null;

		// 스레드 사용시 동시성 문제 때문에 지역변수로 작성. 객체를 따로따로 사용해야하기위함 .
		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "SELECT * FROM member WHERE id = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 코드가 하나일때는 if로 표현 함.
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setRecvEmail(rs.getString("recv_email"));
				memberVO.setRegDate(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return memberVO;
	}

	// SELECT * FROM member ORDER BY name
	// 가져와서 리스트에 담기.
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();

		// 스레드 사용시 동시성 문제 때문에 지역변수로 작성. 객체를 따로따로 사용해야함.
		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "SELECT * FROM member ORDER BY name ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setRecvEmail(rs.getString("recv_email"));
				memberVO.setRegDate(rs.getTimestamp("reg_date"));

				list.add(memberVO); // list에 <- 생성된 memberVO를 담기
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return list;
	}

	// 테스트용 main메소드
	public static void main(String[] args) {
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO();

		// member 테이블 내용(행) 전체 삭제하기
		int count = dao.deleteAll();
		System.out.println("delete 된 행 개수 : " + count);

		Random random = new Random();

		for (int i = 0; i < 10; ++i) {
			// MemberVO 샘플 데이터 준비
			member.setId("user" + (i + 1));
			member.setPasswd("1234");
			member.setName("홍길동" + (i + 1));
			member.setEmail("aaa@a" + (i + 1) + ".com");
			member.setRecvEmail((random.nextBoolean()) ? "Y" : "N");
			member.setRegDate(new Timestamp(System.currentTimeMillis()));
			// insert 메소드 테스트하기
			count = dao.insert(member);
		} // for

		System.out.println("insert 된 행 개수 : " + count);

		// getMemberById 메소드 테스트
		MemberVO dbMember = dao.getMemberById("user1");
		System.out.println(dbMember.toString());

		System.out.println("==============================");

		List<MemberVO> list = dao.getMembers();
		for (MemberVO m : list) {
			System.out.println(m.toString());
		}

		count = dao.getCountAll();

		System.out.println("전체 행 개수 : " + count);

		System.out.println("=============user1 행 삭제=====================");

		int deleteCnt = dao.deleteById("user1");
		System.out.println("삭제된 행 개수 : " + deleteCnt);
		count = dao.getCountAll();
		System.out.println("전체 행 개수 : " + count);

		System.out.println("=============== 행 수정 ===========================");

		int updateCnt = dao.updateById(member);
		System.out.println("변경된 행 개수 : " + updateCnt);
		count = dao.getCountAll();
		System.out.println("전체 행 개수 : " + count);
		
		System.out.println("======================");
		
		int countById = dao.getCountById("user10");
		System.out.println(countById);

		System.out.println("==테스트 종료==");

	}

}
