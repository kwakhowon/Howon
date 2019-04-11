<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="empbean" class="kr.or.bit.Emp" scope="request"></jsp:useBean>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
객체의 주소를 받는다
<%
	out.print(empbean.getEmpno() + "<br>");
	out.print(empbean.getEname() + "<br>");
%>
</body>
</html>