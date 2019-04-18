<%@page import="kr.or.bit.utils.SingletonHelper" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.ResultSetMetaData" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<jsp:include page="common/head.jsp"/>
<link rel="stylesheet" href="css/Detail_Table.css">
</head>
<body style="color: black;">
<jsp:include page="common/header.jsp"/>
<div class="center-area">
  <jsp:include page="common/aside.jsp"/>
  <main>
    <%
      if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
        out.print("<script>location.href = 'Login.jsp'</script>");
        // 강제로 다른 페이지로 이동
      }
      String id = request.getParameter("id");
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
        conn = SingletonHelper.getConnection("oracle");
        String sql = "select id, pwd, name, age, trim(gender), email from koreamember where id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);

        rs = pstmt.executeQuery();

        rs.next();
    %>
    <form action="MemberEditok.jsp" method="post">
      <div style="margin-top: 100px;">
        <table class="container">
          <tr>
            <td colspan="2">
              <div style="text-align:center; margin-bottom:40px;">
                <h1 style="color: white; font-family: sans-serif">수정하기</h1>
              </div>
            </td>
          </tr>
          <tr>
            <td>아이디</td>
            <td>
              <input type="text" name="id" value="<%=rs.getString("id")%>" readonly>
            </td>
          </tr>
          <tr>
            <td>비번</td>
            <td><%=rs.getString("pwd")%>
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td>
              <input type="text" name="name" value="<%=rs.getString("name")%>"
                     style="background-color: gold">
            </td>
          </tr>
          <tr>
            <td>나이</td>
            <td>
              <input type="text" name="age" value="<%=rs.getString("age")%>"
                     style="background-color: gold">
            </td>
          </tr>
          <tr>
            <td>성별</td>
            <td>
              [<%=rs.getString(5)%>]
              <input type="radio" name="gender" id="female" value="F"
                     <%if (rs.getString(5).equals("F")) {%>checked<%}%>>여자
              <input type="radio" name="gender" id="male" value="M"
                     <%if (rs.getString(5).equals("M")) {%>checked<%}%>>남자
            </td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input type="text" name="email" value="<%=rs.getString("email")%>"
                     style="background-color: gold">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="submit" value="수정하기">
              <a href='MemberList.jsp'>리스트 이동</a>
            </td>
        </table>
      </div>
    </form>
  </main>
</div>
<jsp:include page="common/footer.jsp"/>
  <%
	    } catch(Exception e) {
                e.printStackTrace();
            } finally {
                SingletonHelper.close(rs);
                SingletonHelper.close(pstmt);
            }
    %>

