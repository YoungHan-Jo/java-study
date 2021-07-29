<%@page import="com.example.repository.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.example.domain.MemberVO"%>
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

MemberDAO memberDAO = MemberDAO.getInstance();

if (memberDAO.getMemberById(id) == null) {
	memberDAO.insert(memberVO);
%>
<script>
	alert('회원가입 완료!');
</script>
<%
response.sendRedirect("login.jsp");
} else {
	%><script>
	alert('이미 존재하는 아이디 입니다.');
	history.back();
	</script><%
}
%>