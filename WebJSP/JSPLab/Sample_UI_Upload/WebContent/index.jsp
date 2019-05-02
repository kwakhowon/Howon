<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajax SITE</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
	
</head>
<body>
	<%
		String userID= null;
	    if(session.getAttribute("userID") != null){
	    	userID = (String)session.getAttribute("userID");
	    }
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
				<span class="icon-bar"></span>	
				<span class="icon-bar"></span>	
				<span class="icon-bar"></span>
			
			</button>
				<a class="navbar-brand" href="index.jsp">실시간 회원</a>	 
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">메인</a></li>
			</ul>
			<%
				if(userID == null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					 data-toggle="dropdown"
					 role="button"
					 aria-haspopup="true"
					 aria-expanded="false">접속하기<span class="caret"></span>
					<ul class="dropdown-menu"> 
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="joinjsp">회원가입</a></li>
					
					</ul>
					</a>
				
			</ul>
			<%
				} else {			
			%>
			<%		
				}
			%>
		</div>
	</nav>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>