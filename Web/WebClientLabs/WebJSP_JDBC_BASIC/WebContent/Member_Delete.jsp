<%@page import="kr.or.bit.utils.SingletonHelper" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
    //강제로 다른 페이지 이동
    out.print("<script>location.href='Login.jsp'</script>");
  }

  String id = request.getParameter("id");
  Connection conn = null;
  PreparedStatement pstmt = null;

  try {
    conn = SingletonHelper.getConnection("oracle");
    String sql = "delete from koreamember where id = ? ";
    pstmt = conn.prepareStatement(sql);

    pstmt.setString(1, id);
    int row = pstmt.executeUpdate();
    if (row > 0) {
      out.print("<script>location.href='MemberList.jsp'</script>");
    } else {
      //필요에 따라 구현
    }

  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    SingletonHelper.close(pstmt);
  }
%>
