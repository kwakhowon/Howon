<%@page import="kr.or.bit.utils.SingletonHelper" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
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

      try {
        conn = SingletonHelper.getConnection("oracle");
        String sql = "select id, ip from koreamember";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
    %>
    <table class="container" style="height: 100px; margin-left: auto; margin-right: auto">
      <tr>
        <th colspan="4">회원리스트</th>
      </tr>
      <%
        while (rs.next()) {
      %>
      <tr>
        <td>
          <a href='Member_Detail.jsp?id=<%=rs.getString("id")%>'><%=rs.getString("id")%>
          </a>
        </td>
        <td>
          <%=rs.getString("ip")%>
        </td>
        <td class="delmod">
          <a href='Member_Delete.jsp?id=<%=rs.getString("id")%>'>[삭제]</a>
        </td>
        <td class="delmod">
          <a href='MemberEdit.jsp?id=<%=rs.getString("id")%>'>[수정]</a>
        </td>
      </tr>
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
        e.printStackTrace();
      } finally {
        SingletonHelper.close(rs);
        SingletonHelper.close(pstmt);
      }
    %>
  </main>
</div>
<jsp:include page="common/footer.jsp"/>