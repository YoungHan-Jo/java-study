<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- http://localhost:8090/jspStudy/jsp2/exForm1.jsp -->

	<h1>exForm1.jsp 페이지</h1>
	<hr>

	<%-- get은 양도 작고 노출되기 때문에, post를 사용함 --%>
	<form action="exPro1.jsp" method="post">
		이름 : <input type="text" name="name"><br> 
		나이 : <input type="text" name="age"><br> 
		<input type="submit" value="전송">
	</form>

</body>
</html>