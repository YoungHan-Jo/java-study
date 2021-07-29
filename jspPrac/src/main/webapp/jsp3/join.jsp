<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<hr>
<form action="joinPro.jsp" method="post">
	아이디 : <input type="text" name="id" required><br>
	비밀번호 : <input type="password" name="passwd" required><br>
	이름 : <input type="text" name="name"><br>
	이메일 : <input type="email" name="email"><br>
	이메일 수신여부 :
	<input type="radio" value="Y" name="recvEmail" checked>예
	<input type="radio" value="N" name="recvEmail">아니오<br>
	<button type="submit">회원가입</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>