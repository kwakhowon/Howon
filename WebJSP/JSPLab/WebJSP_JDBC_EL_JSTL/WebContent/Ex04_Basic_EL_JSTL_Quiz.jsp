<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- http://java.sun.com/jsp/jstl/core >> c로 대체 -->
<%
	 String id = request.getParameter("ID");
	if(id.equals("hong")){
%>
	<%-- <%=id%><img src="images/login.png" alt="이미지" style="width: 100px;height: 100px"> --%>
<%		
	} 
	String age = request.getParameter("age");
%>    
<!--  
 param      :	 요청 파라미터의  값을 String으로, request.getParameter()의 결과와 동일
 paramValue	:    요청 파라미터의  값을 String[]으로, request.getParameterValues()의 결과와 동일
-->    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>EL 과 JSTL</h3>
	<c:if test="${param.ID == 'hong' }"><!-- if(i>100){} -->
	${param.ID} <img src="images/login.png" alt="이미지" style="width: 100px;height: 100px">
	</c:if>
	 
	 <!-- Client 에서 ?age =100 값을 받아서 age 값이 20 보다 큰 값이면 그 값을 출력하는 EL & JSTL 구문을 작성하세요 -->
	 <br><br>
	<c:if test="${param.age>20 }" var="result">
	param value : ${param.age }
	</c:if>
	<br>
	if구문의 조건 결과값 : ${result }
</body>
</html>















