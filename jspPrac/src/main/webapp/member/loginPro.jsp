<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
String rememberMe = request.getParameter("rememberMe"); // "null" , "on"
%>

<%
MemberDAO memberDAO = MemberDAO.getInstance();

MemberVO memberVO = memberDAO.getMemberById(id);

if (memberVO != null) { // 아이디 존재
	if (memberVO.getPasswd().equals(passwd)) { // 비밀번호 일치
		
		session.setAttribute("id", id); // 세션 저장
		
		if(rememberMe != null){ // 로그인 유지 체크
			
			//쿠키 생성
			Cookie cookie = new Cookie("loginId",id);
			//쿠키 시간설정
			cookie.setMaxAge(60*10);
			//쿠키 사용 경로설정
			cookie.setPath("/");
			//응답객체에 쿠키추가
			response.addCookie(cookie);
		}
	
		response.sendRedirect("main.jsp");
		
	}else{ // 비밀번호 불일치
		%>
		<script>
			alert('비밀번호가 일치하지 않습니다.');
			history.back();
		</script>
		<%
	}
} else { // 아이디 미존재
	%>
	<script>
		alert('존재하지 않는 아이디입니다.');
		history.back();
	</script>
	<%
}
%>

