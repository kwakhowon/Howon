<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠기값 쓰기</title>
</head>
<body>
<!--  
1. 메모리 쿠키 (브라우저 쿠키)
   :Client 강제로 지우지 않는 한 
   :브라우저를 닫기 전까지는 쿠기 값을 유지 한다.
   
2. 파일 쿠키(소멸 시간을 가지고 있다)
   :Client 강제로 지우지 않는 한 유지된다
   :정해진 만료 시간까지
   setMaxage(60) // 60초
   30일 (30*24*60*60) 일*시*분*초
-->
	<%
		Cookie co = new Cookie("bit", "kim");
		co.setMaxAge(30*24*60*60); //30일
		response.addCookie(co);
	%>
</body>
</html>