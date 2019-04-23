<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	String result = null;
	if(user_id.equals("bituser")&& user_pw.equals("1004")){
		result = "success";
	}else{
		result = "fail";
	}
%>
<%= result %>