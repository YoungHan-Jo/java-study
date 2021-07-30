<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="loginPro.jsp" method="post">
		아이디: <input type="text" name="id"><br> 
		비밀번호: <input type="password" name="passwd" ><br> 
		로그인 유지 <input type="checkbox" name="rememberMe" value="Y"><br>
		<button type="submit">로그인</button>
		<br>
		<button type="button">회원가입</button>
	</form>
	<script>
		const joinBtn = document.querySelector('button[type="button"]');
		joinBtn.addEventListener('click', function() {
			location.href = 'join.jsp';
		})
	</script>
</body>
</html>