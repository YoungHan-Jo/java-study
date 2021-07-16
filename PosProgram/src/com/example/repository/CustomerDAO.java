package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

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

	public int getCountAll() {

		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) AS cnt ");
			sql.append(" FROM customer ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return count;
	}

	public void deleteAll() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM customer ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

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

	public String getCnoByAdmission(String admission, String tableNum) {

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
			sql.append(" AND table_num = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, admission);
			pstmt.setString(2, tableNum);

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

	public int getAdultsByCno(String cno) {
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

	public int getKidsByCno(String cno) {
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

	public void updatePayment(String cno, String payment) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE customer ");
			sql.append(" SET payment = ? , exit_time = ?");
			sql.append(" WHERE cno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, payment);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			pstmt.setString(3, cno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public List<CustomerVO> getCustomers() {
		List<CustomerVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM CUSTOMER ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setCno(rs.getString("cno"));
				customerVO.setAdult(rs.getInt("adult"));
				customerVO.setKid(rs.getInt("kid"));
				customerVO.setPayment(rs.getInt("payment"));
				customerVO.setAdmission(String.valueOf(rs.getTimestamp("admission")));
				customerVO.setTableNum(rs.getString("table_num"));
				customerVO.setExitTime(String.valueOf(rs.getTimestamp("exit_time")));

				list.add(customerVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public CustomerVO getCustomerByAdmissionAndTNum(String admission, String tableNum) {
		CustomerVO customerVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM CUSTOMER ");
			sql.append(" WHERE admission = ? ");
			sql.append(" AND table_num = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, admission);
			pstmt.setString(2, tableNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				customerVO = new CustomerVO();
				customerVO.setCno(rs.getString("cno"));
				customerVO.setAdult(rs.getInt("adult"));
				customerVO.setKid(rs.getInt("kid"));
				customerVO.setPayment(rs.getInt("payment"));
				customerVO.setAdmission(String.valueOf(rs.getTimestamp("admission")));
				customerVO.setTableNum(rs.getString("table_num"));
				customerVO.setExitTime(String.valueOf(rs.getTimestamp("exit_time")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return customerVO;
	}

	public List<CustomerVO> getCustomerByCno(String cno) {
		List<CustomerVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM CUSTOMER ");
			sql.append(" WHERE cno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setCno(rs.getString("cno"));
				customerVO.setAdult(rs.getInt("adult"));
				customerVO.setKid(rs.getInt("kid"));
				customerVO.setPayment(rs.getInt("payment"));
				customerVO.setAdmission(String.valueOf(rs.getTimestamp("admission")));
				customerVO.setTableNum(rs.getString("table_num"));
				customerVO.setExitTime(String.valueOf(rs.getTimestamp("exit_time")));

				list.add(customerVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public List<CustomerVO> getCustomerByDate(String date) {
		List<CustomerVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM customer ");
			sql.append(" WHERE to_char(admission,'YYYYMMDD') = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, date);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setCno(rs.getString("cno"));
				customerVO.setAdult(rs.getInt("adult"));
				customerVO.setKid(rs.getInt("kid"));
				customerVO.setPayment(rs.getInt("payment"));
				customerVO.setAdmission(String.valueOf(rs.getTimestamp("admission")));
				customerVO.setTableNum(rs.getString("table_num"));
				customerVO.setExitTime(String.valueOf(rs.getTimestamp("exit_time")));

				list.add(customerVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public String getSalesTotal() {
		String salesTotal = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT sum(payment) as total");
			sql.append(" FROM customer ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				salesTotal = String.valueOf(rs.getInt("total"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return salesTotal;
	}

	public String getSalesMonth() {
		String salesMonth = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT sum(payment) as total");
			sql.append(" FROM customer ");
			sql.append(" WHERE TO_CHAR(exit_time,'YYYYMM') = TO_CHAR(SYSDATE,'YYYYMM') ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				salesMonth = String.valueOf(rs.getInt("total"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return salesMonth;
	}

	public String getSalesDay() {
		String salesDay = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT sum(payment) as total");
			sql.append(" FROM customer ");
			sql.append(" WHERE TO_CHAR(exit_time,'YYYYMMDD') = TO_CHAR(SYSDATE,'YYYYMMDD') ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				salesDay = String.valueOf(rs.getInt("total"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return salesDay;
	}

}
