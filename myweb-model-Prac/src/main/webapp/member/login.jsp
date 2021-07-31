<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
  <title>Starter Template - Materialize</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="../resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
  <link href="../resources/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>

<body>

  <!-- Navbar goes here -->
  <nav class="light-blue lighten-1">
    <div class="nav-wrapper container">
      <a id="logo-container" href="../index.html" class="brand-logo">Logo</a>
      <ul class="right hide-on-med-and-down">
        <li class="active"><a href="login.html">로그인</a></li>
        <li><a href="join.html">회원가입</a></li>
      </ul>

      <ul id="nav-mobile" class="sidenav">
        <li><a href="#">Navbar Link</a></li>
      </ul>
      <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
  </nav>


  <!-- Page Layout here -->
  <div class="row container">

    <div class="col s3">
      <div class="section">
        <!-- Grey navigation panel -->
        <ul class="collapsible">
          <li class="active">
            <div class="collapsible-header waves-effect waves-teal"><i class="material-icons">filter_drama</i>회원정보</div>
            <div class="collapsible-body">
              <ul>
                <li class="active">회원정보 수정</li>
                <li>회원정보 삭제</li>
              </ul>
            </div>
          </li>
          <li>
            <div class="collapsible-header waves-effect waves-teal"><i class="material-icons">place</i>게시판</div>
            <div class="collapsible-body">
              <ul>
                <li><a href="../board/boardList.html">일반 게시판</a></li>
                <li>자료실 게시판</li>
              </ul>
            </div>
          </li>
          <li>
            <div class="collapsible-header waves-effect waves-teal"><i class="material-icons">whatshot</i>Third</div>
            <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
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
                    <i class="material-icons prefix">account_circle</i>
                    <input id="id" type="text" class="validate">
                    <label for="id">아이디</label>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">password</i>
                    <input id="passwd" type="password" class="validate">
                    <label for="passwd">비밀번호</label>
                  </div>
                </div>

                <p class="row center">
                  <label>
                    <input class="filled-in" type="checkbox" name="rememberMe" />
                    <span>로그인 상태 유지</span>
                  </label>
                </p>

                <br>
                <div class="row center">
                  <button class="btn waves-effect waves-light" type="submit">로그인
                    <i class="material-icons right">login</i>
                  </button>
                  &nbsp;&nbsp;
                  <button class="btn waves-effect waves-light" type="reset">초기화
                    <i class="material-icons right">clear</i>
                  </button>
                </div>

                <br>
                <div class="row center">
                  아이디 찾기
                  &nbsp;<span class="grey-text text-lighten-1">|</span>&nbsp;
                  비밀번호 찾기
                  &nbsp;<span class="grey-text text-lighten-1">|</span>&nbsp;
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

  <!-- footer goes here -->
  <footer class="page-footer orange">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Company Bio</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our
            full time job. Any amount would help support and continue development on this project and is greatly
            appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Connect</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
        Made by <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="../resources/js/materialize.js"></script>
  <script src="../resources/js/init.js"></script>

</body>

</html>