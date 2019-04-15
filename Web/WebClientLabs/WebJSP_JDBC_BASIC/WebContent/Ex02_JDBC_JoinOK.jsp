<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
		Ex02_JDBC_JoinForm.jsp에서 --> action="Ex02_JDBC_JoinOK.jsp"
		1. 한글처리
		2. parameter 받기 (확인)
		3. 로직처리(업무) : 회원가입 처리 >> 데이터 받고 > DB연결 > Insert > 유무 > Client 전달
		4. 회원가입 성공 > 페이지 이동 > 로그인 페이지 이동 (Ex02_JDBC_Login.jsp)
	  이동 : response.sendRedirect(" ") , javascript > (location.href=" ")
		   >>이동 >> 클라이언트가 페이지를 재요청
	  
		   
	  회원가입 실패 > 경고창 (가입 실패 ) > 회원가입 이동 
	  서버코드 작성 : <script > alert .... ; location.href...... </script> 
	  
	 클라이언트 정보(request) 객체 (request.getRemoteAddr())
		   id , pwd , name, age , gender , email , ip
	*/
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	String name = request.getParameter("mname");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	//out.print(id + "/" + pass + "/" + name + "/" + age + "/" + gender + "/" + email);

	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null;
	PreparedStatement pstmt = null;

	//getConnection Connection 구현한 객체의 주소값 return
	try {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
		String sql = "insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		pstmt.setString(3, name);
		pstmt.setInt(4, age);
		pstmt.setString(5, gender);
		pstmt.setString(6, email);
		pstmt.setString(7, request.getRemoteAddr());

		int result = pstmt.executeUpdate();
		if (result != 0) {
			out.print("<script>");
			out.print("location.href='Ex02_JDBC_Login.jsp'");
			out.print("</script>");
		} else { //pstmt.executeUpdate(); 정상실행되고 나서 result 결과값을 가지고 ....
			out.print("<script>");
			out.print("location.href='Ex02_JDBC_Login.jsp'");
			out.print("</script>");
		}
	} catch (Exception e) {
		//pstmt.executeUpdate();
		//실제 페이지 이동은 예외처리 구문에서 ....
		System.out.println(e.getMessage());
		out.print("<script>");
		out.print("alert('오류발생');");
		out.print("location.href='Ex02_JDBC_JoinForm.jsp'");	
		out.print("</script>");
	} finally {
		System.out.println("Finally");
	    if(pstmt != null) try{pstmt.close();}catch(Exception e){e.printStackTrace();}
	    if(conn != null) try{conn.close();}catch(Exception e){e.printStackTrace();}
	}
%>