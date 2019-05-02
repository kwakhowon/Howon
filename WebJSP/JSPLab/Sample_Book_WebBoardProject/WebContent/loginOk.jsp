<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <form action="/bbs/logout.bbs" method="post">
    <span>${id}님, 환영합니다.</span>
    <br>
    <div class="btn-group" role="group" aria-label="...">
      <!-- <button>이 form태그 안에 있으면 type="submit"과 동일 -->
      <button class="btn btn-default btn-xs">Logout</button>
    </div>
  </form>
</body>
</html>
