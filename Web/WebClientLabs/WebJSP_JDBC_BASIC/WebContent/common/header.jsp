<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
  String userid = (String) session.getAttribute("userid");
%>

<header>
  <nav>
    <ul class="top-nav">
      <li>
        <a href="index.jsp"><p>Main</p></a>
      </li>
      <%
        if (userid == null) {
          out.write("<li><a href=\"Login.jsp\">Login</a></li>");
          out.write("<li><a href=\"JoinForm.jsp\">Register</a></li>");
        } else {
          if (userid.equals("admin")) {
            out.write("<li><a href=\"MemberList.jsp\">MemberList</a></li>");
          }
          out.write("<li><a href=\"Logout.jsp\">Logout</a></li>");
        }
      %>
    </ul>
  </nav>
  <h1>3조</h1>
</header>