package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.MemberVO;

// DAO(Data Access Object) : 데이터 접근 오브젝트 역할

public class MemberDAO {

	// 싱글톤(singleton) 클래스 설계 : 객체만 한개만 공유해서 사용하기
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() { // 외부에서 호출할때 이 메소드 사용
		return instance;
	}

	private MemberDAO() {
	}

// 오라클 DB접속
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private final String USER = "MYUSER";
//	private final String PASSWD = "1234";

	// MySQl DB접속
	private final String URL = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
	private final String USER = "jspid";
	private final String PASSWD = "jsppass";

	private Connection getConnection() throws ClassNotFoundException, SQLException {// 호출하는곳에서 try 직접처리 하고 있기 때문에 던지기

		Connection con = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

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

//==============================================================insert()=====================================================
	public void insert(MemberVO memberVO) {
		

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO member(id, passwd, name, birthday, gender, email, recv_email, reg_date) ";
			sql += " VALUES(?,?,?,?,?,?,?,?) ";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPasswd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getBirthday());
			pstmt.setString(5, memberVO.getGender());
			pstmt.setString(6, memberVO.getEmail());
			pstmt.setString(7, memberVO.getRecvEmail());
			pstmt.setTimestamp(8, memberVO.getRegDate());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		
	} // insert()

	// ==========================================================deleteAll()============================================
	public void deleteAll() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "DELETE FROM member";

			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

//=============================================================deleteById()====================================================

	public void deleteById(String id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += " DELETE FROM member ";
			sql += " WHERE id = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}// deleteById()

	// =====================================================updateById()======================================================

	public void updateById(String id, MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			StringBuilder sb = new StringBuilder(); // 쓰레기 객체(String으로 계속 만드는거) 방지.
			sb.append(" UPDATE member ");
			sb.append(" SET passwd = ?, name = ?, birthday = ?, gender = ?, email = ?, recv_email = ?, reg_date = ? ");
			sb.append(" WHERE id = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, memberVO.getPasswd());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getBirthday());
			pstmt.setString(4, memberVO.getGender());
			pstmt.setString(5, memberVO.getEmail());
			pstmt.setString(6, memberVO.getRecvEmail());
			pstmt.setTimestamp(7, memberVO.getRegDate());
			pstmt.setString(8, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}// updateById()

	// =================================================================getMemberById()================================================

	public MemberVO getMemberById(String id) {
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "SELECT * FROM member WHERE id = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setBirthday(rs.getString("birthday"));
				memberVO.setGender(rs.getString("gender"));
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

	// ================================================================getCountAll()============================================

	public int getCountAll() {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) AS cnt FROM member ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return count;
	}

	// ======================================================================getCountById()==========================================

	public int getCountById(String id) {
		int count = 0;

		Connection con = null; // 접속
		PreparedStatement pstmt = null;
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
				count = rs.getInt("COUNT(*)");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return count;
	}

	// ============================================================getMembers()==========================================================

	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
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
				memberVO.setBirthday(rs.getString("birthday"));
				memberVO.setGender(rs.getString("gender"));
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

}
