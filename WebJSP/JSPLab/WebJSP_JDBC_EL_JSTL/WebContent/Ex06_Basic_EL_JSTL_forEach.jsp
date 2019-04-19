<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습하기</title>
</head>
<body>
	<h3>JSTL for문</h3>
	<!--  
	int sum = 0;
	for(int i=1; i<=10; i++){
	sum += i;
	}
	-->
	<c:forEach var="i" begin="1" end="10">
		<c:set var="sum" value="${sum+i }" />
	</c:forEach>
	sum 누적값 : ${sum }
	<br>

	<h3>5단 출력하기</h3>
	<c:forEach var="i" begin="1" end="9">
		<li>5*${i} = ${5*i }</li>
	</c:forEach>
	<br>
	<h2>구구단 출력하기</h2>
	<table border="1">
		<c:forEach var="i" begin="2" end="9">
			<tr>
				<c:forEach var="j" begin="1" end="9">
					<td width="100px"><li>${i }*${j } = ${i*j }</li></td>
				</c:forEach>
			</tr>
			<br>
		</c:forEach>
	</table>
	<table border="1">
		<c:forEach var="i" begin="2" end="9">
			<c:forEach var="j" begin="0" end="9">
				<c:choose>
					<c:when test="${j==0 }">
						<tr bgcolor="yellow">
							<td>${i }단</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td>${i }*${j } = ${i*j }</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:forEach>
	</table>
	<h3>JSTL forEach 객체 출력하기</h3>
<%
	/* 객체를 만들거나 ... 주소값 처리 JAVA */
	/* 객체를 출력(화면에 보여주기) */
	int[] arr = new int[]{10,20,30,40,50};
	for(int i : arr){
		out.print("출력값 : " +i+"<br>");
	}
%>

<h3>************* EL은 JAVA 객체에 대한 직접 접근 불가 ***************** >> request , session, application 담거나 JSTL set 변수를 통해서 접근</h3>
arr 배열 객체 직접 접근 불가 : ${arr}<br> 
<c:set var="intarr" value="<%=arr %>" />
c:set 변수 접근 가능(EL) : ${ intarr }<br>
<h3>********forEach 개선된 for문 형태로 사용 가능 *********</h3>
<c:forEach var="i" items="${intarr }">
	배열값 : ${i}<br>
</c:forEach>
<hr>
<h3>********forEach items 사용하기 위해서 EL 변수 사용 *********</h3>
<c:forEach var="i" items="<%=arr %>">
	배열값 : ${i}<br>
</c:forEach>
<hr>
<h3>********* forEach items 사용하기 서버코드의 주소값 활용하기***********</h3>
<c:forEach var="i" items="<%= new int[]{1,2,3,4,5}%>">
	배열값 3 : ${i }<br>
</c:forEach>

<h3>forEach 활용하기 2탄</h3>
<c:forEach var="i" items="${intarr }" varStatus="status">
	index : ${status.index }&nbsp;&nbsp;&nbsp;
	count : ${status.count }&nbsp;&nbsp;&nbsp;
	values : ${i }<br>
</c:forEach>
</body>
</html>