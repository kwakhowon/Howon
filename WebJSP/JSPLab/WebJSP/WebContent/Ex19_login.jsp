<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%
	/*
	 쿠키값(사용자 ID)이 존재하면 UID input value 속성에 그 값을 출력
	 쿠기값을 read 해서 쿠키 변수명이 UID라면 .... 그 값을 
	 
	*/
	String id = "";
	String cookieName = "saveId";
	Cookie[] cs = request.getCookies();
	if(cs != null || cs.length>0){
		for(Cookie c : cs){
			if (c.getName().equals(cookieName)) {
			       id = c.getValue();
			    }
			}
	}
	%>
</head>
	<script type="text/javascript">
	window.onload = function(){
	var data = '<%=id %>';
	console.log(data+"님");
	 document.getElementById("UID").value=data;
		}
	</script>
<body>
	<form action="Ex19_loginok.jsp" method="get">
	ID : <input type="text" name="UID" value="<%=id %>" ><br>
	PWD : <input type="password" name="PWD"><br>
	<hr>
	ID 값 유지하기 <input type="checkbox" name="chk">
	<hr>
	<input type="submit" value="로그인">
	<input type="reset" value="취소">
	</form>
</body>
</html>