<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>
			<!-- title 영역 -->
			<tiles:getAsString name="title" />
		</title>
			<!-- <link href="join.css" type="text/css" rel="stylesheet" /> -->
			<!--  css 영역-->
			<link href='<tiles:getAsString name="css" />' type="text/css" rel="stylesheet" />	

<script src="http://code.jquery.com/jquery-2.2.4.js"></script>
	<script type="text/javascript">
	 $(function(){
			$('#btnCheckUid').click(function(){
				if($('#userid').val() === ""){
					alert("id입력하세요");
					$('#userid').focus();
				}else{
					$.ajax(
							{
								type:"post",
								url:"idcheck.htm",
								data:{"userid" : $('#userid').val()},
								success:function(data){ //{"result":""}
									if(data.result=="fail"){
										alert('중복된 아이디 입니다.');
										$('#userid').focus();
										$('#userid').val("");
									}else{
										alert('사용가능한 아이디 입니다.');
										$('#pwd').focus();
										
									}
								}
							}	
						);
				}
				
			});
		});
</script>
	
	</head>
	<body>
		<!-- Header 영역 -->
		<tiles:insertAttribute name="header" />
		<!-- Visual 영역 -->
		<tiles:insertAttribute name="visual" />
		<div id="main">
			<div class="top-wrapper clear">
				<!-- Content 영역  -->
				<tiles:insertAttribute name="content" />
				<!-- Aside (Navi) 영역 -->
				<tiles:insertAttribute name="aside" />
			</div>		
		</div>
		<!-- Footer 영역 -->
		<tiles:insertAttribute name="footer" />		
	</body>
</html>
