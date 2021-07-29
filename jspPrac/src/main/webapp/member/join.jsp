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
	아이디 : <input type="text" name="id" placeholder="아이디 입력" required><br>
	비밀번호 : <input type="password" name="passwd" placeholder="비밀번호 입력" required><br>
	이름 : <input type="text" name="name" placeholder="이름 입력" required><br>
	이메일 : <input type="email" name="email" placeholder="이메일 입력"><br>
	이메일 수신여부 : 
	<input type="radio" name="recvEmail" value="Y" checked>예
	<input type="radio" name="recvEmail" value="N">아니오<br>
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화"> <!-- 감싸고 있는 폼을 전부 리셋 -->		
	
	</form>
</body>
</html>