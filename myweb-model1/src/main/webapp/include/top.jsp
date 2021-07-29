<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 사용자 세션에서 아이디 찾아오기 // 필터를 먼저 거쳤기 때문에 있음 -->
<%
String id = (String) session.getAttribute("id");
%>


<nav class="nav-extended light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="/index.jsp" class="brand-logo">Logo</a>
		<ul id="mainMenu" class="right hide-on-med-and-down">

			<%
			if (id == null) {
			%>
			<!-- 로그아웃상태일때 -->
			<li><a href="/member/login.jsp" id="loginMenu"
				data-has-submenu="false">로그인</a></li>
			<li><a href="/member/join.jsp" id="joinMenu"
				data-has-submenu="false">회원가입</a></li>
			<%
			} else {
			%>
			<!-- 로그인상태일때 -->
			<li><a href="/member/logout.jsp" id="logoutMenu" data-has-submenu="false">로그아웃</a></li>
			<li><a href="#!" id="memberMenu" data-has-submenu="true">내정보(<%=id %>)</a></li>

			<%
			}
			%>

			<!-- 로그인 관계없이 보이는 메뉴 -->
			<li><a href="#!" id="boardMenu" data-has-submenu="true">게시판</a></li>
			<li><a href="#!" id="chatMenu" data-has-submenu="true">채팅</a></li>
		</ul>

		<ul id="nav-mobile" class="sidenav">
			<li><a href="#">Navbar Link</a></li>
		</ul>
		<a href="#" data-target="nav-mobile" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
	</div>
	<div id="subMenuArea" class="nav-content container">
		<ul id="subMenu" class="tabs tabs-transparent">
			<!-- 내정보 서브메뉴 -->
			<li class="tab submenu-member"><a
				href="/member/changePasswd.jsp">비밀번호 변경</a></li>
			<li class="tab submenu-member"><a
				href="/member/modifyMember.jsp">내정보 수정</a></li>
			<li class="tab submenu-member"><a
				href="/member/removeMember.jsp">회원탈퇴</a></li>
			<!-- 게시판 서브메뉴 -->
			<li class="tab submenu-board"><a href="/board/boardList.jsp">게시판</a></li>
			<li class="tab submenu-board"><a href="">자료실</a></li>
			<!-- 채팅 서브메뉴 -->
			<li class="tab submenu-chat"><a href="#test1">간단한 채팅</a></li>
			<li class="tab submenu-chat"><a href="">채팅방 목록</a></li>
		</ul>
	</div>
</nav>

<script>
	// html 문서가 로딩 완료됐을때
	$(document).ready(
			function() {
				$('ul#mainMenu a').on(
						'click',
						function(event) {
							//선택한 주메뉴 a태그의 id속성값 가져오기
							var menuId = $(this).attr('id');

							// 서브메뉴 li 아이템 모두 숨기기
							$('ul#subMenu>li').hide(); // display : none; 와 같음

							//선택한 주메뉴에 해당하는 서브메뉴만 보이기
							if (menuId == 'memberMenu') {
								$('li.submenu-member').show(); //display : block 와 같음
							} else if (menuId == 'boardMenu') {
								$('li.submenu-board').show();
							} else if (menuId == 'chatMenu') {
								$('li.submenu-chat').show();
							}

							//선택한 주메뉴가 서브메뉴를 가졌는지 data속성으로 확인
							var hasSubmenu = $(this).data('hasSubmenu');

							if (hasSubmenu == true) { // 서브메뉴가 있으면
								event.preventDefault();
								//$('div#subMenuArea').slideDown(200); // 서브메뉴 영역 열기

								//class 속성에 active 가졌는지 확인.
								var thisMenuAlreaySelected = $(this).closest(
										'li').hasClass('active');
								if (thisMenuAlreaySelected == true) {
									$('div#subMenuArea').slideToggle(200);
								} else {
									$('div#subMenuArea').slideDown(200);
								}
							} else {
								$('div#subMenuArea').slideUp(200); // 서브메뉴 영역 닫기
							}

							//주메뉴 li의 클래스 속성에 active 값 모두 제거
							$('ul#mainMenu li').removeClass('active');
							// 현재선택한 주메뉴 li에 클래스 속성 active 추가
							$(this).closest('li').addClass('active');
						});
			});

	/* $(document).ready(function() {
		
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
			}); */
</script>