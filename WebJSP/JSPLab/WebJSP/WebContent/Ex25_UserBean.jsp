<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="empbean" class="kr.or.bit.Emp" scope="request"></jsp:useBean>
<%
   empbean.setEmpno(2000);
   empbean.setEname("kim");

/*  
	  Emp empbean = new Emp();
	  empbean.setEmpno(2000);
	  empbean.setEname("kim");
      request.setAttribute("empbean",empbean);
      
      [ scope ] 
      scope="page" 		  
      default (page) 
      
      scope="request"     
      request.setAttribute("empbean",empbean);
       현재 페이지 (incldue , forward 된 페이지 공유)
      
      scope="session"
      session.setAttribute("empbean",empbean);
       같은 session 가지는 모든 페이지에서
      
      scope="application"
      application.setAttribute("empbean",empbean);
      Web APP 안에 모든 페이지에 참조
      


*/

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="Ex25_UserBean_Forward.jsp"></jsp:forward>
</body>
</html>