<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//로그인 검증하기. 세션값 가져오기
String id = (String)session.getAttribute("id");

if (id == null){ // 로그인 과정이 없어서 세션값이 없으면, loginForm.jsp로 이동
	%>
	<script>
		alert('로그인부터 해주세요');
		location.href = 'loginForm.jsp';
	</script>
	<%
	return; // 리턴으로해서 이 밑으로는 실행 안되도록
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

	<h1>메인 페이지</h1>
	<hr>
	
	<%=id %>(<%=memberVO.getName() %>)님이 로그인 하셨습니다.<br>
	<input type="button" value="로그아웃" id="logout" onclick="location.href = 'logout.jsp'"><br>
	<a href="info.jsp">회원정보 조회</a><br>
	<a href="update.jsp">회원정보 수정</a><br>
	<a href="delete.jsp">회원정보 삭제</a><br>
	<% 
	if(id.equals("admin")){
	%><a href="memberList.jsp">회원목록</a><br><%	
	}
	%>
	
	<script>
	
	</script>
	
</body>
</html>