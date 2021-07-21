<%@page import="com.example.domain.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDAO memberDAO = MemberDAO.getInstance();

	List<MemberVO> memberList = memberDAO.getMembers();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원조회</h1>
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>이메일</th>
				<th>메일수신여부</th>
				<th>가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(MemberVO member : memberList){
				%>
				<tr>
					<td><%=member.getId() %></td>
					<td><%=member.getPasswd() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getEmail() %></td>
					<td><%=member.getRecvEmail() %></td>
					<td><%=member.getRegDate() %></td>
				</tr>
				<%
			}
			%>
			
		</tbody>
	
	</table>
	
	
</body>
</html>