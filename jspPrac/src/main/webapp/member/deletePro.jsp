<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("id");

if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<%
request.setCharacterEncoding("utf-8");

String passwd = request.getParameter("passwd");
%>

<%
MemberDAO memberDAO = MemberDAO.getInstance();

MemberVO memberVO = memberDAO.getMemberById(id);

//비밀번호 일치여부
if (passwd.equals(memberVO.getPasswd())) {// 일치
	memberDAO.deleteById(id);


	session.invalidate();

	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("loginId")){
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
	}

	%>
	<script>
		alert('회원탈퇴 완료');
		location.href='login.jsp';
	</script>
<%

} else {// 불일치
%>
<script>
alert('비밀번호가 일치하지 않습니다.');
history.back();
</script>
<%
}
%>
