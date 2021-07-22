<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");

if(id ==null){
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
	<h1>회원정보 수정</h1>
	<hr>
	
	<form action="updatePro.jsp" method="post">
	아이디 : <input type="text" name="id" value="<%=id%>" readonly><br>
	비밀번호 : <input type="password" name="passwd" ><br>
	이름 : <input type="text" name="name" value="<%=memberVO.getName()%>"><br>
	이메일 : <input type="email" name="email" value="<%=memberVO.getEmail() %>"><br>
	이메일 수신여부 : 
	<input type="radio" name="recvEmail" value="Y" <%= (memberVO.getRecvEmail().equals("Y")) ? "checked" : "" %>>예
	<input type="radio" name="recvEmail" value="N" <%= (memberVO.getRecvEmail().equals("N")) ? "checked" : "" %>>아니오<br>
	<input type="submit" value="회원수정">
	
	<h3><a href="main.jsp">메인으로</a></h3>
			
	
	</form>
	
</body>
</html>