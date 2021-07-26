<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="/include/head.jsp" />
</head>

<body>

	<!-- Navbar goes here -->
	<nav class="nav-extended light-blue lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="/index.jsp" class="brand-logo">Logo</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="/member/login.jsp">로그인</a></li>
				<li><a href="/member/join.jsp">회원가입</a></li>
			</ul>

			<ul id="nav-mobile" class="sidenav">
				<li><a href="#">Navbar Link</a></li>
			</ul>
			<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
		</div>
		<div class="nav-content container">
			<ul class="tabs tabs-transparent">
				<li class="tab"><a href="#test1">회원정보</a></li>
				<li class="tab"><a href="/board/boardList.jsp">게시판</a></li>
				<li class="tab"><a href="#test3">Test 3</a></li>
				<li class="tab"><a href="#test4">Test 4</a></li>
			</ul>
		</div>
	</nav>


	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h1 class="header center orange-text">Starter Template</h1>
			<div class="row center">
				<h5 class="header col s12 light">A modern responsive front-end
					framework based on Material Design</h5>
			</div>
			<div class="row center">
				<a href="http://materializecss.com/getting-started.html"
					id="download-button"
					class="btn-large waves-effect waves-light orange">Get Started</a>
			</div>
			<br> <br>

		</div>
	</div>


	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">flash_on</i>
						</h2>
						<h5 class="center">Speeds up development</h5>

						<p class="light">We did most of the heavy lifting for you to
							provide a default stylings that incorporate our custom
							components. Additionally, we refined animations and transitions
							to provide a smoother experience for developers.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">User Experience Focused</h5>

						<p class="light">By utilizing elements and principles of
							Material Design, we were able to create a framework that
							incorporates components and animations that provide more feedback
							to users. Additionally, a single underlying responsive system
							across all platforms allow for a more unified user experience.</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">settings</i>
						</h2>
						<h5 class="center">Easy to work with</h5>

						<p class="light">We have provided detailed documentation as
							well as specific code examples to help new users get started. We
							are also always open to feedback and can answer any questions a
							user may have about Materialize.</p>
					</div>
				</div>
			</div>

		</div>
		<br> <br>
	</div>

	<!-- footer area -->
	<%-- <%@ include file="/include/bottom.jsp" %> --%>
	<!-- 클래스로 객체생성하지 않고 통째로 불러오기만 함 -->
	<jsp:include page="/include/bottom.jsp" />
	<!--액션태그방식, 뒤에 '/' 붙여야함  클래스로 객체 생성해서 출력된 결과를 html로 가져옴, 성능적으로 우수 매소드같은 원리로 동작  -->
	<!-- end of footer area -->


	<!--  Scripts-->
	<jsp:include page="/include/commonJs.jsp" />

</body>

</html>