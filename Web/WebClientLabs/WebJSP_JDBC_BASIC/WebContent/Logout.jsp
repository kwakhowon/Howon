<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate(); //session 객체 삭제
  out.print("<script>location.href='Login.jsp'</script>");
%>

