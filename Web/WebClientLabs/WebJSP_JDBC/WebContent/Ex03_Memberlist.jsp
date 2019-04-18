<%@page import="java.sql.Connection"%>
<%@page import="kr.or.kosta.utils.SingletonHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
	이 페이지는 admin 만 접근 가능....
	
	1. 회원목록 출력
	2. 관리자만 접근 가능 (userid == admin);
	3. 로그인한 일반 사용자 주소값을 외워서 접근 불가 ....... >> 로그인 페이지
	4. 고려사항 (권한 처리 코드가 여러페이지에 사용된다면 유지보수 )
	별도의 PAGE 구성 (include .... : sessionCheck.jsp)
	
*/
	if(session.getAttribute("userid")==null || !session.getAttribute("userid").equals("admin")){
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!--  
					회원 목록 출력하기
					관리자인 경우 (회원 데이터 볼 수 있다.)
					목록 출력 >> 상세정보 별도 구성
					목록 : select id , ip from koreamember;
					
					회원데이터 (html 결합) 출력 생성
				-->
			<%
			Connection conn = null;
		 	PreparedStatement pstmt = null;
		 	ResultSet rs = null;
		 	
		 	try{
		 	conn = SingletonHelper.getConnection("oracle");
		 	String sql = "select id,ip from koreamember";
		 	pstmt = conn.prepareStatement(sql);
		 	rs = pstmt.executeQuery();
		%>
			<table style="width:400px; height : 100px; margin-left:auto; margin-right: auto;">
				<tr><th colspan="4">회원리스트</th></tr>
				<% while(rs.next()){ %>
		 			<tr>
		 				<td width="100px">
		 				<a href='Ex03_MemberDetail.jsp?id=<%=rs.getString("id")%>'>
		 				<%=rs.getString("id") %></a>
		 				</td>
		 				<td width="100px"><%= rs.getString("ip") %></td>
		 				<td>
		 				<!-- 삭제 -->
		 				<a href='Ex03_MemberDelete.jsp?id=<%=rs.getString("id")%>'>[삭제]</a></td>
		 				<td width="100px"><a href='Ex03_MemberEdit.jsp?id=<%=rs.getString("id")%>'>[수정]</a></td>
		 				
		 			</tr>
		 <%	} %>
		 </table>
		 <hr>
		 	<form action="Ex03_MemberSearch.jsp" method="post">
		 		회원명 : <input type="text" name = "search">
		 			   <input type="submit" value="이름 검색">
		 	</form>
		 	<hr>
		 <% 
		 	}catch(Exception e){
		 		e.printStackTrace();
		 	}finally{
		 		SingletonHelper.close(rs);
		 		SingletonHelper.close(pstmt);
		 	}
			%>
			
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>