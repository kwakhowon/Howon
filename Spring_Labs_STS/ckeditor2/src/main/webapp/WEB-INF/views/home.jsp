<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="${pageContext.request.contextPath}/resources/common/ckeditor.js"></script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div style="display: grid;">
		<div style="display: grid; grid-column-start: 1; grid-column-end: 2;">
			<textarea name="content" id="content" class="ckeditor" rows="10" cols="80"></textarea>
		</div>
	</div>
</body>
</html>
