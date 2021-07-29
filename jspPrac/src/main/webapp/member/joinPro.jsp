<%@page import="com.example.repository.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberVO" class="com.example.domain.MemberVO"/>

<jsp:setProperty property="*" name="memberVO"/>

<%
memberVO.setRegDate(new Timestamp(System.currentTimeMillis()));
%>

<%
MemberDAO memberDAO = MemberDAO.getInstance();
%>

<%
if(memberDAO.getMemberById(memberVO.getId()) == null){
	memberDAO.insert(memberVO);
	%>
	<script>
		alert('회원가입 완료!');
		location.href='login.jsp';
	</script>
	<%
}else{
	%>
	<script>
		alert('이미 존재하는 아이디 입니다.');
		history.back();
	</script>
	<%
}


%>