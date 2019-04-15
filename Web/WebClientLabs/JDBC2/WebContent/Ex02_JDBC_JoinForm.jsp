<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no"
  />
  <title>Insert title here</title>
  <script src="css/jquery/jquery.min.js"></script>
  <script src="css/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
    //jquery 로 간단하게 유효성 check 하기
    $(function() {
      $("#joinForm").submit(function() {
        //alert("가입");
        if ($("#id").val() === "") {
          // 아이디 검사
          alert("ID를 입력해 주세요.");
          $("#id").focus();
          return false;
        } else if ($("#password").val() === "") {
          // 비밀번호 검사
          alert("PWD를 입력해 주세요.");
          $("#password").focus();
          return false;
        } else if ($("#name").val() === "") {
          // 이름 검사
          alert("이름을 입력해 주세요.");
          $("#name").focus();
          return false;
        } else if ($("#age").val() === "") {
          // 나이 검사
          alert("나이를 입력해 주세요.");
          $("#age").focus();
          return false;
        } else if ($("#email").val() === "") {
          // 우편번호
          alert("email를 입력해 주세요.");
          $("#email").focus();
          return false;
        }
      });
    });
  </script>
  <!--
CREATE TABLE koreaMember
(
  id VARCHAR2(50) PRIMARY KEY ,
  pwd VARCHAR2(50) NOT NULL,
  NAME VARCHAR2(50) NOT NULL,
  age NUMBER ,
  gender CHAR(4),
  email VARCHAR2(50),
  ip   VARCHAR2(50)
)
-->

  <link href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="css/simple-sidebar.css" rel="stylesheet" />
</head>
<body>
<div class="d-flex" id="wrapper">
  <div class="bg-light border-right" id="sidebar-wrapper">
    <jsp:include page="common/Left.jsp" />
  </div>
  <div id="page-content-wrapper">
    <jsp:include page="common/Top.jsp" />

    <div class="container">
      <form
              action="Ex02_JDBC_JoinOK.jsp"
              method="post"
              name="joinForm"
              id="joinForm"
      >
        <div>
          <form class="form-horizontal" role="form">
            <h2>회원가입</h2>
            <div class="form-group">
              <label for="id" class="col-sm-3 control-label">ID</label>
              <div class="col-sm-9">
                <input
                        type="text"
                        id="id"
                        placeholder="아이디"
                        class="form-control"
                        autofocus
                />
              </div>
            </div>
            <div class="form-group">
              <label for="password" class="col-sm-3 control-label"
              >Password</label
              >
              <div class="col-sm-9">
                <input
                        type="password"
                        id="password"
                        placeholder="비밀번호"
                        class="form-control"
                />
              </div>
            </div>
            <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Name</label>
              <div class="col-sm-9">
                <input
                        type="text"
                        id="name"
                        placeholder="이름"
                        class="form-control"
                />
              </div>
            </div>
            <div class="form-group">
              <label for="age" class="col-sm-3 control-label">Age</label>
              <div class="col-sm-9">
                <input
                        type="text"
                        id="age"
                        placeholder="나이"
                        class="form-control"
                />
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-3">Gender</label>
              <div class="col-sm-6">
                <div class="row">
                  <div class="col-sm-4">
                    <label class="radio-inline">
                      <input
                              type="radio"
                              id="femaleRadio"
                              value="Female"
                      />&nbsp;여성
                    </label>
                  </div>
                  <div class="col-sm-4">
                    <label class="radio-inline">
                      <input
                              type="radio"
                              id="maleRadio"
                              value="Male"
                      />&nbsp;남성
                    </label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label for="email" class="col-sm-3 control-label"
              >Email*
              </label>
              <div class="col-sm-9">
                <input
                        type="email"
                        id="email"
                        placeholder="Email"
                        class="form-control"
                        name="email"
                />
              </div>
            </div>
            <!-- /.form-group -->
            <button
                    type="submit"
                    class="btn btn-primary btn-block col-sm-9"
            >
              Register
            </button>
          </form>
        </div>
      </form>
    </div>
  </div>
</div>

<div class="footer">
  <jsp:include page="common/Bottom.jsp" />
</div>

<script>
  $("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
  });
</script>
</body>
</html>
