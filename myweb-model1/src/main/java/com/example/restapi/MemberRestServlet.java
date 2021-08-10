package com.example.restapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.domain.MemberVO;
import com.example.repository.MemberDAO;
import com.google.gson.Gson;

@WebServlet("/api/members/*")
public class MemberRestServlet extends HttpServlet {

	private static final String BASE_URI = "/api/members";
	
	private MemberDAO memberDAO = MemberDAO.getInstance();
	
	private Gson gson = new Gson(); // gson 라이브러리


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// "/api/members" -> member 테이블 전체 레코드 정보 요청
		// "/api/members/aaa" -> member 테이블에 아이디가 aaa인 레코드 한개 정보 요청

		String requestURI = request.getRequestURI();

		System.out.println("requestURI : " + requestURI);

		String id = requestURI.substring(BASE_URI.length());

		System.out.println("id : " + id);
		
		
		String strJson = "";
		
		if(id.length() == 0) { // "/api/members"
			
			List<MemberVO> memberList =  memberDAO.getMembers();
			
			strJson = gson.toJson(memberList); // json으로 string 만들기
			
			
		}else { // "/api/members/*"
			id = id.substring(1); // 맨앞의 "/"문자 제거
			
			MemberVO memberVO =  memberDAO.getMemberById(id); // 없으면 null 리턴
			
			int count = memberDAO.getCountById(id); // 항상 숫자 리턴
			
			
			Map<String, Object> map = new HashMap<>();
			map.put("member",memberVO);			
			map.put("count",count);
			
			strJson = gson.toJson(map);
		}
		
		// 클라이언트 쪽으로 출력하기
		response.setContentType("application/json; charset=UTF-8"); //json 형식으로 출력하겠다고 전달
		PrintWriter out = response.getWriter();
		out.print(strJson);
		out.flush(); // 버퍼 비우기
		

	}// doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// "/api/members"
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// "/api/members/aaa" + 수정할 데이터
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// "/api/members/aaa"
	}

}
