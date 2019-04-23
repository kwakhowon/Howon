<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Insert title here</title>
 <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
 <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/le-frog/jquery-ui.css">
 <script src="http://code.highcharts.com/highcharts.js"></script>
 <script src="http://code.highcharts.com/modules/exporting.js"></script>
 <script type="text/javascript">
 
  $(function() {
   var isShow = true;
   var xCategories = [];
   var manData = [];
   var womanData = [];
   var etcData = [];
   var totalData = [];
   
   $("#container").hide();
   
   $("#button").click(function() {
    // "bounce", "clip", "drop", "explode", "fold", "highlight", 
    // "puff", , "pulsate", "scale", "shake", "size", "slide"
    if (isShow) {
     setHighChart();
     $("#container").show("blind");
     isShow = false;
    } else {
     $("#container").hide("blind");
     isShow = true;
    }
   });
   
   //$( "#effect" ).show( selectedEffect, options, 500, callback );
   /* function callback() {
    setTimeout(function() {
            $("#effect:visible").removeAttr("style").fadeOut();
            }, 1000);
   }; */
 
   function setHighChart() {
    $("#container").empty();
    $.getJSON("test.json", function(data) {
     var items = data.DATA;
     $.each(items, function(index, obj) {
      xCategories[index] = obj.SUBJECT_NM;
      manData[index] = parseInt(obj.ML_BRWCNT);
      womanData[index] = parseInt(obj.FM_BRWCNT);
      etcData[index] = parseInt(obj.ETC_BRWCNT);
      totalData[index] = parseInt(obj.TOT_BRWCNT);
     });
 
     $('#container').highcharts({
      title : {
       text : '서울 도서관 도서 분야 성별 대출 통계',
       x : -20
      },
      subtitle : {
       text : 'Source: http://data.seoul.go.kr/',
       x : -20
      },
      xAxis : {
       categories : xCategories //[]
      },
      yAxis : {
       title : {
        text : '대출건수'
       },
       plotLines : [ {
        value : 0,
        width : 1,
        color : '#808080'
       } ]
      },
      tooltip : {
       valueSuffix : '건'
      },
      legend : {
       layout : 'vertical',
       align : 'right',
       verticalAlign : 'middle',
       borderWidth : 0
      },
      series : [ {
       name : '남성 도서대출건수',
       data : manData
      }, {
       name : '여성 도서대출건수',
       data : womanData
      }, {
       name : '기타 도서대출건수',
       data : etcData
      }, {
       name : '합계',
       data : totalData
      } ]
     });
    });
   }
  });
 </script>
 <style>
  .toggler {
   width: 1200px;
   height: 400px;
  }
  
  #button {
   padding: .5em 1em;
   text-decoration: none;
  }
  
  #container {
   width: 1200px;
   height: 400px;
   margin: 0 auto;
  }
 </style>
</head>
<body>
 <button id="button" class="ui-state-default ui-corner-all">Show Effect HighChart</button>
 
 <div class="toggler">
  <div id="container"></div>
 </div>
</body>
</html>