<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- https://www.hscripts.com/tutorials/jsp/jstltags/function-tag.php -->
<c:set var="str" value="oracle" />
변수값 출력 : ${str }<br>
대문자 : ${fn:toUpperCase(str)}<br>
문자열 길이 : ${fn:length(str)}<br>
치환 : ${fn:replace(str,'a','AAA' )}<br>

</body>
</html>