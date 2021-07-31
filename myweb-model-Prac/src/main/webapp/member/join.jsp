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
        <li><a href="login.html">로그인</a></li>
        <li class="active"><a href="join.html">회원가입</a></li>
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
      <!-- Teal page content  -->
      <div class="section">

        <!-- card panel -->
        <div class="card-panel">
          <div class="row">
            <div class="col s12" style="padding: 0 5%;">

              <h5>회원가입</h5>
              <div class="divider" style="margin: 30px 0;"></div>

              <form action="" method="POST">
                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">account_box</i>
                    <input id="id" type="text" class="validate">
                    <label for="id">아이디</label>
                    <span class="helper-text" data-error="wrong" data-success="right">필수 정보입니다.</span>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">lock</i>
                    <input id="passwd" type="password" class="validate">
                    <label for="passwd">비밀번호</label>
                    <span class="helper-text" data-error="wrong" data-success="right">Helper text</span>
                  </div>

                  <div class="input-field col s12">
                    <i class="material-icons prefix">check</i>
                    <input id="passwd" type="password" class="validate">
                    <label for="passwd">비밀번호 재확인</label>
                    <span class="helper-text" data-error="wrong" data-success="right">Helper text</span>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">person</i>
                    <input id="name" type="text" class="validate">
                    <label for="name">이름</label>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field">
                    <i class="material-icons prefix">event</i>
                    <input type="date" id="birthday" name="birthday">
                    <label for="birthday">생년월일</label>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field">
                    <i class="material-icons prefix">wc</i>
                    <select name="gender">
                      <option value="" disabled selected>성별을 선택하세요.</option>
                      <option value="M">남자</option>
                      <option value="F">여자</option>
                      <option value="U">선택 안함</option>
                    </select>
                    <label>성별</label>
                  </div>
                </div>

                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">mail</i>
                    <input id="email" type="email" class="validate">
                    <label for="email">본인 확인 이메일</label>
                  </div>
                </div>

                <p class="row center">
                  알림 이메일 수신 : &nbsp;&nbsp;
                  <label>
                    <input name="recvEmail" value="Y" type="radio" checked />
                    <span>예</span>
                  </label>
                  &nbsp;&nbsp;
                  <label>
                    <input name="recvEmail" value="N" type="radio" />
                    <span>아니오</span>
                  </label>
                </p>

                <br>
                <div class="row center">
                  <button class="btn waves-effect waves-light" type="submit">회원가입
                    <i class="material-icons right">create</i>
                  </button>
                  &nbsp;&nbsp;
                  <button class="btn waves-effect waves-light" type="reset">초기화
                    <i class="material-icons right">clear</i>
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
  <script>
    const sideNav = document.querySelector('.sidenav');
    M.Sidenav.init(sideNav, {});

    var textNeedCount = document.querySelectorAll('#member_id, #password');
    M.CharacterCounter.init(textNeedCount);

    var selects = document.querySelectorAll('select');
    M.FormSelect.init(selects, {});
  </script>
</body>

</html>