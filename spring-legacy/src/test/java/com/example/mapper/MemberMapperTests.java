package com.example.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class) // spring과 junit 통합, Component 계열 애노테이션
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // root-context.xml을 실행(scan)
public class MemberMapperTests {

	@Autowired
	private MemberMapper memberMapper;

	@Test
	public void testInsert() {

		assertNotNull(memberMapper);
		
		MemberVO memberVO= new MemberVO();
		memberVO.setId("zzz");
		
		String hashdPw = BCrypt.hashpw("1234", BCrypt.gensalt());
		
		memberVO.setPasswd(hashdPw);
		memberVO.setName("지지지");
		memberVO.setRegDate(new Date());
		
		memberMapper.insert(memberVO);
	}

}
