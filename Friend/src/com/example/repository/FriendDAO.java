package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.FriendVO;

public class FriendDAO {

	private static FriendDAO instance = new FriendDAO();

	public static FriendDAO getInstance() {
		return instance;
	}

	private FriendDAO() {
	}

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "MYUSER";
	private final String PASSWD = "1234";

	private Connection getConnection() throws ClassNotFoundException, SQLException {// 호출하는곳에서 try 직접처리 하고 있기 때문에 던지기

		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계. JDBC 드라이버 로딩

		con = DriverManager.getConnection(URL, USER, PASSWD); // 2단계 . DB연결(접속)

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

	public void insertFriend(FriendVO friendVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO friend(num, name, birth, phone, address, reg_date) ";
			sql += " VALUES(seq_friend.nextval, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, friendVO.getName());
			pstmt.setString(2, friendVO.getBirth());
			pstmt.setString(3, friendVO.getPhone());
			pstmt.setString(4, friendVO.getAddress());
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public void updateFriend(FriendVO friendVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String str = "";
			str += "UPDATE friend ";
			str += " SET name = ?, birth = ?, phone = ?, address = ?, reg_date = ? ";
			str += " where num = ? ";

			pstmt = con.prepareStatement(str);
			pstmt.setString(1, friendVO.getName());
			pstmt.setString(2, friendVO.getBirth());
			pstmt.setString(3, friendVO.getPhone());
			pstmt.setString(4, friendVO.getAddress());
			pstmt.setTimestamp(5, friendVO.getRegDate());
			pstmt.setInt(6, friendVO.getNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public List<FriendVO> getFriends() {
		List<FriendVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "SELECT * FROM friend ORDER BY num ";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				FriendVO friendVO = new FriendVO();
				friendVO.setNum(rs.getInt("num"));
				friendVO.setName(rs.getString("name"));
				friendVO.setBirth(rs.getString("birth"));
				friendVO.setPhone(rs.getString("phone"));
				friendVO.setAddress(rs.getString("address"));
				friendVO.setRegDate(rs.getTimestamp("reg_date"));

				list.add(friendVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public void deleteFriendByNum(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "DELETE FROM friend ";
			sql += "WHERE num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public List<FriendVO> searchFriend(int index, String value) {

		List<FriendVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String condition = "";

		if (index == 1)
			condition = "name";
		else if (index == 2)
			condition = "address";
		else {
			System.out.println("selectedIndex error");
		}

		try {
			con = getConnection();

			String sql = "";
			sql += "SELECT * ";
			sql += " FROM friend ";
			sql += " WHERE " + condition + " LIKE ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + value + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				FriendVO friendVO = new FriendVO();
				friendVO.setNum(rs.getInt("num"));
				friendVO.setName(rs.getString("name"));
				friendVO.setBirth(rs.getString("birth"));
				friendVO.setPhone(rs.getString("phone"));
				friendVO.setAddress(rs.getString("address"));
				friendVO.setRegDate(rs.getTimestamp("reg_date"));

				list.add(friendVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return list;
	}

}
