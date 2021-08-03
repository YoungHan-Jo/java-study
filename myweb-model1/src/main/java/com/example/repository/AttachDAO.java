package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.AttachVO;
import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public class AttachDAO {

	private static AttachDAO instance;

	public static AttachDAO getInstance() {
		if (instance == null) {
			instance = new AttachDAO();
		}
		return instance;
	}

	private AttachDAO() {
	}

	// Attach 테이블 모든 레코드 삭제
	public void deleteAll() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "DELETE FROM attach";

			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}

	}// deleteAll
	
	public void addAttach(AttachVO attachVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql += " INSERT INTO attach (uuid, uploadpath, filename, filetype, bno) ";
			sql += " VALUES (?,?,?,?,?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, attachVO.getUuid());
			pstmt.setString(2, attachVO.getUploadpath());
			pstmt.setString(3, attachVO.getFilename());
			pstmt.setString(4, attachVO.getFiletype());
			pstmt.setInt(5, attachVO.getBno());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} // boardDAO
