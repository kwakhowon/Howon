<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Media_YouTube</title>
<style type="text/css">
.col-1 {
	width: 8.33%;
}

.col-2 {
	width: 16.66%;
}

.col-3 {
	width: 25%;
}

.col-4 {
	width: 33.33%;
}

.col-5 {
	width: 41.66%;
}

.col-6 {
	width: 50%;
}

.col-7 {
	width: 58.33%;
}

.col-8 {
	width: 66.66%;
}

.col-9 {
	width: 75%;
}

.col-10 {
	width: 83.33%;
}

.col-11 {
	width: 91.66%;
}

.col-12 {
	width: 100%;
}

.container {
	margin: 0 auto;
	height: 550px;
	background-color: white;
}

.header {
	text-align: center;
	padding: 15px;
	background-color: #0097e6;
	color: black;
	margin: 0;
}

.article-a {
	float: left;
	width: 50%;
	height: 40%;
	background-color: white;
	padding: 10px;
	color: #201F20;
	text-align: center;
	margin-bottom: 20px;
	margin-top: 10px;
}

.article-b {
	float: left;
	width: 50%;
	height: 40%;
	background-color: white;
	padding: 10px;
	color: #201F20;
	text-align: center;
	margin-bottom: 20px;
	margin-top: 10px;
}

.footer {
	clear: both;
	padding: 10px;
	background-color: white;
	color: black;
}

.footer h3 {
	text-align: center;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<jsp:include page="/commonmodule/Top.jsp"></jsp:include>
<link rel="stylesheet" href="index.css">
</head>
<body>
	<div class="header col-12">
		<h1>
			HTML &nbsp; <img src="../images/youtube.png"
				style="width: 50px; height: 50px; margin-bottom: 10px"></img>&nbsp;<b>YouTube</b>
		</h1>
		<hr>
	</div>

	<div class="article-a">
		<p>iFrame 재생</p>
		<iframe width="440" height="245"
			src="https://www.youtube.com/embed/9sFUryyoJCw"> </iframe>
		<br> <br> <br>


		<p>
			Auto play 재생(<span style="color: red">현재 Chrome에서 막아놓음</span>)
		</p>
		<iframe width="440" height="245"
			src="https://www.youtube.com/embed/9sFUryyoJCw?autoplay=1"
			allow="autoplay; encrypted-media";"> </iframe>
		<br> <br> <br>
		<p>Object 재생</p>
		<object width="440" height="245"
			data="https://www.youtube.com/embed/9sFUryyoJCw"> </object>
	</div>


	<div class="article-b">
		<p>Loop</p>
		<iframe width="440" height="245"
			src="https://www.youtube.com/embed/9sFUryyoJCw?playlist=9sFUryyoJCw&loop=1">
		</iframe>
		<br> <br> <br>


		<p>Control bar 제거</p>
		<iframe width="440" height="245"
			src="https://www.youtube.com/embed/9sFUryyoJCw?controls=0">
		</iframe>
		<br> <br> <br>
		<p>Embed 재생</p>
		<embed width="440" height="245"
			src="https://www.youtube.com/embed/9sFUryyoJCw">
	</div>



</body>
</html>