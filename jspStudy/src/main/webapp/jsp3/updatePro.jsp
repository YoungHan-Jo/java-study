<%@page import="java.sql.Timestamp"%>
<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
String name = request.getParameter("name");
String email = request.getParameter("email");
String recvEmail = request.getParameter("recvEmail");

MemberVO memberVO = new MemberVO();
memberVO.setId(id);
memberVO.setPasswd(passwd);
memberVO.setName(name);
memberVO.setEmail(email);
memberVO.setRecvEmail(recvEmail);
memberVO.setRegDate(new Timestamp(System.currentTimeMillis()));

//MemberDAO 객체준비
MemberDAO memberDAO = MemberDAO.getInstance();

// insert 회원수정처리
memberDAO.updateById(memberVO);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원수정 처리결과</h1>
	<hr>
	
	<p>회원수정 성공!</p>

</body>
</html>