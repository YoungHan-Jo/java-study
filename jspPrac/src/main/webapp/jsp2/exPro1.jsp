<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String age = request.getParameter("age");

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>exPro1.jsp 페이지</h1>
<hr>
이름 : <%=name %>
<br>
나이 : <%=age %>
</body>
</html>