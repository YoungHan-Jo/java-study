<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String strAge = request.getParameter("age");
int age = Integer.parseInt(strAge);
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
	이름 :
	<%=name%><br> 나이 :
	<%=age%><br>

	<%
	if (age > 19) {
		out.print("<p>"+name + "님은 성인입니다."+"</p>");
	} else
		out.print("<p>"+name + "님은 미성년자입니다."+"</p>");
	%>

	<hr>

	<%
	if (age > 19) {
	%><p><%=name%>님은 성인입니다.</p><%
	} else {
	%><p><%=name%>님은 미성년자입니다.</p><%
	}
	%>

</body>
</html>