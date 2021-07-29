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

	이름 :
	<%=name %><br> 성별 :
	<%=gender %><br> 직업 :
	<%=job %><br> 취미 :
	<%
	if(hobbies != null){
		for(String hobby : hobbies){
			%>
			<%=hobby %>
			<%
		}			
	}
%>
</body>
</html>