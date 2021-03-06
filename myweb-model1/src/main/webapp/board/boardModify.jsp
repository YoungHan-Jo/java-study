<%@page import="com.example.domain.AttachVO"%>
<%@page import="java.util.List"%>
<%@page import="com.example.domain.BoardVO"%>
<%@page import="com.example.repository.AttachDAO"%>
<%@page import="com.example.repository.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String id = (String) session.getAttribute("id");
%>

<!-- pageNum 파라미터 가져오기 -->
<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
%>

<%
// DAO객체 가져오기
BoardDAO boardDAO = BoardDAO.getInstance();
AttachDAO attachDAO = AttachDAO.getInstance();

// 글번호에 해당하는 글 내용 가져오기
BoardVO boardVO = boardDAO.getBoardByNum(num);


//글 번호에 해당하는 첨부파일 가져오기
List<AttachVO> attachList = attachDAO.getAttachesByBno(num);

%>

<!DOCTYPE html>
<html lang="ko">

<head>
<jsp:include page="/include/head.jsp" />
<style>
span.filename {
display: inline-block;
width: 275px;
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
			<!-- Teal page content  -->
			<div class="section">

				<!-- card panel -->
				<div class="card-panel">
					<div class="row">
						<div class="col s12" style="padding: 0 5%;">

							<h5>게시글 수정하기</h5>
							<div class="divider" style="margin: 30px 0;"></div>

							<form action="/board/boardModifyPro.jsp" method="POST" enctype="multipart/form-data">
							
								<!-- multipart/form-data 로 하면 뭉쳐져서 넘어가기 때문에
									input:hidden 속성으로 name/ value 로 쿠키 넘기듯이 넘기기 -->
								<input type="hidden" name="pageNum" value="<%=pageNum %>">
								<input type="hidden" name="num" value="<%=boardVO.getNum() %>">
								
								<div class="row">
									<div class="input-field col s12">
										<i class="material-icons prefix">account_box</i> <input
											id="id" type="text" name="id" value="<%=id%>" readonly>
										<label for="id">아이디</label>
									</div>
								</div>

								<div class="row">
									<div class="input-field">
										<i class="material-icons prefix">subtitles</i> <input
											type="text" id="title" class="validate" name="subject" value="<%=boardVO.getSubject() %>">
										<label for="title">제목</label>
									</div>
								</div>
								<div class="row">
									<div class="input-field">
										<i class="material-icons prefix">subject</i>
											<!-- textarea 태그 사이에 밸류값 입력 -->
										<textarea id="textarea1" class="materialize-textarea"
											name="content"><%=boardVO.getContent() %></textarea>
										<label for="textarea1">내용</label>
									</div>
								</div>

								<div class="row">
									<div class="col s12">
										<button type="button"
											class="btn-small waves-effect waves-light" id="btnAddFile">파일추가</button>
									</div>
								</div>

								<!-- 기존 첨부 파일 목록 -->
								<div class="row" id="oldFileBox">
								<%
								for (AttachVO attach : attachList){
									%>
									<!-- .delete-oldfile 버튼 클릭 시 hidden input의 name속성값이 oldfile->delfile로 변환 -->
									<input type="hidden" name="oldfile" value="<%=attach.getUuid() %>">
									<div class="col s12">
										<span class="filename"><%=attach.getFilename() %></span>
										<button class="waves-effect waves-light btn-small delete-oldfile">
											<i class="material-icons">clear</i>
										</button>
									</div>
									<%
								} // for
								%>
									
								</div>
								
								<!-- 신규 첨파 파일 목록 -->
								<div class="row" id="newFileBox"></div>
								
								

								<br>
								<div class="row center">
									<button class="btn waves-effect waves-light" type="submit">
										수정하기 <i class="material-icons right">create</i>
									</button>
									&nbsp;&nbsp;
									<button class="btn waves-effect waves-light" type="reset">
										초기화 <i class="material-icons right">clear</i>
									</button>
									&nbsp;&nbsp;
									<button class="btn waves-effect waves-light" type="button"
										onclick="location.href = '/board/boardList.jsp?PageNum=<%=pageNum %>'">
										글목록 <i class="material-icons right">list</i>
									</button>
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
	<jsp:include page="/include/bottom.jsp" />
	<!-- end of footer area -


  <!--  Scripts-->
	<jsp:include page="/include/commonJs.jsp" />
	<script>
	
	var fileIndex = 1;
	
	var currentFileCount = <%=attachList.size() %>; // 현재 첨부된 파일 개수
	const MAX_FILE_COUNT = 5; // 최대 첨부파일 개수
		
	$('#btnAddFile').on('click',function(){
		if(currentFileCount >= MAX_FILE_COUNT){
			alert(`첨부파일은 최대 \${MAX_FILE_COUNT}개까지 가능합니다.`);
			return;
		}
		
		var str = `<div class="col s12">
						<input type="file" name="file\${fileIndex}"> 
						<button class="waves-effect waves-light btn-small delete-addfile">
						<i class="material-icons">clear</i></button>
					</div>`;
					
		$('#newFileBox').append(str);
		
		fileIndex++;
		currentFileCount++;
	
	})
	
	// 동적 이벤트 연결 (이벤트 등록을 이미 존재하는 요소에게 위임하는 방식)
	$('#newFileBox').on('click','button.delete-addfile',function(){
		$(this).closest('div').remove();
		currentFileCount--;
	})
	
	// 기존 첨부파일의 삭제버튼 눌렀을때
	$('button.delete-oldfile').on('click',function(){
	
		// name속성의 값을 oldfile -> delfile(서버에서 찾을 파라미터값, 파일삭제용도)
		$(this).parent().prev().prop('name','delfile'); 
		
		//현재 클릭한 요소의 직계부모(parent)요소를 삭제하기
		$(this).parent().remove();
		
		currentFileCount--;
	})
	
	

	</script>
</body>

</html>