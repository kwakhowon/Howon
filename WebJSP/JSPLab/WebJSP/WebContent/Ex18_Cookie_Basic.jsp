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
클라이언트(로컬 PC 웹 브라우저)	:	서버(웹서버 : 메모리 , 파일저장 , DB서버)

정보(데이터 : 자료) 어디에 저장하고 보관할 것인가
고민 : 소멸시점(일시적 , 영속적) , 보안요소(정보 중요성)

Client(Local PC : 웹 브라우저)
1. Cookie (메모리 쿠키 , 파일 쿠키(txt : 암호화)) 구분점 : 소멸타임
2. Local Storage(브라우저 메모리 저장소) : (key :value)

>> 영속적으로 저장될 필요 없고 보안적으로 문제가 없는 데이터

Server(WebServer : Tomcat)
1. Server memory : session 객체(접속한 사용자 별로 하나씩) -> 임시
2. Server memory : application 객체(접속한 모든 사용자가 공유하는 객체) -> 임시
3. Server : log.txt 파일기반(영속적)
4. DB Server -> 영속적 , 보안
-->
</body>
</html>