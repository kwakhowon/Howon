<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String type = request.getParameter("type");
	String userid = request.getParameter("userid");
	String type2 = request.getParameter("type2");
	out.print(type + " / " +userid);
	// http://localhost:8090/WebJSP/Ex14_include_param_main.jsp?type=aa&userid=howon
			
	//include되는 페이지에서는 request 객체를 공유할 수 있다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include(request 객체를 공유) POINT</title>
</head>
<body>
	MAIN PAGE<br>
	<hr>
		<jsp:include page="Ex14_subparam.jsp">
			<jsp:param value="<%=type2 %>" name="aaaa"/>
			<jsp:param value="1004" name="pwd"/>
		</jsp:include>
	<hr>
	MAIN END
</body>
</html>