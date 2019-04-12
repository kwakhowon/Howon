<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
								<td></td>
							</tr>
							<tr>
								<td>비번</td>
								<td></td>
							</tr>
							<tr>
								<td>이름</td>
								<td></td>
							</tr>
							<tr>
								<td>나이</td>
								<td></td>
							</tr>
							<tr>
								<td>성별</td>
								<td></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td></td>
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

