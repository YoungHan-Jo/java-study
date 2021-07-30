<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String id = (String)session.getAttribute("id");

if(id == null){
	response.sendRedirect("login.jsp");
	return;
}



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<hr>
	<form action="deletePro.jsp" method="post">
	비밀번호 : <input type="password" name="passwd"><br>
	<button type="submit">회원탈퇴</button>
	<h3>
		<a href='main.jsp'>메인으로</a>
	</h3>
	</form>
</body>
</html>