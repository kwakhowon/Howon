<%@page import="kr.or.bit.utils.SingletonHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%
  request.setCharacterEncoding("UTF-8");

  //2. 데이터 받기
  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");


  //Class.forName("oracle.jdbc.OracleDriver");
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  try {
    //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosta","1004");;
    conn = SingletonHelper.getConnection("oracle");
    String sql = "select id, pwd from koreamember where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    rs = pstmt.executeQuery();

    while (rs.next()) {
      if (pwd.equals(rs.getString("pwd"))) {
        session.setAttribute("userid", rs.getString("id"));

        out.print("<script>");
        out.print("location.href = 'index.jsp'");
        out.print("</script>");
      } else {
        out.print("<script>");
        out.print("location.href = 'Login.jsp'");
        out.print("</script>");
      }
    }

    out.print("<script>");
    out.print("location.href='Login.jsp'");
    out.print("</script>");

  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    System.out.println("Finally");
    SingletonHelper.close(rs);
    SingletonHelper.close(pstmt);
    //연결은 해제 하지 않아요 ....
  }
%>
