<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>


<script type="text/javascript">

	$(function() {
		var moviename = [];
		var audiAcc = [];
		
		
		$('#btn').click(function() {
							$.ajax({
										url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList",
										dataType : "json",
										type : "GET",
										data : {
											key :"59a9c6d4ba2c806658a23e8d35032fda",
											targetDt : $('#sname').val()
										},
										success : function(data) {
											var list = data.boxOfficeResult.dailyBoxOfficeList;
											$.each(list , function(index, element){
												var movieNm = element.movieNm;
												var movieaudience = element.audiAcc;
												audiAcc.push(movieaudience);
												moviename.push(movieNm);
											console.log(audiAcc);
											
											});
											var chart = Highcharts.chart('container', {

												  title: {
												    text: '일별 박스오피스 순위'
												  },

												  subtitle: {
												    text: '누적관객수'
												  },

												  xAxis: {
												    categories: moviename
												  },

												  series: [{
													    type: 'column',
													    colorByPoint: true,
													    data: audiAcc,
													    showInLegend: false
													  }]

												});


										}
									});
						});
	});
</script>

</head>
<body>
	<input type="text" name="sname" id="sname">
	<input type="button" value="검색" id="btn">
	<div id="container"></div>
</body>
</html>