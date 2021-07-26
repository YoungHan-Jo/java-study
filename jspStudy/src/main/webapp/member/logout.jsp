<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그아웃처리. 세션 초기화
// session.removeAttribute("id"); // 키에 해당하는 요소 한개 삭제
session.invalidate();// 초기화. 모든 세션 삭제

//쿠키값 가져오기
Cookie[] cookies = request.getCookies();

//특정 쿠키 삭제하기(브라우저가 삭제하도록 유효기간 0초로 설정한 쿠키 보내서 덮어씌우기)
if(cookies !=null){
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("loginId")){
			cookie.setMaxAge(0); // 쿠키를 직접적으로 삭제하는것은 불가 -> 삭제되도록 유도하기
			cookie.setPath("/"); // 같은 경로로 설정해서 덮어씌우기위해
			response.addCookie(cookie); // 응답객체에 추가하기
		}
	}
}

%>

<script>
alert('로그아웃 되었습니다.');
location.href = 'loginForm.jsp';
</script>