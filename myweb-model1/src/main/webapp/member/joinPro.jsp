<%@page import="com.example.repository.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- post 요청 한글처리는 필터로 처리함 --%>

<jsp:useBean id="memberVO" class="com.example.domain.MemberVO" />

<jsp:setProperty property="*" name="memberVO" />

<%-- --%>
<%
memberVO.setRegDate(new Timestamp(System.currentTimeMillis()));
%>
<%
String birthday = memberVO.getBirthday();
birthday = birthday.replace("-","");
memberVO.setBirthday(birthday);
%>
<%
MemberDAO memberDAO = MemberDAO.getInstance();
%>
<%
memberDAO.insert(memberVO);
%>

<script>
	alert('회원가입 성공');
	location.href = '/member/login.jsp';
</script>