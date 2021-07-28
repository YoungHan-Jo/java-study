<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="nav-extended light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="/index.jsp" class="brand-logo">Logo</a>
		<ul id="mainMenu" class="right hide-on-med-and-down">
			<li><a href="#!" id="loginMenu">로그인</a></li>
			<li><a href="#!" id="joinMenu">회원가입</a></li>

			<!-- 로그인상태일때 -->
			<li><a href="#!" id="logoutMenu">로그아웃</a></li>
			<li><a href="#!" id="memberMenu">내정보</a></li>

			<!-- 로그인 관계없이 보이는 메뉴 -->
			<li><a href="#!" id="boardMenu">게시판</a></li>
			<li><a href="#!" id="chatMenu">채팅</a></li>
		</ul>

		<ul id="nav-mobile" class="sidenav">
			<li><a href="#">Navbar Link</a></li>
		</ul>
		<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
	</div>
	<div id="subMenuArea" class="nav-content container">
		<ul id="subMenu" class="tabs tabs-transparent">
		</ul>
	</div>
</nav>

<script>
	// html 문서가 로딩 완료됐을때
	
	$(document).ready(function() {
		
				function getSubMenu(menuId){
					var str = '';
					if(menuId == 'memberMenu'){
						str = `
							<li class="tab"><a href="/member/changePasswd.jsp">비밀번호 변경</a></li>
					        <li class="tab"><a href="/member/modifyMember.jsp">내정보 수정</a></li>
					        <li class="tab"><a href="/member/removeMember.jsp">회원탈퇴</a></li>
						`;
					}else if(menuId == 'boardMenu'){
						str = `
							<li class="tab"><a href="/board/boardList.jsp">게시판</a></li>
					        <li class="tab"><a href="">자료실</a></li>
						`;
					}else if(menuId == 'chatMenu'){
						 str = `
								<li class="tab"><a href="#test1">간단한 채팅</a></li>
						        <li class="tab"><a href="">채팅방 목록</a></li>
							`;
					}
					
					return str;
				} // getSubMenu
				
				function requestPage(menuId){
					if(menuId == 'joinMenu'){
						location.href = '/member/join.jsp';
					}else if(menuId == 'loginMenu'){
						location.href = '/member/login.jsp';
					}else if(menuId == 'logoutMenu'){
						location.href = '/member/logout.jsp';
					}
				}
				
				var $subMenuArea = $('#subMenuArea');
				
				$('ul#mainMenu a').on('click',function(event){
					event.preventDefault();
					
					// 현재 선택한 a태그의 id속성의 값을 가져오기
					var menuId = $(this).attr('id');
					
					if(menuId != 'loginMenu' && menuId != 'joinMenu' && menuId != 'logoutMenu'){
						// id속성의 값에 따라서 해당하는 하위메뉴 태그표현 문자열을 가져오기
						var str = getSubMenu(menuId);
						
						// 하위메뉴 영역에 표시하기
						$('#subMenu').html(str)
						
						var thisMenuSelected = $(this).closest('li').hasClass('active');
						
						if(thisMenuSelected == true){
							$subMenuArea.slideToggle();
						}else{
							$subMenuArea.slideDown();
						}
					}else{
						$subMenuArea.slideUp();
						
						requestPage(menuId);
					}
					
					
					
					// 주메뉴에 이미 선택된 active 클래스 제거하기
					$('#mainMenu > li').removeClass('active');
					// 주 메뉴 선택 active 클래스 적용하기
					$(this).closest('li').addClass('active');	
					
					
				})
			});
</script>