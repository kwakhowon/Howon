<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 

String userid = request.getParameter("userId");
String username = request.getParameter("userName");
String userpwd = request.getParameter("userPass");
String gender = request.getParameter("gender").equals("mail") ? "여자" : "남자";
String email = request.getParameter("userEmail");
String junin1 = request.getParameter("userSsn1");
String jumin2= request.getParameter("userSsn2");
String userZipCode = request.getParameter("userZipCode");
String userAddr1 = request.getParameter("userAddr1");
String userAddr2 = request.getParameter("userAddr2");
String userPhone = request.getParameter("userPhone");
String[] hobbys = request.getParameterValues("hobby");
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 완료 페이지</h3>
	ID : <%= userid%><br>
	Name : <%= username %><br>
	PWD : <%= userpwd %><br>
	성별 : <%= gender %><br>
	Email : <%= email %><br>
	주민번호 : <%= junin1 %> - <%= jumin2 %><br>
	우편번호 : <%= userZipCode %><br>
	주소 : <%=userAddr1 %> <%= userAddr2 %><br>
	Phone : <%= userPhone %><br>
	취미 : <br>
	<%
	for(String str :hobbys){
	%>
		<%= str%><br>
	<%
	}
	%>
	생년월일 : <%= year %> 년 <%= month %> 월 <%= day %> 일
	
</body>
</html>