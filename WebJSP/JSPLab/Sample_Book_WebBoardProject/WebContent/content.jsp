<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>BBS Content</title>
  <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style>
    #contentForm {
      width: 40%;
      margin: 0 auto;
      padding-top: 5%;
    }
 
    .table > thead > tr > th, .table > tbody > tr > th {
      background-color: #e6ecff;
      text-align: center;
    }
  </style>
</head>
<body>
  <form action="/bbs/replyForm.bbs" method="post"> 
    <div id="contentForm">
        <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="depth" value="${article.depth}">
        <input type="hidden" name="pos" value="${article.pos}">
        <input type="hidden" name="groupId" value="${article.groupId}">
         
        <div>
          <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th>글쓴이</th>
              <td>${article.id}</td>
              <th>조회수</th>
              <td>${article.hit}</td>
            </tr>
            <tr>
              <th>제목</th>
              <td>${article.title}</td>
              <th>날짜</th>
              <td>${article.writeDate}</td>
            </tr>
            <tr>
              <th colspan="2">다운로드</th>
              <td colspan="2">
                <!-- 파일 다운로드 기능 -->
               <%-- <a href="">${article.fileName}</a> --%>
                <a href="/bbs/download.bbs?fileName=${article.fileName}">${article.fileName}</a>
                <%-- <a href="/bbs/download.bbs?fileName=${article.fileName}">${article.fileName}</a> --%>
              </td>
            </tr>
          </thead>
          <tbody>
            <tr height="200" valign="top">
              <td colspan="4">${article.content}</td>
            </tr>
            <tr>
              <th>첨부</th>
              <td colspan="3">
                <c:if test="${article.fileName == null}">없음</c:if>
                <c:if test="${article.fileName != null}">${article.fileName}</c:if>
              </td>
            </tr>
          </tbody>
        </table>
         
          <div id="btns" class="btn-group btn-group-sm" role="group" aria-label="...">
          <c:if test="${id != null}">
            <input type="submit" class="btn btn-default" value="답글달기">
            <c:if test="${id == article.id}">
              <input type="button" class="btn btn-default" value="수정하기" onclick="document.location.href='/bbs/updateForm.bbs?articleNumber=${article.articleNumber}&pageNum=${pageNum}'">
              <input type="button" class="btn btn-default" value="삭제하기" onclick="document.location.href='/bbs/delete.bbs?articleNumber=${article.articleNumber}&pageNum=${pageNum}'">
            </c:if>
            <c:if test="${id != article.id}">
              <input type="button" class="btn btn-default" value="수정하기" disabled="disabled">
              <input type="button" class="btn btn-default" value="삭제하기" disabled="disabled">
            </c:if>
          </c:if>
          <c:if test="${id == null}">
            <input type="submit" class="btn btn-default" value="답글달기" disabled="disabled">
            <input type="button" class="btn btn-default" value="수정하기" disabled="disabled">
            <input type="button" class="btn btn-default" value="삭제하기" disabled="disabled">
          </c:if>
          <input type="button" class="btn btn-default" value="목록으로" onclick="document.location.href='/bbs/list.bbs?pageNum=${pageNum}'">
        </div>
          
        
        </div>
         <div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
    <textarea class="form-control" rows="3" id="commentContent" placeholder="댓글을 입력하세요." style="width: 100%;" ></textarea>
    <div class="btn-group btn-group-sm" role="group" aria-label="...">
        <c:if test="${id == null}">
            <input type="button" class="btn btn-default" value="댓글 쓰기" disabled="disabled">
        </c:if>
        <c:if test="${id != null}">
            <input type="button" class="btn btn-default" value="댓글 쓰기" id="commentWrite">
        </c:if>
        <input type="button" class="btn btn-default" value="댓글 읽기(${article.commentCount})" 
                onclick="getComment(1, event)" id="commentRead">
    </div>
</div>
 
<!-- Comment 태그 추가 -->
<div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
    <div id="showComment" style="text-align: center;"></div>
</div>
    </div>
  </form>


  <script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
  <script>
  jQuery(document).ready(function() {
      if(${id== null}) {
          alert("게시판을 이용하시려면 로그인하셔야 합니다.");
          location.href="/bbs/login.bbs";
      }
  });
  
  // Perform an asynchronous HTTP (Ajax) request.
  // 비동기 통신 Ajax를 Setting한다.
  $.ajaxSetup({
      type:"POST",
      async:true,
      dataType:"json",
      error:function(xhr) {
          console.log("error html = " + xhr.statusText);
      }
  });
  
  $(function() {
      $("#commentWrite").on("click", function() {
          $.ajax({
              url:"/bbs/commentWrite.bbs",
              // data:{}에서는 EL을 ""로 감싸야 한다. 이외에는 그냥 사용한다.
              data:{
                  commentContent:$("#commentContent").val(),
                  articleNumber:"${article.articleNumber}"
              },
              beforeSend:function() {
                  console.log("시작 전...");
              },
              complete:function() {
                  console.log("완료 후...");
              },
              success:function(data) {            // 서버에 대한 정상응답이 오면 실행, callback
                  if(data.result == 1) {            // 쿼리 정상 완료, executeUpdate 결과
                      console.log("comment가 정상적으로 입력되었습니다.");
                      $("#commentContent").val("");
                      showHtml(data.comments, 1);
                  }
              }
          })
      });
  });

  function showHtml(data, commPageNum) {
      let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
      $.each(data, function(index, item) {
          html += "<tr align='center'>";
          html += "<td>" + (index+1) + "</td>";
          html += "<td>" + item.id + "</td>";
          html += "<td align='left'>" + item.commentContent + "</td>";
          let presentDay = item.commentDate.substring(0, 10);
          html += "<td>" + presentDay + "</td>";
          html += "</tr>";
      });
      html += "</tbody></table>";
      commPageNum = parseInt(commPageNum);        // 정수로 변경
      // commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
      if("${article.commentCount}" > commPageNum * 10) {
          nextPageNum = commPageNum + 1;
          html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
      }
      
      $("#showComment").html(html);
      $("#commentContent").val("");
      $("#commentContent").focus();
  }
  
  function getComment(commPageNum, event) {
      $.ajax({
          url:"/bbs/commentRead.bbs",
          data:{
              commPageNum:commPageNum*10,
              articleNumber:"${article.articleNumber}"
          },
          beforeSend:function() {
              console.log("읽어오기 시작 전...");
          },
          complete:function() {
              console.log("읽어오기 완료 후...");
          },
          success:function(data) {
              console.log("comment를 정상적으로 조회하였습니다.");
              showHtml(data, commPageNum);
              
              let position = $("#showComment table tr:last").position();
              $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
          }
      })
  }
</script>
</body>
</html>
