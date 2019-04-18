<%@page import="kr.or.kosta.utils.SingletonHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
/*
	Ex03_MemberEdit.jsp?id=hong
	sql > select * from koreamember where id = ?
	결과를 화면 출력 : 
		출력 (수정(x)) : <td>rs.getString("name")</td>
		출력 (수정(o)) : <td><input type ="text" value="rs.getString("name")"></td>
		출력 (다른페이지 전송 , 수정(x)) : <td><input type ="text" name="" value='rs.getString("name")' readonly></td>

Ex03_MemberEditok.jsp?
sql > update emp set ename=? , job=? , sal=? where empno=?
*/
%>

<%
	String id = request.getParameter("id");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		conn = SingletonHelper.getConnection("oracle");
 	String sql = "select id , pwd , name , age ,trim(gender) , email from koreamember where id = ?";
 	pstmt = conn.prepareStatement(sql);
 	
 	pstmt.setString(1, id);
 	
 	rs = pstmt.executeQuery();
 	
 	rs.next();
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
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<form action="Ex03_MemberEditok.jsp" method="post">

					<h3 style="text-align: center;">회원가입</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<td>아이디</td>
								<td>
									<input type="text" name="id" value="<%=rs.getString("id") %>" readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
								<td><%= rs.getString("pwd") %></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" value="<%=rs.getString("name") %>" style="background-color: gold"></td>
							</tr>
							<tr>
								<td>나이</td>
								<td><input type="text" name="age" value="<%= rs.getString("age") %>" style="background-color: gold"></td>
							</tr>
							<tr>
								<td>성별</td>
								<td>
								[<%= rs.getString(5)%>]
								<input type="radio" name="gender" id="gender" value="여"
								<% if(rs.getString(5).equals("여")){ %> checked<%} %>>여자
								<input type="radio" name="gender" id="gender" value="남"
								<% if(rs.getString(5).equals("남")){ %> checked<%} %>>남자
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" value="<%= rs.getString("email") %>" style="background-color: gold"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="수정하기">
									<a href='Ex03_Memberlist.jsp'>리스트이동</a></td>
						</table>

					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		SingletonHelper.close(rs);
		SingletonHelper.close(pstmt);
	}

%>


