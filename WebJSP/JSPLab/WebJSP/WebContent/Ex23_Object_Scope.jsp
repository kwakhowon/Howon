<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
	Tomcat(AWS) 제공하는 기본적인 객체
	1. request (요청 : 클라이언트 정보)
	2. response (응답 : 특정 페이지 이동 , 정보 출력(쿠키 쓰기))
	3. application (전역 객체 : web.xml 제어 , 전역변수)
	4. session (사용자마다 고유하게 부여되는 객체 ,,, 변수)
	5. out 
	6. page
	.........
	session 객체 
	1. session 변수 활용
	   session.setAttribute(변수명 , 값)
	   scope : 모든 페이지 사용가능
	   ex) a.jsp (session.setAttribute .. user) -> b.jsp(session.getAttribute(user)
	   Life-cycle : sessionId 와(객체)
	   
	2. application 객체
	1. application 변수 : 전역변수
	      내 사이트에 접속한 모든 session이 제어할 수 있는 변수
	   scope : 모든 사용자(모든 session) + 모든 페이지 ( java : static)
	   Life-cycle : Web server 죽으면 (재부팅)
	   
	request 객체
	request.setAttribute("변수","값");
	scope : 요청 페이지 (Client > login.jsp 요청) >> request 객체 생성
	POINT > login.jsp (include , forward) 된 페이지에서 request 객체 참조 가능
-->	
<%
	Emp emp = new Emp();
	emp.setEmpno(2000);
	emp.setEname("홍길동");
	
	session.setAttribute("empobj", emp);
	
	Emp e= (Emp)session.getAttribute("empobj");
	out.print(e.getEmpno()+"<br>");
	out.print(e.getEname()+"<br>");
	
	request.setAttribute("who", "king");
	String who = (String)request.getAttribute("who");
	out.print("request : " +who);
%>
<!--  
<jsp:include page="b.jsp" />

b.jsp
request.getAttribute("who");
-->	
</body>
</html>