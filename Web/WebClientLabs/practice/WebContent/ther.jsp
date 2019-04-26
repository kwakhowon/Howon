<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
var key = "c467a51ad8b7075e645266c97d051df0";
var weatheruri = "http://api.openweathermap.org/data/2.5/forecast";
var date = new Date();
var today = date.getDate();
var maxtemp=null;
var mintemp=null;
console.log(typeof(today));
var maxtemparr = [];
var mintemparr = [];
var dayarr=[];
var weatherInfo="";
$('#btn').click(function(){
	
	var str ='<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>'
   $('#box').append(str);
	
	$.ajax({
		url : weatheruri,
		type : "get",
		dataType : "json",
		data : {
			appid : key,
			id : "1835848",
			units : "metric",
			cnt : "40"
		},
		success : function(data) {
			
			var list = data.list;
			console.log(list);
			 
			
			$.each(list, function(index, element) {
			   var h = element.dt_txt;
			   var temperature = h.split(" ");
			   var day = Number(temperature[0].substr(8,10));
                console.log(element.weather.main);
			    if(today==day){
			    	 weatherInfo = element.weather[0].main;
			       if(maxtemp==null&&mintemp==null){
			    	   if(weatherInfo==="Rain"){
				    	   var str ='<img src="images/umbrella.png">';
				    	   $('#pic').append(str);
				    	   
				       }else if(weatherInfo==="Clouds"){
				    	   var str ='<img src="images/cloud.png">';
				    	   $('#pic').append(str);
				    	   
				       }else if(weatherInfo==="Clear"){
				    	   var str ='<img src="images/sunny.png">';
				    	   $('#pic').append(str);
				       }
			    	    	   
			    	   dayarr.push(day);
			    	maxtemp = element.main.temp_max;
				    mintemp = element.main.temp_min;
			       }
			    	if(maxtemp< element.main.temp_max){
			    		maxtemp = element.main.temp_max;
			    	}
			    	if(mintemp>element.main.temp_min){
			    		mintemp = element.main.temp_min;
			    	}
			    }
			});
			maxtemparr.push(maxtemp);
			mintemparr.push(mintemp);
			var info = `<h3>${weatherInfo}</h3>`;
			//$("#pic").append(info);
			maxtemp=null;
			mintemp=null;
		
			    
			$.each(list, function(index, element) {
				   var h = element.dt_txt;
				   var temperature = h.split(" ");
				   var day = Number(temperature[0].substr(8,10));

				    if(today+1==day){
				    	
				    	if(maxtemp==null&&mintemp==null){
				    		dayarr.push(day);
					    	maxtemp = element.main.temp;
						    mintemp = element.main.temp;
					       }
				    	if(maxtemp< element.main.temp){
				    		maxtemp = element.main.temp;
				    	}
				    	if(mintemp>element.main.temp){
				    		mintemp = element.main.temp;
				    	}
				    }
				});
				maxtemparr.push(maxtemp);
				mintemparr.push(mintemp);
				
				
				maxtemp=null;
				mintemp=null;
			
				
				$.each(list, function(index, element) {
					   var h = element.dt_txt;
					   var temperature = h.split(" ");
					   var day = Number(temperature[0].substr(8,10));

					    if(today+2==day){
					    	if(maxtemp==null&&mintemp==null){
					    		dayarr.push(day);
						    	maxtemp = element.main.temp;
							    mintemp = element.main.temp;
						       }
					    	if(maxtemp< element.main.temp){
					    		maxtemp = element.main.temp;
					    	}
					    	if(mintemp>element.main.temp){
					    		mintemp = element.main.temp;
					    	}
					    }
					});
					maxtemparr.push(maxtemp);
					mintemparr.push(mintemp);
					
					
					maxtemp=null;
					mintemp=null;
				
				
					$.each(list, function(index, element) {
						   var h = element.dt_txt;
						   var temperature = h.split(" ");
						   var day = Number(temperature[0].substr(8,10));

						    if(today+3==day){
						    	
						    	if(maxtemp==null&&mintemp==null){
						    		dayarr.push(day);
							    	maxtemp = element.main.temp;
								    mintemp = element.main.temp;
							       }
						    	if(maxtemp< element.main.temp){
						    		maxtemp = element.main.temp;
						    	}
						    	if(mintemp>element.main.temp){
						    		mintemp = element.main.temp;
						    	}
						    }
						});
						maxtemparr.push(maxtemp);
						mintemparr.push(mintemp);
						
						maxtemp=null;
						mintemp=null;
					
				
						$.each(list, function(index, element) {
							   var h = element.dt_txt;
							   var temperature = h.split(" ");
							   var day = Number(temperature[0].substr(8,10));

							    if(today+4==day){
							
							    	if(maxtemp==null&&mintemp==null){
							    		dayarr.push(day);
								    	maxtemp = element.main.temp;
									    mintemp = element.main.temp;
								       }
							    	if(maxtemp< element.main.temp){
							    		maxtemp = element.main.temp;
							    	}
							    	if(mintemp>element.main.temp){
							    		mintemp = element.main.temp;
							    	}
							    }
							});
							maxtemparr.push(maxtemp);
							mintemparr.push(mintemp);
				
							
			
			
			
			var chart = {
					chart : {
						type : 'spline'
					},
					title : {
						text : 'Daily Temperature'
					},
					subtitle : {
						text : 'Team Bit 3'
					},
					xAxis : {
						categories : dayarr
					},
					 yAxis: {
						    title: {
						      text: 'Temperature'
						    },
						    labels: {
						      formatter: function () {
						        return this.value + '°';
						      }
						    }
						  },
					tooltip: {
					    crosshairs: true,
					    shared: true
					  },
					plotOptions: {
					    spline: {
					      marker: {
					        radius: 4,
					        lineColor: '#666666',
					        lineWidth: 1
					      }
					    }
					  },
					series : [ {
						name : 'High temp',
						data : maxtemparr
					}, {
						name : 'Low temp',
						data : mintemparr
					} ]
				}
			
			Highcharts.chart('container', chart);
			
		}

		
	}

	);
	
});
});

</script>
<style type="text/css">
h1{
   text-align: center;
   font-family: sans-serif;
   
}
img{
     width:150px;
     height:150px;
    
}

#pic{
 display:flex;
 justify-content:space-around;
 margin-bottom:50px;
 font-family: sans-serif;
}

</style>

</head>
<body>
   <h1>What's the weather today?</h1>
 <div id="pic"></div>
<div id="box"></div>

<button id="btn">날씨 조회</button>
</body>

</html>
