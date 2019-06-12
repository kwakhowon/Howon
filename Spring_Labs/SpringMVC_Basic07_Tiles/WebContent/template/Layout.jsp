<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		<tiles:getAsString name="title"/>
	</title>
</head>
<body>
	<table style="width: 100%; padding: 0;" border="1">
		<tr>
			<td colspan="2">
				<tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr>
			<td valign="top">
				<tiles:insertAttribute name="menu"/>
			</td>
			<td valign="top">
				<tiles:insertAttribute name="body"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<tiles:insertAttribute name="footer"/>
			</td>
		</tr>
	</table>
</body>
</html>