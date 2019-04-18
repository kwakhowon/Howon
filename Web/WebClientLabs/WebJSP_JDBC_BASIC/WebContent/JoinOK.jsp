<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");

  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");
  String name = request.getParameter("name");
  int age = Integer.parseInt(request.getParameter("age"));
  String gender = request.getParameter("gender");
  String email = request.getParameter("email");

  out.print(id + pwd + name + age + gender + email);

  Class.forName("oracle.jdbc.OracleDriver");
  Connection conn = null;
  PreparedStatement pstmt = null;

  try {
    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
    String sql = "insert into koreamember(id, pwd, name, age, gender, email, ip) values (?, ?, ?, ?, ?, ?, ?)";
    pstmt = conn.prepareStatement(sql);

    pstmt.setString(1, id);
    pstmt.setString(2, pwd);
    pstmt.setString(3, name);
    pstmt.setInt(4, age);
    pstmt.setString(5, gender);
    pstmt.setString(6, email);
    pstmt.setString(7, request.getRemoteAddr());

    int result = pstmt.executeUpdate();
    System.out.println(result);
    if (result != 0) {
      out.print("<script>");
      out.print("location.href='Login.jsp';");
      out.print("</script>");
    } else {
      out.print("<script>");
      out.print("alert(''); location.href='JoinForm.jsp';");
      out.print("</script>");
    }
  } catch (Exception e) {
    System.out.println(e.getMessage());
    out.print("<script>");
    out.print("alert('이미 가입된 아이디입니다.'); location.href='JoinForm.jsp';");
    out.print("</script>");
  } finally {
    System.out.println("Finally");
    if (pstmt != null) {
      try {
        pstmt.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    if (conn != null) {
      try {
        conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }


%>