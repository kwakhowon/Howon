<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<%
	String uid = request.getParameter("UID");
	String pwd = request.getParameter("PWD");
	String chk = request.getParameter("chk");
%>
</head>
<body>
<!--  
UID , PWD , CHK 여부
1. ID , PWD 같다면 로그인 성공 (id(ID.equals(....)
   Chk을 체크 되어있다면 
   > Cookie 생성 ID 값을 쿠키에 담아서 : 유효타임 24시간
   > 쿠기 쓰기 완료
   
2. ID , PWD 같다면 로그인 성공 (id(ID.equals(....)
   Chk 체크 되어 있지 않다면
   >만들었던 쿠키 삭제 : setMaxAge(0);
   Cookie delco = new Cookie("UID","");
   delco.setMaxAge(0);
   response.addCookie(delco);
   
3. ID , PWD 같지 않다면
	response.sendRedirect() -> Ex19_login.jsp 이동처리
-->
<%
	if(!uid.equals(pwd)){
		response.sendRedirect("Ex19_login.jsp");
	}else{
		if(chk==null){
			Cookie delco = new Cookie("saveId","");
			delco.setMaxAge(0);
			response.addCookie(delco);
		}else if(chk.equals("on")){
			Cookie createco = new Cookie("saveId", uid);
			createco.setMaxAge(30*24*60*60);
			response.addCookie(createco);
					
		}
	}
%>

**로그인 성공**
<br><%= uid %> 님 환영합니다.
</body>
</html>