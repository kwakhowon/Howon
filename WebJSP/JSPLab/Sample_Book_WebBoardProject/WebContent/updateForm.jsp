<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>BBS Update</title>
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
  <form action="/bbs/update.bbs" method="post">
    <div id="contentForm">
        <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="articleNumber" value="${article.articleNumber}">
         
        <div class="input-group input-group-sm" role="group" aria-label="...">
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th width="30%">글쓴이</th>
              <td width="70%">${id}</td>
            </tr>
            <tr>
              <th style="padding-top: 15px">제목</th>
              <td><input type="text" name="title" value="${article.title}"
                    class="form-control" aria-describedby="basic-addon1"></td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="2">
                <textarea class="form-control" rows="20" name="content" >${article.content}</textarea>
              </td>
            </tr>
            <tr>
              <th style="padding-top: 15px">첨부파일</th>
              <td><input type="file" class="btn btn-default" name="fileName"></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="btn-group btn-group-sm" role="group" aria-label="...">
        <input type="submit" class="btn btn-default" value="수정하기">
        <input type="button" class="btn btn-default" value="취소" onclick="document.location.href='/bbs/content.bbs?articleNumber=${articleNumber}&pageNum=${pageNum}'">
      </div>
    </div>
  </form>
 
  <script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
  <script>
    jQuery(document).ready(function() {
      if(${id== null}) {
        alert("게시판을 이용하시려면 로그인하셔야 합니다.");
        location.href="/bbs/login.bbs"
      }
    });
  </script>
</body>
</html>
