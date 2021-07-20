<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}%>

<%@ include file="color.jspf"%>

<%
// 자바코드 영역// 스크립트릿
System.out.println("콘솔 출력");

String str = "문자열";

Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String strDate = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="<%=bgColor1%>">

	<%-- include top.jsp --%>
	<%@ include file="top.jsp"%>


	<h2>JSP 연습</h2>
	<!-- HTML 주석 브라우저 코드소스에서 볼 수 있음 -->
	<%-- JSP 주석 - JSP파일 안에서만 볼 수 있음  --%>
	<p><%=str%></p>
	<%-- 표현식 --%>
	<p><%=strDate%></p>
	<%
	out.println(strDate);
	%>
	<%-- out : 출력 내장 객체 --%>


	<%-- include bottom.jsp --%>
	<%@ include file="bottom.jsp"%>

</body>
</html>