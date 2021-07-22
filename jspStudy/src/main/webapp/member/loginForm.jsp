<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//쿠키값 가져오기
Cookie[] cookies = request.getCookies();

if(cookies != null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("loginId")){
			String loginId = cookie.getValue();
			//쿠키로 부터 찾은 로그인 아이디를 세션에 저장
			session.setAttribute("id",loginId);
			
			response.sendRedirect("main.jsp");
		}
	}
}

%>


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
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		<input type="checkbox" name="rememberMe" value="Y">로그인 상태유지<br>
		<input type="submit" value = "로그인">
		<input type="button" value = "회원가입"><br>
	</form>
	
	<script>
		var btn = document.querySelector('input[type="button"]');
		btn.addEventListener('click', function(){
			location.href='joinForm.jsp';
		});
	</script>
</body>
</html>