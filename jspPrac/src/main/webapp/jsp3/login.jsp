<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면</h1>
	<hr>
	<form action="" method="post">
		아이디: <input type="text" name="id"><br> 비밀번호: <input
			type="password" name="passwd"><br>
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

