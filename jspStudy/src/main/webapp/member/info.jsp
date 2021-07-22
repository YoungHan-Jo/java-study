<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%

String id = (String)session.getAttribute("id");

if(id == null){
response.sendRedirect("loginForm.jsp");
return;
}
%>

<%
MemberDAO memberDAO = MemberDAO.getInstance();

MemberVO memberVO = memberDAO.getMemberById(id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원정보 조회</h1>
	<hr>

	<p>아이디 : <%=memberVO.getId() %></p>
	<p>비밀번호 : <%=memberVO.getPasswd() %></p>
	<p>이름 : <%=memberVO.getName() %></p>
	<p>이메일 : <%=memberVO.getEmail() %></p>
	<p>메일 수신여부 : <%=memberVO.getRecvEmail() %></p>
	<p>등록날짜 : <%=memberVO.getRegDate() %></p>
	
	<h3><a href='main.jsp'>메인으로</a></h3>

</body>
</html>