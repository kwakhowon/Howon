<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 
    	일반적으로 : 클라이언트에서 입력된 데이터 받기
    	Tomcat 내장객체 : request , response
    */
    request.setCharacterEncoding("UTF-8"); 
	String uid = request.getParameter("userid"); //단일값
	String pwd = request.getParameter("userpwd"); //단일값
	
	String[] hobbys = request.getParameterValues("hobby");
	  
	// 보통 >> JDBC (연결) >> CRUD >> 결과 >> Client 전달
	
%>

<!--  
 1. 이클립스 -> window > perferences > workspace > UTF-8 (Text 기반의 주석 처리)
 
 2. window -> perferences -> web > CSS files  -> Encoding (UTF-8)
    window -> perferences -> web > HTML files -> Encoding (UTF-8)
    window -> perferences -> web > JSP files  -> Encoding (UTF-8)
  
    TIP)한글 깨짐과 상관 없지만 .... HTML5형식의 JSP 페이지
 
 3.Tomcat(서버 : WAS) 한글 설정
   server.xml 서버 설정  (63번째 라인)
   <Connector connectionTimeout="20000" 
              port="8090" 
              protocol="HTTP/1.1" 
              redirectPort="8443"/>
   
 5.**한글 처리**
  전송방식 : GET (Tomcat9 한글 문제 없어요)
        -데이터를 받기 전(페이지 상단)
        -request.setCharacterEncoding("UTF-8"); 
        -<Connector URIEncoding="UTF-8" ..... 
  
 전송방식 : POST 
        -데이터를 받기 전(페이지 상단)
        -request.setCharacterEncoding("UTF-8"); 
      
정리 ) Tomcat 9 ..
페이지 상단 :  request.setCharacterEncoding("UTF-8"); 
그런데 만약 문제가 생기면
<Connector URIEncoding="UTF-8" ..... 
 -->   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신의 ID : <%= uid %><br>
	당신의 PWD : <%= pwd %><br>
	당신의 취미 : 
<%
	for(String str : hobbys){
%>
		hobby : <%=str %><br>
<%
	}
%>
	
</body>
</html>