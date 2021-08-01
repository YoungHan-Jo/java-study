<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="nav-extended light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="/myweb/index.jsp" class="brand-logo">Logo</a>
		<ul class="right hide-on-med-and-down">
		
			<!-- 로그아웃 상태 -->
			<li><a href="/myweb/member/login.jsp">로그인</a></li>
			<li><a href="/myweb/member/join.jsp">회원가입</a></li>
			
			<!-- 로그인 상태 -->
			<li><a href="#">로그아웃</a></li>
			<li><a href="#">내정보</a></li>
			
			<!-- 로그인 관계없이 보이는 메뉴 -->
			<li><a href="#">게시판</a></li>
			<li><a href="#">채팅</a></li>
		</ul>

		<ul id="nav-mobile" class="sidenav">
			<li><a href="#">Navbar Link</a></li>
		</ul>
		<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
	</div>
	<div class="nav-content container">
		<ul class="tabs tabs-transparent">
			<li class="tab"><a href="#test1">Test 1</a></li>
			<li class="tab"><a href="#test2">Test 2</a></li>
			<li class="tab"><a href="#test3">Test 3</a></li>
			<li class="tab"><a href="#test4">Test 4</a></li>
		</ul>
	</div>
</nav>