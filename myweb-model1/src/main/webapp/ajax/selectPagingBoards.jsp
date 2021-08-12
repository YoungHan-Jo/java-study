<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 1000px;
}
</style>
</head>
<body>

	<h1>글 목록 보기</h1>
	<hr>


	<table border=1>
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


		</tbody>
	</table>
	<br>

	<script src="/resources/js/jquery-3.6.0.js"></script>

	<script>
		

		function getData() {
			$.ajax({
				url : 'api/boards/pages/' + page,
				method : 'GET',
				success : function(data) {
					console.log(data);

					showData(data);

				} // success
			});
		}

		

		function showData(array) {
			str = '';
			
			if(array.length > 0){
				for(var board of array) {
					str += `
						<tr>
						
						
						</tr>
					`;
					
					
				} // for	
			}else {
				str += `
					<tr>
						
					</tr>
				`;
			}
			
			$('tbody').append(str);
			
		} // showData
		
		// 페이지 로딩 후 바로 실행하는 명령문 ====
		var page = 1;
		getData(page);
			
			
		$(window).on('scroll', function() {
			console.log('scroll 이벤트 발생');
			
			// 스크롤 이벤트 문서 최하단 감지하면, 데이터 가져와서 화면에 덧붙이기
			if ($(window).scrollTop() +  $(window).height() >= $(document).height()){
				getData(page);
				page++;
			}
			
			
		})
		
	</script>
</body>
</html>