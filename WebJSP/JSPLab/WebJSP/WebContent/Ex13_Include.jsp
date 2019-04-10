<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 컨텐츠(자기소개)</title>
<style type="text/css">
table, tr, td {
	border: 2px solid black;
	border-collapse: collapse;
}
table {
	width: 700px;
}
</style>
</head>
<body>
<!-- 원칙 : Layout : div .... -->
<table >
	<tr>
		<td colspan="2">
		<jsp:include page="/commonmodule/Top.jsp" />
		</td>
	</tr>
	<tr>
		<td style="width: 200px">
		<jsp:include page="/commonmodule/Left.jsp" />
		</td>
		<td style="width: 500px">
			여기 영역은 실제 자기소개 내용
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<jsp:include page="/commonmodule/Bottom.jsp" />
		</td>
	</tr>
</table>
</body>
</html>