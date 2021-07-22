<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그아웃처리. 세션 초기화
// session.removeAttribute("id"); // 키에 해당하는 요소 한개 삭제
session.invalidate();// 초기화. 모든 세션 삭제

%>

<script>
alert('로그아웃 되었습니다.');
location.href = 'loginForm.jsp';
</script>