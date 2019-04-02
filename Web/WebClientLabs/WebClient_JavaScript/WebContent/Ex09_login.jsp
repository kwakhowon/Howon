<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("txtuserid");
	String userpwd = request.getParameter("txtpwd");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>당신이 입력한 데이터 </h3>
	ID : <%= userid %><br>
	PWD : <%= userpwd %>
</body>
</html>