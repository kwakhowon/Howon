<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

    
 <%
 request.setCharacterEncoding("UTF-8");
 %>
 
<!doctype html>
<html lang="ko">
  <head>
    <title>Master Jung</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link href="./assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> 
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  </head>
  
  <body>
  
  
<div class="wrapper ">
  <!-- left_side_menu  -->
	<tiles:insertAttribute name="left"/>  
  <div class="main-panel">
    <!-- Navbar -->
	<tiles:insertAttribute name="top"/>
	
    <div class="content">
      <div class="container-fluid">
         <!-- your content here -->
		<tiles:insertAttribute name="content"/>

      </div>
    </div>
    
    <!-- footer -->
 	<tiles:insertAttribute name="bottom"/>
    
    <!-- wrapper, main-panel end -->
  </div>
</div>


</body>
</html>