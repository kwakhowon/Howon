<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- http://java.sun.com/jsp/jstl/core >> c로 대체 -->
<%
	Emp e = new Emp();
	e.setEmpno(2000);
	e.setEname("홍길동");
	
	HashMap<String, String> hp = new HashMap<>();
	hp.put("data", "1004");
	
	//Map<String, String> hp = new HashMap<>();
	// 객체는 >> jstl로 담고 출력은 el로 한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
기존방식 : <%= e %><br>
기존방식 : <%= e.getEmpno() %><br>
기존방식 : <%= e.getEname() %><br>

<h3>EL(출력)</h3>
자바객체 출력하기 (EL은 객체에 대한 직접 접근 불가) : 	${e }<br>
자바객체 속성 출력하기 : ${e.getEmpno() }<br>

1. JSTL(core) 변수를 생성 , 제어문<br>
<c:set var="emp" value="<%=e%>" /> <!-- value에 값을 넣어주고 var 값으로 접근 -->
JSTL 변수 m 을 만들고 서버쪽 객체 주소값을 설정 : ${emp }
<hr>
EL 출력 : JSTL 변수값을 출력 : ${emp }<br>
EL 출력 : JSTL 변수(실제로는 이렇게 안쓰고) : ${emp.getEmpno() }<br>
EL 출력 : 변수 통해서 getter 함수 호출(member field 기술) : ${ emp.empno }<br>
EL 출력 : 변수 통해서 getter 함수 호출 : ${ emp.ename }<br>

<h3>EL & JSTL 사용하기</h3>
******** EL 통해서 객체에 직접 접근 불가 *************<br>
******** e 객체를 : request , session 을 담으면 EL 접근 가능 <br>

JSTL 변수의 (value) 값으로 EL 표현식을 사용할 수 있다.<br>
<c:set var="username" value="${emp.ename }" />
변수가 담긴 값을 출력 : ${username}<br>
<hr>
<h3>JSTL 변수를 만들고 Scope 정의 하기</h3>
<c:set var="job" value="농구선수" scope="request" />
당신의 직업은 : ${job }<br>
[include] or [forward] 된 페이지에서 JSTL 변수값을 공유할 수 있다.

변수 삭제하기<br>
<c:set var="job2" value="야구선수" scope="request" /><br>
${job2 }<br>
<c:remove var="job2"/>
job2 변수 삭제 : ${job2 }<br>

<c:set var="vhp" value="<%=hp %>" />
hp 객체 : ${vhp }<br>
hp 객체 : ${vhp.data }<br>
<!--  
	hp.put("color","red");
-->
JSTL 사용해서 put 함수 구현<br>
<c:set target="${vhp }" property="color" value="red"/> <!-- 속성 추가 -->
hp객체 : ${vhp }
</body>
</html>