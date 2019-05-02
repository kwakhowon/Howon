<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection pool</title>
</head>
<body>
  <%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    Context context = new InitialContext(); // 이름 기반 검색
    DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // jdbc/oracle 이름의 pool을 찾음
    
    conn = ds.getConnection(); // Pool 안에 있는 connection 객체 얻어오기
    
    out.print("DB 연결 유무 확인(isClosed): " + conn.isClosed() + "<br>");
    // POINT
    conn.close(); // Connection 객체를 pool에 다시 반환
    out.print("DB 연결 유무 확인(isClosed): " + conn.isClosed());
  %>
</body>
</html>