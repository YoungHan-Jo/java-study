<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="/include/head.jsp" />
</head>

<body>

	<!-- Navbar goes here -->
	<jsp:include page="/include/nav.jsp" />


	<!-- Page Layout here -->
	<div class="row container">

		<div class="col s3">
			<div class="section">
				<!-- Grey navigation panel -->
				<ul class="collapsible">
					<li class="active">
						<div class="collapsible-header waves-effect waves-teal">
							<i class="material-icons">filter_drama</i>회원정보
						</div>
						<div class="collapsible-body">
							<ul>
								<li class="active">회원정보 수정</li>
								<li>회원정보 삭제</li>
							</ul>
						</div>
					</li>
					<li>
						<div class="collapsible-header waves-effect waves-teal">
							<i class="material-icons">place</i>게시판
						</div>
						<div class="collapsible-body">
							<ul>
								<li><a href="../board/boardList.html">일반 게시판</a></li>
								<li>자료실 게시판</li>
							</ul>
						</div>
					</li>
					<li>
						<div class="collapsible-header waves-effect waves-teal">
							<i class="material-icons">whatshot</i>Third
						</div>
						<div class="collapsible-body">
							<span>Lorem ipsum dolor sit amet.</span>
						</div>
					</li>
				</ul>
			</div>
		</div>

		<div class="col s9">
			<!-- page content  -->
			<div class="section">

				<!-- card panel -->
				<div class="card-panel">
					<div class="row">
						<div class="col s12" style="padding: 0 5%;">

							<h5>로그인</h5>
							<div class="divider" style="margin: 30px 0;"></div>

							<form action="" method="POST">
								<div class="row">
									<div class="input-field col s12">
										<i class="material-icons prefix">account_circle</i> <input
											id="id" type="text" class="validate"> <label for="id">아이디</label>
									</div>
								</div>

								<div class="row">
									<div class="input-field col s12">
										<i class="material-icons prefix">password</i> <input
											id="passwd" type="password" class="validate"> <label
											for="passwd">비밀번호</label>
									</div>
								</div>

								<p class="row center">
									<label> <input class="filled-in" type="checkbox"
										name="rememberMe" /> <span>로그인 상태 유지</span>
									</label>
								</p>

								<br>
								<div class="row center">
									<button class="btn waves-effect waves-light" type="submit">
										로그인 <i class="material-icons right">login</i>
									</button>
									&nbsp;&nbsp;
									<button class="btn waves-effect waves-light" type="reset">
										초기화 <i class="material-icons right">clear</i>
									</button>
								</div>

								<br>
								<div class="row center">
									아이디 찾기 &nbsp;<span class="grey-text text-lighten-1">|</span>&nbsp;
									비밀번호 찾기 &nbsp;<span class="grey-text text-lighten-1">|</span>&nbsp;
									<a href="join.html">회원가입</a>
								</div>
							</form>

						</div>
					</div>
				</div>
				<!-- end of card panel -->

			</div>
		</div>

	</div>

	<!-- footer area -->
	<jsp:include page="/include/footer.jsp" />

</body>

</html>