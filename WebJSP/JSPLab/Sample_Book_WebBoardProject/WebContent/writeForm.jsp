<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BBS Write</title>
	  <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style>
    #contentForm {
      width: 40%;
      margin: 0 auto;
      padding-top: 12%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
  </style>
</head>
<body>
  <!-- enctype="application/x-www-form-urlencoded" 속성이 default로 잡혀있음 -->
  <!-- <form action="/bbs/write.bbs" method="post" enctype="application/x-www-form-urlencoded"> -->
  <form action="/bbs/write.bbs" method="post" id="contentForm" enctype="multipart/form-data">
      <input type="hidden" name="pageNum" value="${pageNum}">${pageNum}
      <input type="hidden" name="depth" value="${article.depth}">
      <input type="hidden" name="pos" value="${article.pos}">
      <input type="hidden" name="groupId" value="${article.groupId}">
       
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
        <tr>
          <td>글쓴이 : </td>
          <td>${id}</td>
        </tr>
        <tr>
          <td>제목 : </td>
          <td><input type="text" name="title" class="form-control"></td>
        </tr>
        <tr>
          <td colspan="2">
            <textarea cols="50" rows="20" name="content" class="form-control"></textarea>
          </td>
        </tr>
        <tr>
          <td>첨부 : </td>
          <td><input type="file" class="btn btn-default" name="file"></td>
        </tr>
        <tr>
          <td><input type="submit" value="글쓰기" class="btn btn-default"></td>
          <td><input type="reset" value="글쓰기취소" class="btn btn-default"></td>
        </tr>
      </table>
    </div>
  </form>
</body>
</html>
