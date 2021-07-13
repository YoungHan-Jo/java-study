package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.OrderListVO;
import com.example.domain.OrderListVO;

public class OrderListDAO {

	private static OrderListDAO instance = new OrderListDAO();

	public static OrderListDAO getInstance() {
		return instance;
	}

	private OrderListDAO() {
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

	public void insertOrderList(OrderListVO orderListVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO orderlist(order_num, cno, menu, quantity, price, order_time) ");
			sql.append(" VALUES(SEQ_ORDERLIST.nextval, ?, ?, ?, ?, ?) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, orderListVO.getCno());
			pstmt.setString(2, orderListVO.getMenu());
			pstmt.setInt(3, orderListVO.getQuantity());
			pstmt.setInt(4, orderListVO.getPrice());
			pstmt.setString(5, orderListVO.getOrderTime());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}

	public int getQuantityByCno(String cno, String menu) {
		int quantity = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT sum(quantity) as quantity ");
			sql.append(" FROM orderlist ");
			sql.append(" WHERE cno = ? ");
			sql.append(" GROUP BY menu ");
			sql.append(" HAVING menu =  ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, cno);
			pstmt.setString(2, menu);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				quantity = rs.getInt("quantity");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return quantity;
	}
	
	public List<OrderListVO> getOrderList() {
		List<OrderListVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM orderlist ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderListVO orderListVO = new OrderListVO();
				orderListVO.setOrderNum(rs.getString("order_num"));
				orderListVO.setCno(rs.getString("cno"));
				orderListVO.setMenu(rs.getString("menu"));
				orderListVO.setQuantity(rs.getInt("quantity"));
				orderListVO.setPrice(rs.getInt("price"));
				orderListVO.setOrderTime(String.valueOf(rs.getTimestamp("order_time")));
				
				list.add(orderListVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

}
