<%@page import="com.example.repository.MemberDAO"%>
<%@page import="org.mindrot.jbcrypt.BCrypt"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<jsp:useBean id="memberVO" class="com.example.domain.MemberVO"/>
<jsp:setProperty property="*" name="memberVO"/>    

<%
memberVO.setRegDate(new Timestamp(System.currentTimeMillis()));
%>

<%
String passwd = memberVO.getPasswd();
String pwHash = BCrypt.hashpw(passwd, BCrypt.gensalt());
memberVO.setPasswd(pwHash);
%>

<%
String birthday = memberVO.getBirthday();
birthday = birthday.replace("-", "");

memberVO.setBirthday(birthday);
%>

<%
MemberDAO memberDAO = MemberDAO.getInstance();

memberDAO.insert(memberVO);
%>

<script>
	alert('회원가입 성공');
	location.href = '/myweb/member/login.jsp';
</script>
