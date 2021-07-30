<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.example.domain.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = (String) session.getAttribute("id");

if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}

if(id.equals("admin")==false){
	%>
	<script>
	alert('관리자 외 접근불가');
	location.href='main.jsp';
	</script>
	<%	
}

MemberDAO memberDAO = MemberDAO.getInstance();

List<MemberVO> list = memberDAO.getMembers();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>
	<hr>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>이메일 수신</th>
			<th>가입날짜</th>
		</tr>
		<%
		for(MemberVO memberVO: list){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String regDate = sdf.format(memberVO.getRegDate());
			%>
			<tr>
				<td><%=memberVO.getId() %></td>
				<td><%=memberVO.getPasswd() %></td>
				<td><%=memberVO.getName() %></td>
				<td><%=memberVO.getEmail() %></td>
				<td><%=memberVO.getRecvEmail() %></td>
				<td><%=regDate %></td>
			</tr>
			<%
		}
		%>
	</table>
<h3>
		<a href='main.jsp'>메인으로</a>
	</h3>



</body>
</html>