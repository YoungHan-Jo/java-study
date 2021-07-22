<%@page import="java.sql.Timestamp"%>
<%@page import="com.example.domain.MemberVO"%>
<%@page import="com.example.repository.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- post 요청 한글처리 -->
<%request.setCharacterEncoding("utf-8"); %>


<!-- 액션 태그로 MemberVO 객체 준비 -->

<!-- MemberVO memberVO = new MemberVO(); -->
<jsp:useBean id="memberVO" class="com.example.domain.MemberVO"/>

<!-- 사용자 입력값 가져오기 -> MemberVO 객체에 저장하기 -->
<jsp:setProperty property="*" name="memberVO"/><!-- 한번에 모두 찾아서 입력됨 -->

<!-- 회원가입날짜 설정 --> <!-- 날짜는 입력하지 않으므로 따로 설정 -->
<% memberVO.setRegDate(new Timestamp(System.currentTimeMillis())); %>

<!-- MemberDAO 객체준비 -->
<% MemberDAO memberDAO = MemberDAO.getInstance(); %>

<!-- insert 회원가입처리 -->
<%memberDAO.insert(memberVO);%>

<!-- 위의 내용으로만 끝나면, 새로고침 누를때 남아있는 데이터 때문에 
insert 라서 데이터베이스가 이상하게 됨.

위의 작업 후 다른페이지로 이동시켜서 방지하기
-->



<script>/*자바스크립트 영역*/
	alert('회원가입 성공');
	/* window.location - window.는 생략가능  */
	location.href = "loginForm.jsp"; /* 페이지 요청 하기. 주소 페이지가 갱신됨. */
</script>