<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = (String) session.getAttribute("id");

if (id == null) {
	response.sendRedirect("loginForm.jsp");
	return;
}
%>



<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberVO" class="com.example.domain.MemberVO" />

<jsp:setProperty property="*" name="memberVO" />

<%

MemberDAO memberDAO = MemberDAO.getInstance();

MemberVO dbMemberVO = memberDAO.getMemberById(id);

memberVO.setRegDate(dbMemberVO.getRegDate());

//비밀번호 일치여부
if(dbMemberVO.getPasswd().equals(memberVO.getPasswd())){ // 비밀번호 일치
	memberDAO.updateById(memberVO);
	%>
	<script>
	alert('회원정보 수정 완료');
	location.href='main.jsp';
	</script>
	<%
} else { // 비밀번호 불일치
	%>
	<script>
	alert('비밀번호가 일치하지 않습니다.');
	history.back();
	</script>
	<%
	
}

%>