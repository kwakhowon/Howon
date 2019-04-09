<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	
	/* 
	request 객체
	Tomcat 이 가지고 있는 내장객체(웹 프로젝트가 톰켓 서버 설정을 가지고 있어야 한다.)
	
	request 객체(요청객체)
	1. 요청 페이지당 한개의 request 객체 자동 생성
	2. 클라이언트의 정보를 read
	3. 클라이언트 정보(입력값 , 기본정보 : 브라우저 버전 , IP)
	request 내장 객체는 클라이언트에서 서버로 요청할 때 생성되는 
	httpServletRequest 타입의 객체가 생성되고 그 주소를 request 변수가 참조
	
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id : <%= id %><br>
	접속한 클라이언트 IP : <%= request.getRemoteAddr() %><br>
	서버(요청한 방식 : 인코딩) : <%= request.getCharacterEncoding() %><br>
	전송방식 : <%= request.getMethod() %><br>
	포트번호 : <%= request.getServerPort() %><br>
	context root(가상 디렉토리 , 홈 디렉토리) : <%= request.getContextPath() %> 
	<hr>
	<!--  
	/WebJSP/Ex04_request.jsp >> 가상 (웹) 경로
	실경로 (물리적 경로) :
	C:\howon\WebJSP\JSPLab\WebJSP\WebContent\Ex04_request.jsp
	-->
	<%= request.getRequestURI() %>
	
</body>
</html>