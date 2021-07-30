<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//모든세션 삭제
session.invalidate();

//쿠키값 가져오기
Cookie[] cookies = request.getCookies();

if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("loginId")) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
}

%>

<script>
alert('로그아웃 되었습니다.');
location.href='login.jsp';
</script>