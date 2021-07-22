<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 새로고침 계속 눌려도 안전하게 하기 위해 html 내용은 없음 -->
<%
String id = (String)session.getAttribute("id");

if(id ==null){
	response.sendRedirect("loginForm.jsp");
	return;
}
%>

<%
//post 요청 텍스트 데이터 한글처리
request.setCharacterEncoding("utf-8");
%>

<!-- 액션태그 이용해서 폼 파라미터값 가져와서 설정하기 -->

<jsp:useBean id="memberVO" class="com.example.domain.MemberVO"></jsp:useBean>

<jsp:setProperty property="*" name="memberVO"/>

<%
memberVO.setRegDate(new Timestamp(System.currentTimeMillis()));

MemberDAO memberDAO = MemberDAO.getInstance();

// DB 테이블에서 id에 해당하는 행 가져오기
MemberVO dbMemberVO = memberDAO.getMemberById(memberVO.getId());

// 비밀번호 일치하면 회원정보 수정하기
if(dbMemberVO.getPasswd().equals(memberVO.getPasswd())){
	memberDAO.updateById(memberVO);	
	%>
	<script>
		alert('회원정보 수정 완료');
		location.href='main.jsp';
	</script>
	<%
} else {
	%>
	 <script>
	 	alert('비밀번호 틀림');
	 	history.back(); // 뒤로가기
	 </script>
	<%
}




%>

