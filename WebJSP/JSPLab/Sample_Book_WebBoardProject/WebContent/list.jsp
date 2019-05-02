<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>BBS List</title>
  <link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style>
    #listForm {
      width: 70%;
      margin: 0 auto;     /* 가로로 중앙에 배치 */
      padding-top: 5%;      /* 테두리와 내용 사이의 패딩 여백 */
    }
     
    #loginCheckForm {
      text-align: right;
      padding-right: 15px;
      padding-top: 15px;
    }
     
    #listTitle {
      text-align: center;
    }
     
    #writeLink {
      text-align: right;
    }
     
    /* Bootstrap 수정 */
    .table > thead {
      background-color: #e6ecff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #d9def2;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
     
    .hit {
      animation-name: blink;
      animation-duration: 1.5s;
      animation-timing-function: ease;
      animation-iteration-count: infinite;
      /* 위 속성들을 한 줄로 표기하기 */
      /* -webkit-animation: blink 1.5s ease infinite; */
    }
     
    /* 애니메이션 지점 설정하기 */
    /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
    @keyframes blink {
      from {color: white;}
      30% {color: yellow;}
      to {color: red; font-weight: bold;}
      /* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
    }
  </style>
</head>
<body>
  <div id="loginCheckForm">
    <c:if test="${id != null}">
      <%@include file="loginOk.jsp" %>
    </c:if>
  </div>
  <div id="listForm">
    <div id="listTitle">
      <b>게시판 글 목록 (전체 글: ${totalCount})</b>
    </div>
     
    <div id="writeLink">
      <a href="/bbs/writeForm.bbs?pageNum=${pageNum}">글쓰기</a>
    </div>
     
    <div>
      <table class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="10%">작성자</th>
            <th width="20%">작성일</th>
            <th width="10%">조회</th>
          </tr>
        </thead>
       <tbody>
  <c:forEach var="article" items="${articles}" varStatus="status">
    <tr>
      <td>${article.articleNumber}</td>
      <td id="title">
        <c:if test="${article.depth > 0}">
          <c:forEach var="i" begin="1" end="${article.depth}">
            <span>&nbsp;&nbsp;</span>
          </c:forEach>
        </c:if>
        <a href="/bbs/content.bbs?articleNumber=${article.articleNumber}&pageNum=${pageNum}" id="writeLink">${article.title}</a>
        <c:if test="${article.hit >= 20}">
          <span class="hit">hit!</span>
        </c:if>
      </td>
      <td>${article.id}</td>
      <td>${article.writeDate}</td>
      <td>${article.hit}</td>
    <tr>
  </c:forEach>
</tbody>
      </table>
      <%-- <div id="paging">
        ${pageCode}
      </div> --%>
      <!-- Paging 처리, Bootstrap -->
		<nav aria-label="..." style="text-align: center;">
		  <ul class="pagination">
		    ${pageCode}
		  </ul>
		</nav>
   </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
  <script>
    jQuery(document).ready(function() {
      if(${id== null}) {
        alert("게시판을 이용하시려면 로그인하셔야 합니다.");
        location.href="/bbs";
      }
    });
  </script>
</body>
</html>
