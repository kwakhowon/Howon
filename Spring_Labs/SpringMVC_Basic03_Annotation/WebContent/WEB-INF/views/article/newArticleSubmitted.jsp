<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력값 확인하기</title>
</head>
<body>
	<h3>게시판 입력 내용 확인</h3>
	<%-- 제목 : ${newArticleCommand.title }<br>
	내용 : ${newArticleCommand.content }<br>
	순번 : ${newArticleCommand.parentId }<br> --%>
	제목 : ${Articledata.title }<br>
	내용 : ${Articledata.content }<br>
	순번 : ${Articledata.parentId }<br>
</body>
</html>