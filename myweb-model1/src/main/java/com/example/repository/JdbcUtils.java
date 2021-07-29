package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {

	public static final String URL = "jdbc:mysql://localhost:3306/jspdb?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
	public static final String USER = "jspid";
	public static final String PASSWD = "jsppass";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {// 호출하는곳에서 try 직접처리 하고 있기 때문에
																							// 던지기

		Connection con = null;

		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(URL, USER, PASSWD);

		return con;
	}

	public static void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
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
}
