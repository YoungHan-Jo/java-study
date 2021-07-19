package com.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.example.domain.MemberVO;

public class MemberMapDAOTests {

	// 픽스처
	private MemberMapDAO dao;
	MemberVO member1;
	MemberVO member2;

	@Before
	public void setUp() {
		dao = new MemberMapDAO();
		dao.deleteAll();

		member1 = new MemberVO("aaa", "1234", "홍길동", "aa@a.com", "Y", new Timestamp(System.currentTimeMillis()));
		member2 = new MemberVO("bbb", "1234", "성춘향", "bb@b.com", "N", new Timestamp(System.currentTimeMillis()));

	}

	@Test
	public void testDeleteAll() {
		dao.deleteAll();

		assertEquals(0, dao.getCountAll());
	}

	@Test
	public void testGetMembers() throws Exception { // 테스트에서 알아서 처리해주니까 던지면 됨.

		Object[] memberArr = { member1, member2 };

		dao.insert(member1);
		dao.insert(member2);

		Collection<MemberVO> collection = dao.getMembers();
		Object[] collectionArr = collection.toArray(); // 콜렉션을 배열화 하기

		assertArrayEquals(memberArr, collectionArr); // 배열안의 내용비교

	}

	@Test
	public void testGetMemberById() throws Exception {

		dao.insert(member1);
		dao.insert(member2);

		MemberVO dbMember = dao.getMemberById(member1.getId());

		assertEquals(member1.toString(), dbMember.toString());

	}

	@Test
	public void testInsert() throws Exception {
		dao.insert(member1);
		dao.insert(member2);

		MemberVO dbMember = dao.getMemberById(member1.getId());

		assertEquals(member1.toString(), dbMember.toString());
	}

	@Test
	public void testUpdateById() throws Exception {

		dao.insert(member1);

		MemberVO member = new MemberVO("aaa", "1111", "이순신", "ccc@c.com", "Y",
				new Timestamp(System.currentTimeMillis()));

		dao.updateById(member);

		MemberVO updatedMember = dao.getMemberById(member1.getId());

		assertEquals(member.toString(), updatedMember.toString());
	}

	@Test(expected = Exception.class) // 강제 예외처리 한게 작동하는지 테스트
	public void testUpdateByIdException() throws Exception {

		dao.insert(member1);

		MemberVO member = new MemberVO("bbb", "1111", "이순신", "ccc@c.com", "Y",
				new Timestamp(System.currentTimeMillis()));

		dao.updateById(member);
	}

	@Test
	public void testDeleteById() throws Exception {

		dao.insert(member1);
		dao.insert(member2);

		assertEquals(2, dao.getCountAll());

		dao.deleteById(member1.getId());

		assertEquals(1, dao.getCountAll());

		dao.deleteById(member2.getId());

		assertEquals(0, dao.getCountAll());

	}

}
