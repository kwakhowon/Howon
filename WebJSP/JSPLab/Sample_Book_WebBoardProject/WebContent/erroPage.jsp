<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>
  <c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
    <p>404(찾을 수 없음): 서버가 요청한 페이지를 찾을 수 없습니다.</p>
    <p>예를 들어 서버에 존재하지 않는 페이지에 대한 요청이 있을 경우 서버는 이 코드를 제공합니다.</p>
  </c:if>
  <c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">
    <p>500(내부 서버 오류): 서버에 오류가 발생하여 요청을 수행할 수 없습니다.</p>
  </c:if>
  <a href="/bbs/list.bbs?pageNum=1">돌아가기</a>
</body>
</html>
