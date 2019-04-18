<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL 출력 (서버자원) .....
	//EL 사용된다고 해서 모든 java 코드를 표현하는 스크립트릿이 생성되는 것은 아니다.
	
	//예를들면 
	Date today = new Date();
	request.setAttribute("day", today);
	session.setAttribute("day2", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 목적(출력)</h3>
	<%= request.getAttribute("day") %><br>
	EL : ${day}<br>
	<!-- 좋은 방식은 아니다 : day 습관적으로 출처-->
	습관 : ${requestScope.day }<br>
	session EL : ${sessionScope.day2 }
	
</body>
</html>