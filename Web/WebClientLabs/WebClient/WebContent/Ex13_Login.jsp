<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JAVA 코드 구현
	String userid = request.getParameter("userId");
	String userpwd = request.getParameter("userPwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 입력한 데이터 는 </h3>
	ID : <%=userid %>
	PWD : <%= userpwd %>
</body>
</html>