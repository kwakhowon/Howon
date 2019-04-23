<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 테스트</title>
</head>
<body>
	<h3>servlet 요청하기</h3>
	<h3>getContextPath() : <%= request.getContextPath()%></h3>
	<a href="<%=request.getContextPath()%>/simple">일반요청</a>
	<br>
	<a href="<%=request.getContextPath()%>/simple?type=date">날짜요청</a>
	<br>
	<a href="<%=request.getContextPath()%>/simple?type=aaaa">비정상요청</a>
	<br>
	<h3>FrontBoardController</h3>
	<a href="<%=request.getContextPath()%>/board?cmd=boardlist">게시판 목록 보기</a>
	<br>
	<a href="<%=request.getContextPath()%>/board?cmd=boardwrite">게시판 글쓰기</a>
	<br>
	<a href="<%=request.getContextPath()%>/board">Error 유도하기</a>
	<br>
	<a href="<%=request.getContextPath()%>/board?cmd=boarddelete">삭제하기 Error</a>
	<br>
</body>
</html>


