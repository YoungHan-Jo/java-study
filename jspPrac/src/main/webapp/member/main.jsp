<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%
String id = (String)session.getAttribute("id");

if(id == null){
	%>
	<script>
		alert('로그인이 필요합니다.');
		location.href='login.jsp';
	</script>
	<%
	return;
}

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
	<h1>메인화면</h1>
	<hr>
	
	<%=memberVO.getId() %>님이 로그인 하였습니다.<br>
	
	
</body>
</html>