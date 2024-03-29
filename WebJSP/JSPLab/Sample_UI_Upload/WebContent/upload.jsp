<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sample</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="resources/js/jquery.fileupload.js"></script>
<script >
    $(document).ready(function() {
        $('#upFile').fileupload({
            url : '/bo/sample/file/uploadProcess.do',
            dataType: 'json',
            //replaceFileInput: false,
            add: function(e, data){
                var uploadFile = data.files[0];
                var isValid = true;
                if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
                    alert('png, jpg, gif 만 가능합니다');
                    isValid = false;
                } else if (uploadFile.size > 5000000) { // 5mb
                    alert('파일 용량은 5메가를 초과할 수 없습니다.');
                    isValid = false;
                }
                if (isValid) {
                    data.submit();
                }
            }, progressall: function(e,data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('#progress .bar').css(
                    'width',
                    progress + '%'
                );
            }, done: function (e, data) {
                var code = data.result.code;
                var msg = data.result.msg;
                if(code == '1') {
                    alert(msg);
                } else {
                    alert(code + ' : ' + msg);
                }
            }, fail: function(e, data){
                // data.errorThrown
                // data.textStatus;
                // data.jqXHR;
                alert('서버와 통신 중 문제가 발생했습니다');
                foo = data;
            }
        });
    });
</script>
</head>
<body>
<input type="file" name="fileData" id="upFile">
    <div id="progress">
        <div class="bar" style="width: 0%;"></div>
    </div>
</body>
</html>