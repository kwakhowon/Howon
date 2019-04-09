<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	//1. request (클라이언트가 입력한 값을 얻어 올 수 있다)
	//input > text , password , radio , textarea , select
	//넘어오는 값이 : 단일값 , 다중값
	//input type="text" name = "userid" ?userid=howon
	
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("pwd");
	
	//2. 다중값 
	//input type > checkbox , (name 동일) , select (multiple)
	String[] hobbys = request.getParameterValues("hobby");
	
	Enumeration<String> e = request.getParameterNames();
	String name ="";
	while(e.hasMoreElements()){
		name += "/" +e.nextElement();
		
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	출력 1 ) <%= userid %><br>
	출력 2 ) <%= userpwd %><br>
	<%
		for(String str : hobbys){
	%>
		취미 : <%= str %><br>
	<% 		
		}
	%>
	[request.getParameterNames()] : <%=name %><br>
</body>
</html>