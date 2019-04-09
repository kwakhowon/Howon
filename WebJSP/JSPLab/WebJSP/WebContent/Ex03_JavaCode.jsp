<%@page import="java.util.Calendar"%>
<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Emp emp = new Emp();
	emp.setEmpno(1000);
	emp.setEname("홍길동");
	//Calendar 객체 생성하고
	//오늘날짜
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int minute = cal.get(Calendar.MINUTE);
	int second = cal.get(Calendar.SECOND);

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	출력 표현식 <br>
	사번 : <%= emp.getEmpno() %><br>
	이름 : <%= emp.getEname() %><br>
	전체 : <%= emp.toString() %><br>
	<hr>
	현재 날짜 : <%=year %>  <%=month %>월 <%= day %>일 <%= hour %>시 <%= minute %>분 <%= second %>초
</body>
</html>