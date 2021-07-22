<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("id");

if(id == null){
	response.sendRedirect("loginForm.jsp");
	return;
}

%>

<%
request.setCharacterEncoding("utf-8");
String passwd = (String)request.getParameter("passwd"); // 패스워드는 유니코드로 안해도 되긴함.
%>

<%

MemberDAO memberDAO = MemberDAO.getInstance();

MemberVO memberVO = memberDAO.getMemberById(id);

if(passwd.equals(memberVO.getPasswd())){
	memberDAO.deleteById(id);
	%>
	<script>
		alert('회원탈퇴 완료');
		location.href='loginForm.jsp';
	</script>
	<%
}else{
	%>
	<script>
		alert('비밀번호가 틀림');
		history.back();
	</script>
	<%
}

%>