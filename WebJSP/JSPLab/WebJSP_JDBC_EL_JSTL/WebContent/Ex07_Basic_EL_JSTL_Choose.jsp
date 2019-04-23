<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String name = request.getParameter("name");
	if(name.equals("hong")){
		out.print("<b>" + name + " </b>");
	}else if(name.equals("kim")){
		out.print("<i>" + name + "</i>");
	}else{
		out.print("<h3>" + name + "</h3>");
	}
	out.print("<hr>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>위 코드를 EL&JSTL 사용해서 바꾸세요</h3>
	<c:choose>
		<c:when test="${param.name=='hong' }">
			<li><b>${param.name }</b></li>
		</c:when>
		<c:when test="${param.name=='kim' }">
			<li><i>${param.name }</i></li>
		</c:when>
		<c:when test="${param.name }">
			<li><h3>${param.name }</h3></li>
		</c:when>
	</c:choose>
</body>
</html>