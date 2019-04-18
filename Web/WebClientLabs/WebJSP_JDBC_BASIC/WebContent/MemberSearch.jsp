<%@page import="kr.or.bit.utils.SingletonHelper" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  request.setCharacterEncoding("UTF-8");
  if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
    out.print("<script>location.href = 'Login.jsp'</script>");
    // 강제로 다른 페이지로 이동
  }
%>
<jsp:include page="common/head.jsp"/>
<link rel="stylesheet" href="css/Detail_Table.css">
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div class="center-area">
  <jsp:include page="common/aside.jsp"/>
  <main>
    <%
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String name = request.getParameter("search");

      try {
        conn = SingletonHelper.getConnection("oracle");
        String sql1 = "select count(*) from koreamember where name like ?";
        String sql2 = "select id, name, email from koreamember where name like ?";
        pstmt = conn.prepareStatement(sql1);

        pstmt.setString(1, "%" + name + "%");

        rs = pstmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        System.out.println(count);
    %>
    <table class="container" style="height: 100px; margin-left: auto; margin-right: auto">
      <tr>
        <th colspan="3">회원 조회 결과</th>
      </tr>
      <%
        if (count > 0) {
      %>
      <tfoot>
      <td colspan="3">조회 결과 : <%=count%>명</td>
      </tfoot>
      <%
          pstmt = conn.prepareStatement(sql2);
          pstmt.setString(1, "%" + name + "%");
          rs = pstmt.executeQuery();
          while (rs.next()) {
      %>
      <tr>
        <td>
          <a href='Member_Detail.jsp?id=<%=rs.getString("id")%>'><%=rs.getString("id")%>
          </a>
        </td>
        <td>
          <%=rs.getString("name")%>
        </td>
        <td>
          <%=rs.getString("email")%>
        </td>

      </tr>
      <%
          }
        } else {
      %>
      <tfoot>
        <td colspan="3">조회 결과가 없습니다</td>
      </tfoot>
      <%
          }
      %>
    </table>
    <hr>
    <form action="MemberSearch.jsp" method="post">
      회원명 : <input type="text" name="search">
      <input type="submit" value="이름 검색 하기">
    </form>
    <hr>
    <%
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } finally {
        SingletonHelper.close(rs);
        SingletonHelper.close(pstmt);
      }
    %>
  </main>
</div>
<jsp:include page="common/footer.jsp"/>