<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "http://api.openweathermap.org/data/2.5/forecast",
			dataType : "json",
			data : {
				appid : "ddadc77332c563fcc15dc32c55d007d1",
				id : 1835848,
			},
			success : function(data) {
				$.each(data.list, function(index, element){
					console.log(element);
					console.log(element.main.temp);
					$('.w1').append(element.main.temp+"<br>");
				});

			}

		});
	});
</script>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
}

.w {
	display: flex;
	border: 1px solid black;
	height: 100%;
}

.w1, .w2, .w3, .w4, .w5 {
	display: flex;
	flex-grow: 1;
	text-align: center;
}

.w1, .w2, .w3, .w4 {
	border-right: 1px solid black;
}
</style>
</head>
<body>
	<div class="w">
		<div class="w1"></div>
		<div class="w2"></div>
		<div class="w3"></div>
		<div class="w4"></div>
		<div class="w5"></div>
	</div>
	<button id="btn">눌러봐</button>
</body>
</html>