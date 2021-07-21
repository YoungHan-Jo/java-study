<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String gender = request.getParameter("gender");
String[] hobbies = request.getParameterValues("hobby");
String job = request.getParameter("job");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>exPro2.jsp 페이지</h1>
	<hr>
	
	<p>이름 : <%=name %></p>
	<p>성별 : <%=(gender != null) ? gender : "" %></p>
	<p>직업 : <%=(job != null) ? job : "" %></p>
	<p>취미 :
	<%
	if (hobbies != null){
		for(String hobby : hobbies){
			%>
			<%=hobby %> &nbsp;
			<%
		}
	}
	%>
	</p>

</body>
</html>