package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {

	private static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	private BoardDAO() {
	}

	// SELECT IFNULL(MAX(num),0) + 1 AS nextnum FROM board
	public int getNextnum() {
		int num = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			JdbcUtils.getConnection();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return num;
	}
	
	public void addBoard() {

	}// addBoard

}
