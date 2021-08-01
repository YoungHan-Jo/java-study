<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="/include/head.jsp" />

<style>
time.comment-date {
	font-size: 13px;
}
</style>
</head>

<body>

	<!-- Navbar goes here -->
	<jsp:include page="/include/nav.jsp" />


	<!-- Page Layout here -->
	<div class="row container">

		<div class="col s12 m4 l3">
			<div class="section">

				<!-- Grey navigation panel -->
				<ul class="collapsible">
					<li>
						<div class="collapsible-header waves-effect waves-teal">
							<i class="material-icons">filter_drama</i>회원정보
						</div>
						<div class="collapsible-body">
							<ul class="nav-inner">
								<li class="active">회원정보 수정</li>
								<li>회원정보 삭제</li>
							</ul>
						</div>
					</li>
					<li class="active">
						<div class="collapsible-header waves-effect waves-teal">
							<i class="material-icons">place</i>게시판
						</div>
						<div class="collapsible-body">
							<ul>
								<li><a href="boardList.html">일반 게시판</a></li>
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

		<div class="col s12 m8 l9">
			<!-- page content  -->
			<div class="section">

				<div class="card-panel">
					<div class="row">
						<div class="col s12" style="padding: 0 2%;">

							<h5>게시판 상세보기</h5>
							<div class="divider" style="margin: 30px 0;"></div>

							<table class="striped" id="boardList">
								<tr>
									<th class="center-align">제목</th>
									<td colspan="5">Lorem ipsum dolor sit amet, consectetur
										adipiscing elit.</td>
								</tr>
								<tr>
									<th class="center-align">작성자</th>
									<td>Web Admin</td>
									<th class="center-align">작성일</th>
									<td>2021.05.11</td>
									<th class="center-align">조회수</th>
									<td>15000</td>
								</tr>
								<tr>
									<th class="center-align">추천</th>
									<td class="blue-text">264</td>
									<th class="center-align">비추천</th>
									<td class="red-text">7</td>
									<th class="center-align">댓글</th>
									<td>70</td>
								</tr>
								<tr>
									<th class="center-align">내용</th>
									<td colspan="5">Lorem ipsum dolor sit amet, consectetur
										adipiscing elit.<br> Lorem ipsum dolor sit amet,
										consectetur adipiscing elit.<br> Lorem ipsum dolor sit
										amet, consectetur adipiscing elit.<br> Lorem ipsum dolor
										sit amet, consectetur adipiscing elit.<br> Lorem ipsum
										dolor sit amet, consectetur adipiscing elit.
									</td>
								</tr>
								<tr>
									<th class="center-align">첨부파일</th>
									<td colspan="5">첨부파일1 첨부파일2 첨부파일3</td>
								</tr>
							</table>


							<div class="section">
								<div class="row">
									<div class="col s12 right-align">
										<a class="btn waves-effect waves-light"> <i
											class="material-icons left">edit</i>글수정
										</a> <a class="btn waves-effect waves-light"> <i
											class="material-icons left">delete</i>글삭제
										</a> <a class="btn waves-effect waves-light"> <i
											class="material-icons left">reply</i>답글
										</a> <a class="btn waves-effect waves-light" href="boardList.html">
											<i class="material-icons left">list</i>글목록
										</a>
									</div>
								</div>
							</div>


							<!-- comment area -->
							<div id="comment" class="section">
								<div class="row" style="margin-left: 0px;">
									<div class="col s12">
										<i class="material-icons" style="font-size: 18px;">forum</i> <span
											style="font-size: 18px;">댓글</span>
									</div>
								</div>

								<ul class="collection">
									<li class="collection-item avatar"><img
										src="../resources/images/yuna.jpg" class="circle"> <span
										class="title"><b>홍길동</b> (aaa)</span>
										<p>
											First Line <br> Second Line
										</p> <span class="secondary-content"> <time
												class="grey-text comment-date">2021-07-23 15:07:24</time> <span
											class="grey-text text-lighten-1">|</span> <a href="#!">삭제</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">수정</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">답글</a>
									</span></li>
									<li class="collection-item avatar" style="margin-left: 40px;">
										<img src="../resources/images/yuna.jpg" class="circle">
										<span class="title"><b>홍길동</b> (aaa)</span>
										<p>
											First Line <br> Second Line
										</p> <span class="secondary-content"> <time
												class="grey-text comment-date">2021-07-23 15:07:24</time> <span
											class="grey-text text-lighten-1">|</span> <a href="#!">삭제</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">수정</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">답글</a>
									</span>
									</li>
									<li class="collection-item avatar" style="margin-left: 80px;">
										<img src="../resources/images/yuna.jpg" class="circle">
										<span class="title"><b>홍길동</b> (aaa)</span>
										<p>
											First Line <br> Second Line
										</p> <span class="secondary-content"> <time
												class="grey-text comment-date">2021-07-23 15:07:24</time> <span
											class="grey-text text-lighten-1">|</span> <a href="#!">삭제</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">수정</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">답글</a>
									</span>
									</li>
									<li class="collection-item avatar"><img
										src="../resources/images/yuna.jpg" class="circle"> <span
										class="title"><b>홍길동</b> (aaa)</span>
										<p>
											First Line <br> Second Line
										</p> <span class="secondary-content"> <time
												class="grey-text comment-date">2021-07-23 15:07:24</time> <span
											class="grey-text text-lighten-1">|</span> <a href="#!">삭제</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">수정</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">답글</a>
									</span></li>



									<li class="collection-item avatar" style="margin-left: 40px;">
										<img src="../resources/images/yuna.jpg" class="circle">
										<span class="title"><b>홍길동</b> (aaa)</span>
										<p>
											First Line <br> Second Line
										</p> <span class="secondary-content"> <time
												class="grey-text comment-date">2021-07-23 15:07:24</time> <span
											class="grey-text text-lighten-1">|</span> <a href="#!">삭제</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">수정</a>
											<span class="grey-text text-lighten-1">|</span> <a href="#!">답글</a>
									</span>
									</li>
									<!-- modify comment -->
									<li class="collection-item" style="margin-left: 40px;">
										<div class="row" style="margin-left: 0px;">
											<div class="col s12">
												<span style="font-size: 15px;">댓글 수정</span>
											</div>
											<div class="col s12">
												<form action="" method="POST">
													<div class="row">
														<div class="col s12 m9">
															<textarea class="materialize-textarea">First Line Second Line</textarea>
														</div>
														<div class="col s12 m3">
															<button type="submit"
																class="btn-large waves-effect waves-light">수정</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</li>
									<!-- end of modify comment -->
									<!-- write reply comment -->
									<li class="collection-item" style="margin-left: 80px;">
										<div class="row" style="margin-left: 0px;">
											<div class="col s12">
												<span style="font-size: 15px;">답댓글 작성</span>
											</div>
											<div class="col s12">
												<form action="" method="POST">
													<div class="row">
														<div class="col s12 m9">
															<textarea class="materialize-textarea"></textarea>
														</div>
														<div class="col s12 m3">
															<button type="submit"
																class="btn-large waves-effect waves-light">작성</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</li>
									<!-- end of write reply comment -->
								</ul>

								<div class="divider" style="margin: 30px 0;"></div>

								<!-- write new comment -->
								<div class="row" style="margin-left: 0px;">
									<div class="col s12">
										<span style="font-size: 18px;">새댓글 작성</span>
									</div>
									<div class="col s12">
										<form action="" method="POST">
											<div class="row">
												<div class="col s12 m9">
													<textarea class="materialize-textarea"></textarea>
												</div>
												<div class="col s12 m3">
													<button type="submit"
														class="btn-large waves-effect waves-light">작성</button>
												</div>
											</div>
										</form>
									</div>
								</div>
								<!-- end of write new comment -->

							</div>
							<!-- end of comment area -->

						</div>
					</div>
				</div>
				<!-- end of card-panel -->

			</div>
		</div>

	</div>

	<!-- footer area -->
	<jsp:include page="/include/footer.jsp" />



	<script>

	</script>
</body>

</html>