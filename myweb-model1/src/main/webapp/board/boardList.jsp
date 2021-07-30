<%@page import="com.example.domain.Criteria"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.example.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.example.repository.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
// 요청 페이지번호 가져오기
String strPageNum = request.getParameter("pageNum");
strPageNum = (strPageNum == null) ? "1" : strPageNum;
int pageNum = Integer.parseInt(strPageNum);

//요청 글 개수 가져오기
String strAmount = request.getParameter("amount");
strAmount = (strAmount == null) ? "10" : strAmount;
int amount = Integer.parseInt(strAmount);

//글 가져오기 조건객체 준비 후 값 설정
Criteria cri = new Criteria(pageNum, amount);


//DAO 객체준비
BoardDAO boardDAO = BoardDAO.getInstance();

// board 테이블에서 전체글 리스트로 가져오기
List<BoardVO> list = boardDAO.getBoards(cri);

// 전체 글 개수 가져오기

int totalCount = boardDAO.getCountAll();
%>

<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="/include/head.jsp" />
<style>
table tbody tr {
	cursor: pointer;
}
</style>
</head>

<body>

	<!-- Navbar area -->
	<jsp:include page="/include/top.jsp" />
	<!-- end of Navbar area -->


	<!-- Page Layout here -->
	<div class="row container">

		<!-- left menu area -->
		<jsp:include page="/include/left.jsp" />
		<!-- end of left menu area -->

		<div class="col s12 m8 l9">
			<!-- page content  -->
			<div class="section">

				<div class="card-panel">
					<div class="row">
						<div class="col s12" style="padding: 0 2%;">

							<h5>일반 게시판</h5>
							<div class="divider" style="margin: 30px 0;"></div>

							<div class="row">
								<a href="/board/boardWrite.jsp"
									class="btn waves-effect waves-light right"> <i
									class="material-icons left">create</i>새글쓰기
								</a>
							</div>

							<table class="highlight responsive-table" id="board">
								<thead>
									<tr>
										<th class="center-align">번호</th>
										<th class="center-align">제목</th>
										<th class="center-align">작성자</th>
										<th class="center-align">작성일</th>
										<th class="center-align">조회수</th>
									</tr>
								</thead>

								<tbody>

									<%
									if (totalCount > 0) {

										SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

										for (BoardVO boardVO : list) {
											String strRegDate = sdf.format(boardVO.getRegDate());
									%>
									<tr onclick="location.href='/board/boardContent.jsp'">
										<td class="center-align"><%=boardVO.getNum()%></td>
										<td><%=boardVO.getSubject()%></td>
										<td class="center-align"><%=boardVO.getMid()%></td>
										<td class="center-align"><%=strRegDate%></td>
										<td class="center-align"><%=boardVO.getReadcount()%></td>
									</tr>
									<%
									}

									} else { // 글이 없을 때
									%>
									<tr>
										<td class="center-align" colspan="5">게시글이 없습니다.</td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>

							<br>
							<ul class="pagination center">
								<li class="disabled"><a href="#board"><i
										class="material-icons">chevron_left</i></a></li>
								<li class="active"><a href="#board">1</a></li>
								<li class="waves-effect"><a href="#board">2</a></li>
								<li class="waves-effect"><a href="#board">3</a></li>
								<li class="waves-effect"><a href="#board">4</a></li>
								<li class="waves-effect"><a href="#board">5</a></li>
								<li class="waves-effect"><a href="#board"><i
										class="material-icons">chevron_right</i></a></li>
							</ul>

							<div class="divider" style="margin: 30px 0;"></div>

							<form action="" method="GET">
								<div class="row">
									<div class="col s12 l4">
										<div class="input-field">
											<i class="material-icons prefix">find_in_page</i> <select
												name="type">
												<option value="" disabled selected>--</option>
												<option value="T">제목</option>
												<option value="C">내용</option>
												<option value="W">작성자</option>
											</select> <label>검색 조건</label>
										</div>
									</div>

									<div class="col s12 l4">
										<!-- AutoComplete -->
										<div class="input-field">
											<i class="material-icons prefix">search</i> <input
												type="text" id="autocomplete-input" class="autocomplete"
												name="keyword"> <label for="autocomplete-input">검색어</label>
										</div>
										<!-- end of AutoComplete -->
									</div>

									<div class="col s12 l4">
										<a class="waves-effect waves-light btn-large"><i
											class="material-icons left">search</i>검색</a>
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
				<!-- end of card-panel -->

			</div>
		</div>

	</div>

	<!-- footer area -->
	<jsp:include page="/include/bottom.jsp" />
	<!-- end of footer area -->

	<!--  Scripts-->
	<jsp:include page="/include/commonJs.jsp" />
	<script>
		
	</script>
</body>

</html>