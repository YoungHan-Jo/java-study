<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id = (String) session.getAttribute("id");

if(id == null){
	response.sendRedirect("loginForm.jsp");
	return;
}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원탈퇴 완료</h1>
	<hr>
	
	<form action="deletePro.jsp" method="post" id="form">
		아이디 : <input type="text" name="id" value="<%=id %>" readonly><br>
		비밀번호 : <input type="password" name="passwd"><br>
		<input type="button" value="회원삭제" id="btn">
	</form>
	<h3><a href="main.jsp">메인으로</a></h3>
	
	<script>
		var btn = document.querySelector('#btn');
		var form = document.querySelector('#form');
		
		btn.addEventListener('click',function(){
			// alert() - 알림 , confirm()-확인취소버튼 , prompt() 텍스트상자 입력
			var isDelete = confirm('정말 탈퇴하시겠습니까?'); // true/false 리턴
			
			if(isDelete == true){
				form.submit();	
			}
			 
		});
	</script>
</body>
</html>