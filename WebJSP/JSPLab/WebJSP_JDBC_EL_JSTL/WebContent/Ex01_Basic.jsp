<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//login.html -> submit -> Ex01_Basic.jsp
	String id = request.getParameter("userid");
	
	//id 다른 페이지에서도 공유
	//include , forward 
	request.setAttribute("name", "korea");
	
	//session 
	session.setAttribute("user", "bit");
	
%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!--  
EL : JSP 페이지에서 사용하는 스크립트 언어(화면에 출력 목적)
이유 : 스파게티(% ..... html 태그가 혼재되는 코드) : 유지보수 , 코드의 해석(가독성)
	   문제를 개선하기 위해서 script 기반 EL & JSTL 언어 생성
	   두가지 언어는 JSP 페이지에서만 사용가능
EL : JSP 페이지에서 화면 출력 목적 (% 녀석 없이 server 자원 출력)

EL 스크립트 언어 (기본 객체를 제공)
 pageContext	 		 pageContext 객체 참조
 pageScope				 page 영역 참조
 requestScope	 		 request 영역 참조
 sessionScope	 		 session 영역 참조
 applicationScope	 	 application 영역 참조
 param	 				 요청 파라미터의  값을 String으로, request.getParameter()의 결과와 동일
 paramValue				 요청 파라미터의  값을 String[]으로, request.getParameterValues()의 결과와 동일
 header	 				 요청 header 정보, request.getHeader()의 결과와 동일
 headerValues			 요청 header 정보를 배열, request.getHeaders()의 결과와 동일
 cookie	 				 쿠키 참조, request.getCookies()결과와 동일
 initParam				 컨텍스트의 초기화 파라미터, application.getInitParameter(이름)의 결과와 동일하다.
-->
스크립트릿 <b>	<%= id %></b>
스크립트릿 : <%= request.getAttribute("name") %>
<hr>
EL request value : ${requestScope.name }<br>
EL request value : ${name }<br>
원칙(고수) : EL session value : ${sessionScope.user }<br>
EL session value (생략) : ${user }<br>
<hr>
기존 <%= id %>	
<br>
EL request parameter : ${param.userid }<br>

<h3>EL (JSP에서 사용되는 script 언어)</h3>
스크립트릿 : <%= 200+400 %><br>

EL 은 표현식 >> 화면에 출력
EL : ${200+300 }<Br>
EL : ${"1"+1 }<br> <!-- 2 -->
EL : ${1==1 }<br>
EL : ${!true }<br>
EL : ${empty x}<br>

</body>
</html>