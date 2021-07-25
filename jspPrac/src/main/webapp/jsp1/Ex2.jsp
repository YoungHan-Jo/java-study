<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = "aaa";
String passwd = "1234";
int age = 22;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print(id +"님의 비밀번호는 " + passwd +"이고, 나이는" + age + "입니다.");
		
		
	%>
	
	<p><%=id %> 님의 비밀번호는 <%=passwd %> 이고, 나이는 <%=age %> 입니다.</p>

</body>
</html>