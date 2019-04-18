<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp"/>
<link rel="stylesheet" href="css/JoinForm.css"/>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div class="center-area">
  <jsp:include page="common/aside.jsp"/>
  <main>
    <div class="register-form">
      <form action="JoinOK.jsp" method="post">
        <label for="id">아이디</label><br/>
        <input type="text" name="id" id="id"/><br/>
        <hr/>
        <label for="pwd">비밀번호</label><br/>
        <input type="password" name="pwd" id="pwd"/><br/>
        <hr/>
        <label for="name">이름</label><br/>
        <input type="text" name="name" id="name"/><br/>
        <hr/>
        <label for="age">나이</label><br/>
        <input type="text" name="age" id="age"/><br/>
        <hr/>
        <label for="gender">성별</label><br/>
        <div class="radio-gender">
          <input type="radio" name="gender" id="female" value="F" class="radio-button"/><br/>
          <label for="female" class="gender-label">여성</label><br/>
          <input type="radio" name="gender" id="male" value="M" class="radio-button"/><br/>
          <label for="male" class="gender-label">남성</label><br/>
        </div>
        <hr/>
        <label for="email">이메일</label><br/>
        <input type="email" name="email" id="email"/><br/>
        <input type="submit" value="가입하기" class="joinBtn"/>
      </form>
    </div>
  </main>
</div>
<jsp:include page="common/footer.jsp"/>
