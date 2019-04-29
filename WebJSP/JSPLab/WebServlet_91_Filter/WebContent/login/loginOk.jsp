<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글처리
	//request.setCharacterEncoding("UTF-8"); //공통관심
	//데이터 받기 전에
	//한글 처리가 필요한 모든 페이지 상단에 위 코드가 필요
	
	//관심사(주관심 , 보조관심(공통관심))
	//주관심 : 데이터 받아서 클라이언트에게 보여주기
	//보조관심 : 공통사항 (모든 페이지 상단 한글처리)
	
	//분리 (보조관심 : 공통사항) >> Filter 객체 ....
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	한글명 : ${param.kor }<br>
	영문명 : ${param.eng }<br>
</body>
</html>