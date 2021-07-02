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

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "MYUSERPRAC";
	private final String PASSWD = "1234";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(URL, USER, PASSWD);

		return con;
	} // getConnection

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // close

	// =====================================================insert()=================================================

	public int insert(MemberVO memberVO) {
		int count = 0;
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

			count = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return count;
	} // insert
//=========================================================deleteAll()=================================================
	public int deleteAll() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "";
			sql += "DELETE FROM member ";
			pstmt = con.prepareStatement(sql);

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return count;
	} // deleteAll
	
//========================================================deleteById()=================================================
	public int deleteById(String id) {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql ="";
			sql += " DELETE FROM member ";
			sql += " WHERE id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			count = pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt);
		}
		return count;
	}

	
//===========================================================updateById()===================================================
	public int updateById(MemberVO memberVO) {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql ="";
			sql += " UPDATE member ";
			sql += " SET passwd = ?, name = ?, email = ?, recv_email = ?, reg_date = ? ";
			sql += " WHERE id = ? ";
						
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPasswd());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getRecvEmail());
			pstmt.setTimestamp(5, memberVO.getRegDate());
			pstmt.setString(6, memberVO.getId());
			
			count = pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt);
		}
		return count;
	}
		
//=========================================================getMemberById()=================================================
	public MemberVO getMemberById(String id) {
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "SELECT*FROM member WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setRecvEmail(rs.getString("recv_email"));
				memberVO.setRegDate(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return memberVO;
	} // getMemberById
	//========================================================getCountAll()=================================================
	public int getCountAll() {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "SELECT COUNT(*) AS cnt FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return count;
	} // getCountAll
	
//==============================================================getCountById==================================================
	public int getCountById(String id) {
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql ="";
			sql += " SELECT COUNT(*) ";
			sql += " FROM member ";
			sql += " WHERE id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
			return count;
	}
	
//==============================================================getMembers()=================================================
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String sql = "SELECT * FROM member ORDER BY name ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setRecvEmail(rs.getString("recv_email"));
				memberVO.setRegDate(rs.getTimestamp("reg_date"));

				list.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	} // getMembers

	//=======================================================================================================================================
	//=================================================================main()================================================================
	//=======================================================================================================================================
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		MemberVO member = new MemberVO();
		Random random = new Random();
		int count = 0;

		count = dao.deleteAll();
		System.out.println("delete 된 행 개수 : " + count);

		for (int i = 0; i < 10; ++i) {
			member.setId("user" + (i + 1));
			member.setPasswd("1234");
			member.setName("홍길동" + (i + 1));
			member.setEmail("aaa@a" + (i + 1) + ".com");
			member.setRecvEmail(random.nextBoolean() ? "Y" : "N");
			member.setRegDate(new Timestamp(System.currentTimeMillis()));

			count = dao.insert(member);
		}

		System.out.println("==================getMemberById()============================");
		MemberVO getMember = dao.getMemberById("user1");
		System.out.println(getMember.toString());
		System.out.println();
		System.out.println("===================getMembers()===============================");

		List<MemberVO> list = dao.getMembers();
		
		for (MemberVO m : list) {
			System.out.println(m.toString());
		}
		System.out.println();
		System.out.println("====================getCountAll()=======================");
		count = dao.getCountAll();
		System.out.println("전체 행 개수 : " + count);
		System.out.println();
		System.out.println("====================deleteById()=========================");
		int deleteCnt = dao.deleteById("user1");
		System.out.println("delete 된 행 개수 : " + deleteCnt);
		count = dao.getCountAll();
		System.out.println("전체 행 개수 : " + count);
		System.out.println();
		System.out.println("====================updateById()========================");
		int updateCnt = dao.updateById(member);
		System.out.println("update 된 행 개수 : "+updateCnt);
		count = dao.getCountAll();
		System.out.println("전체 행 개수 : " + count);
		System.out.println();
		System.out.println("====================getCountById===========================");
		count = dao.getCountById("user2");
		System.out.println("id 가 user2 인 행 개수 : " + count);
		
	} // end of main

}
