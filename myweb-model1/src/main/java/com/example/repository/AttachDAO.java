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
	} // addAttach

	//특정 게시글에 포함된 첨부파일 가져오기
	public List<AttachVO> getAttachesByBno(int bno) {
		List<AttachVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql += "SELECT * ";
			sql += " FROM attach ";
			sql += " WHERE bno = ? ";
			sql += " ORDER BY filetype, filename ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AttachVO attachVO = new AttachVO();
				attachVO.setUuid(rs.getString("uuid"));
				attachVO.setUploadpath(rs.getString("uploadpath"));
				attachVO.setFilename(rs.getString("filename"));
				attachVO.setFiletype(rs.getString("filetype"));
				attachVO.setBno(rs.getInt("bno"));

				list.add(attachVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}

		return list;
	} // getAttachesByBno
	
	//특정 게시글 번호에 해당하는 첨부파일들 삭제하기
	public void deleteAttachesByBno(int bno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "DELETE FROM attach WHERE bno = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}

	}// deleteAttachesByBno

} // boardDAO
