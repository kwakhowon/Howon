<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
클라이언트 (로컬PC)    :       서버(웹서버 : 메모리 , 파일)

정보 (데이터:자료) 어디에 저장하고 보관할까
고민: 소멸(일시적 , 영속적) , 보안요소(정보의 중요성)

Client (Local PC : 웹 브라우져)
1.Cookie (메모리 쿠키 , 파일 쿠키(암호화) : 소멸시기)
2.Local storage (저장소)

>> 영속적으로 저장될 필요가 없고 보안적으로 문제가 없는 데이터 

Server(WebServer : Tomcat)
1.Server memory : session 객체 (접속한 사용자 식별 .... 접속시간 등..)  -> 임시
2.Server memory " application 객체 (접속한 모든 사용자가 사용가능한 공유 객체) -> 임시
3.Server : log.txt 파일 기반 (영속)
4.DB Server -> 영속적 

-->
	<%
		Cookie mycookie = new Cookie("cname", "1007"); //쿠키 객체 생성
		//내 서버에 접속한 클라이언트에게 전달(write)
		response.addCookie(mycookie);
	%>
	서버 설정한 쿠키 이름:<%=mycookie.getName()%><br> 서버 설정한 값:
	<%=mycookie.getValue()%><br> 서버 설정한 쿠키 소멸정보 : (-1 소멸시간이 없다) :
	<%=mycookie.getMaxAge()%><br>

	<hr>
	<!-- 서버가 클라이언트에게 Response 한 cookie 객체 얻어오기 -->
	<%
		Cookie[] cs = request.getCookies();
		if (cs != null || cs.length > 0) {
			for (Cookie c : cs) {
				out.print(c.getName() + "<br>");
				out.print(c.getValue() + "<br>");
				out.print(c.getMaxAge() + "<br>");
			}
		}
	%>
</body>
</html>










