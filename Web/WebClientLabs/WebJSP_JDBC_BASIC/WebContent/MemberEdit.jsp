<%@page import="kr.or.bit.utils.SingletonHelper" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.ResultSetMetaData" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        
        int row = 0;
        while (rs.next()) {
        	row = rs.getRow();
        }
        rs = pstmt.executeQuery();
    %>	
     
    
    <form action="MemberEditok.jsp" method="post">
      <div style="margin-top: 100px;">
        <table class="container">
    <c:forEach var="i" begin="1" end="<%= row%>">
        <c:set var="next" value="<%= rs.next()%>"/>
        <c:set var="id" value="<%= rs.getString(\"id\")%>" />
        <c:set var="pwd" value="<%= rs.getString(\"pwd\")%>" />
        <c:set var="name" value="<%= rs.getString(\"name\")%>" />
        <c:set var="age" value="<%= rs.getString(\"age\")%>" />
        <c:set var="email" value="<%= rs.getString(\"email\")%>" />
        <c:set var="gender" value="<%= rs.getString(\"trim(gender)\")%>" />
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
              <input type="text" name="id" value=${id } readonly>
            </td>
          </tr>
          <tr>
            <td>비번</td>
            <td>${pwd }
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td>
              <input type="text" name="name" value="
              ${name }"
                     style="background-color: gold">
            </td>
          </tr>
          <tr>
            <td>나이</td>
            <td>
              <input type="text" name="age" value="${age }"
                     style="background-color: gold">
            </td>
          </tr>
          <tr>
            <td>성별</td>
            <td>
              ${gender }
            </td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input type="text" name="email" value="${email }"
                     style="background-color: gold">
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <input type="submit" value="수정하기">
              <a href='MemberList.jsp'>리스트 이동</a>
            </td>
      </c:forEach>
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

