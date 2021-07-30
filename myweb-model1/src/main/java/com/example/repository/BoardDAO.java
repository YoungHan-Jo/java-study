package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

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

	// board 테이블 모든 레코드 삭제
	public void deleteAll() {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "DELETE FROM board";

			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}

	}
	
	// 게시글 총 개수 가져오기
	public int getCountAll() {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = JdbcUtils.getConnection();
			
			String sql = "SELECT COUNT(*) AS cnt FROM board";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(con, pstmt, rs);
		}
		
		
		return count;
	}
	
	

	// SELECT IFNULL(MAX(num),0) + 1 AS nextnum FROM board
	public int getNextnum() {
		int num = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "SELECT IFNULL(MAX(num),0) + 1 AS nextnum FROM board";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt("nextnum");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}

		return num;
	} // getNextNum

	// 주글쓰기
	public void addBoard(BoardVO boardVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = JdbcUtils.getConnection();

			String sql = "";
			sql += " INSERT INTO board (num, mid, subject, content, readcount, reg_date, ipaddr, re_ref, re_lev, re_seq) ";
			sql += " VALUES (?,?,?,?,?,?,?,?,?,?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardVO.getNum());
			pstmt.setString(2, boardVO.getMid());
			pstmt.setString(3, boardVO.getSubject());
			pstmt.setString(4, boardVO.getContent());
			pstmt.setInt(5, boardVO.getReadcount());
			pstmt.setTimestamp(6, boardVO.getRegDate());
			pstmt.setString(7, boardVO.getIpaddr());
			pstmt.setInt(8, boardVO.getReRef());
			pstmt.setInt(9, boardVO.getReLev());
			pstmt.setInt(10, boardVO.getReSeq());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt);
		}

	}// addBoard
	
	
	public List<BoardVO> getBoards(){
		List<BoardVO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtils.getConnection();
			
			String sql = "";
			sql +="SELECT * ";
			sql +=" FROM board ";
			sql +=" ORDER BY re_ref DESC ";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setNum(rs.getInt("num"));
				boardVO.setMid(rs.getString("mid"));
				boardVO.setSubject(rs.getString("subject"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setRegDate(rs.getTimestamp("reg_date"));
				boardVO.setIpaddr(rs.getString("ipaddr"));
				boardVO.setReRef(rs.getInt("re_ref"));
				boardVO.setReLev(rs.getInt("re_lev"));
				boardVO.setReSeq(rs.getInt("re_seq"));
				
				list.add(boardVO);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}

		return list;
	}
	
	public List<BoardVO> getBoards(Criteria cri){
		List<BoardVO> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtils.getConnection();
			
			String sql = "";
			sql +="SELECT * ";
			sql +=" FROM board ";
			sql +=" ORDER BY re_ref DESC ";
			sql +=" LIMIT ?, ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cri.getStartRow());
			pstmt.setInt(2, cri.getAmount());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setNum(rs.getInt("num"));
				boardVO.setMid(rs.getString("mid"));
				boardVO.setSubject(rs.getString("subject"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setRegDate(rs.getTimestamp("reg_date"));
				boardVO.setIpaddr(rs.getString("ipaddr"));
				boardVO.setReRef(rs.getInt("re_ref"));
				boardVO.setReLev(rs.getInt("re_lev"));
				boardVO.setReSeq(rs.getInt("re_seq"));
				
				list.add(boardVO);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, pstmt, rs);
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} // boardDAO
