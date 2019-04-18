<%@page import="java.sql.ResultSet" %>
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
%>

<jsp:include page="common/head.jsp"/>
<link rel="stylesheet" href="css/Detail_Table.css"/>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div class="center-area">
  <jsp:include page="common/aside.jsp"/>
  <main>
    <%
      String id = request.getParameter("id");
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
        conn = SingletonHelper.getConnection("oracle");
        String sql = "select id, pwd, name, age, gender, email from koreamember where id = ?";
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        while (rs.next()) {
    %>
    <img src="images/user.png" style="float: left; margin: 5%;">
    <table class="container" style="float: left; margin: 0 auto;">
      <tr>
        <td>아이디</td>
        <td><%= rs.getString("id") %>
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td><%= rs.getString("pwd") %>
        </td>
      </tr>
      <tr>
        <td>이름</td>
        <td><%= rs.getString("name") %>
        </td>
      </tr>
      <tr>
        <td>나이</td>
        <td><%= rs.getString("age") %>
        </td>
      </tr>
      <tr>
        <td>성별</td>
        <td><%= rs.getString("gender") %>
        </td>
      </tr>
      <tr>
        <td>이메일</td>
        <td><%= rs.getString("email") %>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <a href="MemberList.jsp" style="color: white;">목록 가기</a>
        </td>
      </tr>
    </table>
    <%
        }
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