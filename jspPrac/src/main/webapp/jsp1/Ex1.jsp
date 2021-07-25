<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="color.jspf"%>

<%
String name;

name = "문자열";

Date str = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String strDate = sdf.format(str);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here prac</title>
</head>
<body bgColor="<%=bgColor2%>">

	<%@ include file="top.jsp" %>
	<h1>Ex1</h1>
	<hr>

	<p><%=name%></p>
	<%=strDate%>
	
	<%@ include file="bottom.jsp" %>
</body>
</html>