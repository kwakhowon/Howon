<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
out 객체 : 서버쪽 구현 편하다
단점 : 클라이언트 코드 구현은 문자열로 표현
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat(WAS) 내장객체(out)</title>
</head>
<body>
<%
	boolean b = true;
	if(10 > 5){
%>
	If(true) : <font color="red"><%= b %></font>
<%			
	}else{
		b = false;
%>
	If(false) : <font color="blue"><%= b %></font>
<% 
	}
%>
<h3>out 객체(서버코드 작업이 편해요)</h3>
<%
	boolean b2 = true;
	if(10 > 5){
		out.print("If(true) : <font color='red'>"+b2+"</font>");
	}else{
		out.print("If(false) : <font color='blue'>"+b2+"</font>");
	}
%>

</body>
</html>