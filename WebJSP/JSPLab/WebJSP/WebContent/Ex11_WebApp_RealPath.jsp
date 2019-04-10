<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
StringBuffer url = request.getRequestURL();    // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)
 String uri = request.getRequestURI();            // URI : 프로젝트 이하 경로 (CP + SP)
 String cp = request.getContextPath();           // CP : 프로젝트 명
 String sp = request.getServletPath();            // SP : 패키지 + 파일명
 
 System.out.println("URL : " + url);
 System.out.println("URI  : " + uri);
 System.out.println("CP   : " + cp);
 System.out.println("SP   : " + sp);
 

-----------------------------------------------------------------

 URL : http://localhost:8080/TestBoard/JSPBoard/created.jsp
 URI  : /TestBoard/JSPBoard/created.jsp
 CP   : /TestBoard
 SP   : /JSPBoard/created.jsp

-----------------------------------------------------------------

1. 웹 브라우저가 가지고 있는 경로 (가상경로)
 http://localhost:8090/WebJSP/Ex11_WebApp_RealPath.jsp

2. Ex11_WebApp_RealPath.jsp 파일의 실경로(물리적) 경로 ?
	C:\howon\WebJSP\JSPLab\WebJSP\WebContent\Ex11_WebApp_RealPath.jsp
	
3. 웹(가상경로) -> 실 경로(물리적 경로) 반환해 주는 객체
	request
	application
	
	활용 : 자료실 (파일 업로드)
	
	/download/note.txt
	request.getContextPath() : /WebJSP
	
	contextpath : C:\howon\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\WebJSP
	
	realpath : C:\howon\WebJSP\JSPLab\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\download\note.txt
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String resourcepath="/download/note.txt";
	out.print(resourcepath+"<br>");
	
	String contextpath = application.getRealPath(request.getContextPath());
	String realpath = application.getRealPath(resourcepath);
	
	out.print("request.getContextPath() : " +request.getContextPath() + "<hr>");
	out.print("contextpath : " +contextpath + "<hr>" );
	out.print("realpath : " +realpath + "<hr");
%>
</body>
</html>