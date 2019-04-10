<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
	404 : file not found
	500 : 서버족 코드(실행시 0 으로 , null에 대한 잘못된 처리)
	
	500 예외 발생하면 ..... 
-->
<%
	String data = request.getParameter("name").toLowerCase();

%>
</body>
</html>