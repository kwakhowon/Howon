<%@page import="kr.or.bit.utils.SingletonHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
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
	<table style="width: 900px; height: 500px ;margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!-- 조회된 내용 UI 구성 
					  조회된 데이터 총 몇건
					  데이터 집합 .....
				-->
				<%
					String name = request.getParameter("search");
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					//where name = ?
					//where name like ? >> pstmt.setString(1, '%'+name+'%');
					//where name like '%" +name +"%'"
					
					conn = SingletonHelper.getConnection("oracle");
					String sql = "select count(*) from koreamember where name like ?";
					String sql2 = "select id , name, email from koreamember where name like  '%" +name +"%'";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, '%' +name + '%');
					rs = pstmt.executeQuery();
					rs.next();
					int count = rs.getInt(1);
					
				%>
					<table class="container" style="width: 400px; height: 100px; margin-left: auto; margin-right: auto">
						<tr><th colspan="3"></th></tr>
						<%
							if(count >0){
								pstmt = conn.prepareStatement(sql2);
								rs = pstmt.executeQuery();
								while(rs.next()){
									String id = rs.getString(1);
									String mname = rs.getString(2);
									String email = rs.getString(3);
							%>
								<tr>
									<td><%= id %></td>
									<td><%= mname %></td>
									<td><%= email %></td>
								</tr>		
							<%
								} //end while
									out.print("<tr><td colspan='3'>");
									out.print("<b>["+name+"]조회 결과" +count+"명입니다.</b>");
									out.print("</td></tr>");
							}else{
								
							}
						%>
					</table>
					<a href ="MemberList.jsp">회원 리스트</a>
					<%
						SingletonHelper.close(pstmt);
						SingletonHelper.close(rs);
						
					%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>