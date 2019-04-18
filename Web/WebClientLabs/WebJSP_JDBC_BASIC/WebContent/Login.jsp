<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp"/>
<link rel="stylesheet" href="css/login.css"/>

</head>
<body>
<jsp:include page="common/header.jsp"/>
<div class="center-area">
  <jsp:include page="common/aside.jsp"/>
  <main>
    <div class="img">
      <img src="images/login.png">
    </div>
    <form class="form-horizontal" role="form" action="LoginOK.jsp">
      <div class="login-form">
        <h2>Team3</h2>
        <div class="form-id">
          <label for="id" class="col-sm-3 control-label">ID : </label> <input
                type="text" id="id" name="id" placeholder="아이디" class="form-control"
                autofocus/>
        </div>
        <div class="form-pwd">
          <label for="password" class="col-sm-3 control-label">PWD : </label>
          <input type="password" id="password" name="pwd" placeholder="비밀번호"
                 class="form-control"/>
        </div>
        <!-- /.form-group -->
        <button type="submit" class="btn">
          Login
        </button>
      </div>
    </form>
  </main>
</div>
<jsp:include page="common/footer.jsp"/>