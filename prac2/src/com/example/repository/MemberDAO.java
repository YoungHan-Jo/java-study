package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.domain.MemberVO;

public class MemberDAO {

	private static MemberDAO INSTANCE = new MemberDAO();

	public static MemberDAO getINSTANCE() {
		return INSTANCE;
	}

	private MemberDAO() {
	}

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "MYUSERPRAC";
	private final String PASSWD = "1234";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL, USER, PASSWD);

		return con;
	}

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
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
	}

	// ==========================================================deleteAll()============================================
	public int deleteAll() {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String sql = "DELETE FROM member";

			pstmt = con.prepareStatement(sql);
			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

		return count;
	}
	// ==============================================================insert()=====================================================

	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO member(id, passwd, name, email, recv_email, reg_date) ";
			sql += " VALUES(?,?,?,?,?,?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPasswd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getRecvEmail());
			pstmt.setTimestamp(6, memberVO.getRegDate());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	// ============================================================getMembers()==========================================================
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "SELECT * FROM member ORDER BY id";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setRecvEmail(rs.getString("recv_email"));
				member.setRegDate(rs.getTimestamp("reg_date"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	// ================================================================getCountAll()============================================
	private int getCountAll() {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "SELECT COUNT(*) AS cnt FROM member";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				count = rs.getInt("cnt");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// =============================================================deleteById()====================================================

	private void deleteById(String id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "DELETE FROM member WHERE id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	// =======================================================================================================================================
	// =================================================================main()================================================================
	// =======================================================================================================================================
	public static void main(String[] args) {

		MemberDAO dao = MemberDAO.getINSTANCE();
		MemberVO member = new MemberVO();

		System.out.println("=================deleteAll()======================");
		int deleteCnt = dao.deleteAll();
		System.out.println("delete 된 개수 : " + deleteCnt);

		// System.out.println("\n==================insert()========================");
		Random random = new Random();

		for (int i = 0; i < 10; ++i) {
			member.setId("user" + i);
			member.setPasswd("1234");
			member.setName("홍길동" + i);
			member.setEmail("aaa" + i + "@a.com");
			member.setRecvEmail(random.nextBoolean() ? "Y" : "N");
			member.setRegDate(new Timestamp(System.currentTimeMillis()));

			dao.insert(member);
		}
		System.out.println("\n=======================getMembers()=========================");
		List<MemberVO> list = dao.getMembers();
		for (MemberVO mb : list)
			System.out.println(mb.toString());

		System.out.println("\n======================getCountAll()=========================");
		int allCnt = dao.getCountAll();
		System.out.println("현재 행 개수 : " + allCnt);
		System.out.println("\n=======================deleteById()=============================");
		dao.deleteById("user0");
		allCnt = dao.getCountAll();
		System.out.println("현재 행 개수 : " + allCnt);

	}// end of main

}
