<%@page import="kr.or.kosta.utils.SingletonHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 /*  
 1. 한글처리
 2. 데이터 받기(ID, PWD)
 3. DB 연동(sql)
 4. 업무(로직) 처리
 
    id, pwd 를 parameter 로 받아서 회원인지 아닌지 판단
    
    --판단조건
    1.ID 존재 , PWD(0) > 회원 > Main page 이동 > session.setAttribute("userid",ID값); 
    2.ID 존재 , PWD(x) > 다시 한번 로그인 처리 (로그인 페이지)
    3.ID 존재(x) > 회원가입 페이지로 이동 처리
    
    1.Ex02_JDBC_Main.jsp
    2.Ex02_JDBC_Login.jsp
    3.Ex02_JDBC_JoinForm.jsp
    
    >sql : select id, pwd  from koreamember where id=?
    >(x)sql : select count from koreamember where id=?	
    		
    >>SELECT ..... 		
    1. 결과	없는 경우
    
    2. Single row
    
    3. Multi row (회원데이터)
    
    if(rs.next()){
    	 do{
    		 System.out.println(rs.getInt(1));
    	 }while(rs.next());
    }else{
    	회원이 아닌 경우
    }
    
    요구사항 
    https://cafe.naver.com/kangnamfullstack/665
  
    기능적 요구사항
    로그인이 가능
    ...
    비기능적 요구사항
    SingletonHelper 을 사용해서 코드 중복성을 줄인다 
 */
 	//1. 한글처리
 	request.setCharacterEncoding("UTF-8");
	
	//2. 데이터 받기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	
	//Class.forName("oracle.jdbc.OracleDriver");
	Connection   conn = null;
 	PreparedStatement pstmt = null;
 	ResultSet rs = null;
 
 try{
	
 	//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosta","1004");;
 	conn = SingletonHelper.getConnection("oracle");
 	String sql = "select id,pwd from koreamember where id=?";
 	pstmt = conn.prepareStatement(sql);
 	pstmt.setString(1,id);
 	rs = pstmt.executeQuery();
 	
 	while(rs.next()){
 		
 		//ID존재
 		if(pwd.equals(rs.getString("pwd"))){
 			//ID(0) , PWD(0)
 			//정상회원
 			
 			//Top.jsp 활용
 			session.setAttribute("userid", rs.getString("id"));
 			
 			out.print("<script>");
 				out.print("location.href='Ex02_JDBC_Main.jsp'");
 			out.print("</script>");
 		}else{
 			//ID(0) , PWD(x)
 				out.print("<script>");
					out.print("location.href='Ex02_JDBC_Login.jsp'");
				out.print("</script>");
 		}
 	}
 		//ID(x)
 		out.print("<script>");
			out.print("location.href='Ex02_JDBC_JoinForm.jsp'");
		out.print("</script>");
 	
 }catch(Exception e){
 	e.printStackTrace();
 }finally{
 	System.out.println("Finally");
 	SingletonHelper.close(rs);
	SingletonHelper.close(pstmt);
		//연결은 해제 하지 않아요 ....
 }

%>