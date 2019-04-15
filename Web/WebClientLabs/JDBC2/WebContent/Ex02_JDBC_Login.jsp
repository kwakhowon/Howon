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
          if ($("#id").val() == "") {
            // 아이디 검사
            alert("ID를 입력해 주세요.");
            $("#id").focus();
            return false;
          } else if ($("#password").val() == "") {
            // 비밀번호 검사
            alert("PWD를 입력해 주세요.");
            $("#pwd").focus();
            return false;
          } else if ($("#name").val() == "") {
            // 이름 검사
            alert("이름을 입력해 주세요.");
            $("#mname").focus();
            return false;
          } else if ($("#age").val() == "") {
            // 나이 검사
            alert("나이를 입력해 주세요.");
            $("#age").focus();
            return false;
          } else if ($("#email").val() == "") {
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
            <h2>로그인</h2>
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
            <!-- /.form-group -->
            <button
                    type="submit"
                    class="btn btn-primary btn-block col-sm-9"
            >
              Login
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
