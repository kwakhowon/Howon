<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- <link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css"
	rel="stylesheet"> -->
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<script src="//cdn.ckeditor.com/4.11.4/full/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>
<style type="text/css">
.textarea {
	line-height: 20px;
	color: #292929;
	font-size: 14px;
	font-weight: normal;
	letter-spacing: 0;
	margin-left: 20px;
}

.self-introduce-text {
	white-space: pre-wrap;
	margin-left: 20px;
	font-size: 14px;
	line-height: 20px;
}
</style>
<script>
	 $(document).ready(function() {
		var HelloButton = function (context) {
	        var ui = $.summernote.ui;
	  
	        // create button
	        var button = ui.button({
	            contents: '코드',
	            tooltip: 'hello',
	            click: function () {
	    
	                $('#notes').summernote('editor.pasteHTML', '<code class="html"> </code>');
	    }
	  });
	   

	  return button.render();   // return button as jquery object 
	}
		
		var HelloButton2 = function (context) {
	        var ui = $.summernote.ui;
	  
	        // create button
	        var button2 = ui.button({
	            contents: '코드',
	            tooltip: 'hello',
	            click: function () {
	    
	                $('#notes2').summernote('editor.pasteHTML', '<code class="html"></code>');
	    }
	  });
	   

	  return button2.render();   // return button as jquery object 
	}

	/* $('#notes').summernote({
	    
	    minHeight: 200,
	    placeholder : "code를 입력해주세요",
	                toolbar: [
						['style', ['style']],
	                    ['mybutton', ['hello']],
						['font', ['bold', 'italic', 'underline', 'clear']],
						['para', ['ul', 'ol']],
						['height', ['height']],
						['insert', ['link', 'picture']],
						['view', ['fullscreen', 'codeview']],
						['help', ['help']]
					], 
	                
	                buttons: {
	                    hello: HelloButton
	                }
	});
		
		$('#notes2').summernote({
	    
	    minHeight: 200,
	                toolbar: [
						['style', ['style']],
	                    ['mybutton', ['hello']],
						['font', ['bold', 'italic', 'underline', 'clear']],
						['para', ['ul', 'ol']],
						['height', ['height']],
						['insert', ['link', 'picture']],
						['view', ['fullscreen', 'codeview']],
						['help', ['help']]
					], 
	                
	                buttons: {
	                    hello: HelloButton2
	                }
	});  */
		$('#save').click(function() {
			var textnote = $('textarea[name=contentIn]').val();

			$('.note-editable').text(textnote);
			
			console.log($('textarea[name=contentIn]').val());
			console.log($('textarea[name=content]').val());
		});
 	
		
		
	});
</script>
</head>
<body>
	<a href="login.htm">로그인 </a>
	<br>
	<a href="register.htm">회원가입</a>
	<br>
	<a href="emptable.htm">emp Table 보기</a>
	<div style="display: grid;">
		<div style="display: grid; grid-column-start: 1; grid-column-end: 2;">
			<textarea name="content" id="content" class="ckeditor" rows="10" cols="80"></textarea>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>

</html>
