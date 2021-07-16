package com.example.repository;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.example.domain.MemberVO;

// 테스트케이스 클래스
public class MemberDAOTests {

	// 픽스처(fixture) : 멤버변수 처럼 기본적으로 있어야 하는 것들.
	private MemberDAO memberDAO;

	private MemberVO memberVO01;
	private MemberVO memberVO02;

	@Before
	public void setUp() {
		memberDAO = MemberDAO.getInstance();

		memberVO01 = new MemberVO("aaa", "1234", "홍길동", "aa@a.com", "Y", new Timestamp(System.currentTimeMillis()));
		memberVO02 = new MemberVO("bbb", "1234", "성춘향", "bb@b.com", "N", new Timestamp(System.currentTimeMillis()));

	}

	@Test
	public void testDeleteAll() {
		memberDAO.deleteAll();

		int count = memberDAO.getCountAll();

		assertEquals(0, count); // 메서드 검증. Assert 클래스
	}

	@Test
	public void testConnection() {

		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "MYUSER";
		String PASSWD = "1234";

		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계. JDBC 드라이버 로딩
			con = DriverManager.getConnection(URL, USER, PASSWD); // 2단계 . DB연결(접속)
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertNotNull(con);
		// assertNull - 객체가 null 일때 통과
		// assertNotNull - 객체가 널이 아닐때 통과

	} // testConnection

	@Test
	public void testInsertAndDeleteById() {
		memberDAO.deleteAll(); // 독립적으로 수행하기 위해 비우고 새로 테스트


		memberDAO.insert(memberVO01);
		assertEquals(1, memberDAO.getCountAll());

		memberDAO.insert(memberVO02);
		assertEquals(2, memberDAO.getCountAll());

		MemberVO dbMemberVO = memberDAO.getMemberById("bbb");
		assertEquals(memberVO02.getName(), dbMemberVO.getName());

		memberDAO.deleteById(memberVO02.getId());
		assertEquals(1, memberDAO.getCountAll());
	}

	@Test
	public void testUpdateById() {
		memberDAO.deleteAll();

		memberDAO.insert(memberVO01);
		
		MemberVO updateMember = new MemberVO("aaa", "4567", "이몽룡", "aa11@a.com", "N", new Timestamp(System.currentTimeMillis()));

		memberDAO.updateById(updateMember);
	
		MemberVO dbMember = memberDAO.getMemberById(updateMember.getId());
		
		assertEquals(updateMember.getName(), dbMember.getName());
		assertEquals(updateMember.getEmail(), dbMember.getEmail());

	} // testUpdateById
}
