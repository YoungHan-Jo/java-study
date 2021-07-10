package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.example.domain.CustomerVO;

public class CustomerDAO {

	private static CustomerDAO instance = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return instance;
	}

	private CustomerDAO() {
	}

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "mypos";
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

	public void insertCustomer(CustomerVO customerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO customer(cno, adult, kid, admission,table_num) ");
			sql.append(" VALUES (SEQ_CUSTOMER.nextval,?,?,?,?) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, customerVO.getAdult());
			pstmt.setInt(2, customerVO.getKid());
			pstmt.setString(3, customerVO.getAdmission());
			pstmt.setString(4, customerVO.getTableNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public String getCnoByAdmission(String admission) {

		String cno = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT cno ");
			sql.append(" FROM customer ");
			sql.append(" WHERE admission = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, admission);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				cno = rs.getString("cno");
			} else
				System.out.println("없음");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return cno;
	}

	public void deleteCustomerByCno(String cno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "DELETE FROM customer WHERE cno = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public int getAdultByCno(String cno) {
		int adult = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT adult ");
			sql.append(" FROM customer ");
			sql.append(" WHERE cno = ?  ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				adult = rs.getInt("adult");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return adult;
	}

	public int getKidByCno(String cno) {
		int kid = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT kid ");
			sql.append(" FROM customer ");
			sql.append(" WHERE cno = ?  ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				kid = rs.getInt("kid");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return kid;
	}

}
