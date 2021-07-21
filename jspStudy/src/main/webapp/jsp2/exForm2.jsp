<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>exForm2.jsp 페이지</h1>
	<hr>

	<%-- get은 양도 작고 노출되기 때문에, post를 사용함 --%>
	<form action="exPro2.jsp" method="post">
		이름 : 	<input type="text" name="name"><br> 
		성별 : 	<input type="radio" name="gender" value="male">남자
				<input type="radio" name="gender" value="female">여자<br>
		취미 : 	<input type="checkbox" name="hobby" value="여행">여행
				<input type="checkbox" name="hobby" value="게임">게임
				<input type="checkbox" name="hobby" value="야구">야구
				<input type="checkbox" name="hobby" value="축구">축구<br>
				
		직업 :
		<select name="job"> <!--여러개 고르려면 multiple="multiple" -->
			<option value="학생">학생</option>
			<option value="회사원">회사원</option>
			<option value="기타">기타</option>
		</select>
		<input type="submit" value="전송">
	</form>
</body>
</html>