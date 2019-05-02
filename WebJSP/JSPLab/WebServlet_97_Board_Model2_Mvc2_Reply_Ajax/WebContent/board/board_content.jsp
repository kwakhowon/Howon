<%@page import="kr.or.kosta.dao.boarddao"%>
<%@page import="kr.or.kosta.dto.reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.dto.board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>board_content</title>
	 <link rel="Stylesheet" href="<%=request.getContextPath()%>/style/default.css" />
</head>
<body>
	<%
		//out.print(request.getParameter("idx") + "<br>");
		//out.print(request.getParameter("cp") + "<br>");
		//out.print(request.getParameter("ps") + "<br>");
		/* String idx =	request.getParameter("idx"); //글번호
	
		//글번호를 가지고 오지 않았을 경우 예외처리
		if(idx==null || idx.trim().equals("")){
			response.sendRedirect("board_list.jsp");
			return;
		}
		idx = idx.trim();
	
		//list 다시 넘어갈때 현재 페이지 * 페이지 사이즈////////////
	    String cpage =	request.getParameter("cp"); //현재 페이지 번호
	    String pagesize =	request.getParameter("ps"); //pagesize 정보
	
	    if(cpage==null || cpage.trim().equals("")){
			cpage="1";
		}
		if(pagesize==null || pagesize.trim().equals("")){
			pagesize="5";
		}
		/////////////////////////////////////////////////////
	boardservice boardcontent = boardservice.getInstance();
	
	//조회수 증가
	boolean res = boardcontent.addReadNum(idx);
	if(res) System.out.println("조회수 증가");
		
	//데이터 조회 출력(글번호가 없는 게시글에 조회시 ...)
	board boarddto = boardcontent.content(Integer.parseInt(idx));//content(Integer.parseInt(idx));
	if(boarddto == null){
		response.sendRedirect("board_list.jsp");
		return;
	} */
	board boarddto = (board)request.getAttribute("boarddto");
	String idx = (String)request.getAttribute("idx");
	String cpage = (String)request.getAttribute("cpage");
	String pagesize = (String)request.getAttribute("pagesize");
	boarddao dao = (boarddao)request.getAttribute("dao");
	
	%>
	<%
		pageContext.include("/include/header.jsp");
	%>
	<div id="pageContainer">
		<div style="padding-top: 30px; text-align: center">
			<center>
				<b>게시판 글내용</b>
				<table width="80%" border="1">
					<tr>
						<td width="20%" align="center"><b> 글번호 </b></td>
						<td width="30%"><%= idx %></td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td><%= boarddto.getWritedate() %></td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%"><%=boarddto.getWriter() %></td>
						<td width="20%" align="center"><b>조회수</b></td>
						<td><%= boarddto.getReadnum() %></td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>홈페이지</b></td>
						<td><%= boarddto.getHomepage() %></td>
						<td width="20%" align="center"><b>첨부파일</b></td>
						<td>(<%= boarddto.getFilesize() %>)bytes</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="3"><%= boarddto.getSubject() %></td>
					</tr>
					<tr height="100">
						<td width="20%" align="center"><b>글내용</b></td>
						<td colspan="3">
							<%
								String content = boarddto.getContent();
								if(content != null){
									content = content.replace("\n", "<br>"); //enter > br
								}
								out.println(content);
							%>
						
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<a href="boardlist.bbs?cp=<%= cpage %>&ps=<%= pagesize %>">목록가기</a>
				            |<a href="boardEditForm.bbs?idx=<%= idx %>&cp=<%= cpage %>&ps=<%= pagesize %>">편집</a>
				            |<a href="boardDeletePassword.bbs?idx=<%= idx %>&cp=<%= cpage %>&ps=<%= pagesize %>">삭제</a>
				            |<a href="boardRewrite.bbs?idx=<%= idx %>&cp=<%= cpage %>&ps=<%= pagesize %>&subject=<%= boarddto.getSubject() %>">답글</a>									
						</td>
					</tr>
				</table>
			<!--  꼬리글 달기 테이블 -->
		<form name="reply" id="reply" method="POST"> 
				<!-- hidden 태그  값을 숨겨서 처리  -->
				<input type="hidden" name="idx" value="<%= idx %>">
				<input type="hidden" name="userid" value="">
					<!-- hidden data -->
					<table width="80%" border="1">
						<tr>
							<th colspan="2">덧글 쓰기</th>
						</tr>
						<tr>
							<td align="left">
								작성자 : <input type="text" name="reply_writer" id="reply_writer"><br />
								내&nbsp;&nbsp;용 : <textarea name="reply_content" id="reply_content" rows="2" cols="50"></textarea>
							</td>
							<td align="left"> 
								비밀번호:<input type="password" name="reply_pwd" id= "reply_pwd" size="4">
								  	  <input type="button"  id="send" value="등록" >
							</td>
						</tr>
					</table>
			</form>
	<!-- 유효성 체크	 -->	
	<script type="text/javascript">
		
		$(function(){
			getReplyList();
			addreply();
		})
		
		
		var data = {
					idx: <%=idx%>,
					ps: <%=pagesize%>,
					cp: <%=cpage%>
				   }	
		
		function getReplyList(){
			
			$.ajax({
				url:"boardreplylist.bbs",
				datatype:"JSON",
				data: data,
				type:"POST",
				success: function(data){
					jsonarray = JSON.parse(data);
					//console.log(jsonarray);
					$("#replytable").find("tr").not(":first").remove();
					if(data !=null){ // Json 객체가 존재 한다면
						//console.log("if문 들어옴");
						$.each(jsonarray,function(){ // 각각의 Json 마다 tr생성해 붙히기
							//console.log("each?")
							//console.log("제이슨 : " +this);
							$("#replytable").find("tr:last").after(
								'<tr align="left"><td width="80%">'
								+ this.writer + ':' +this.content  
								+ '<br>작성일 : ' + this.writedate 
								+ '</td><td width="20%"><form action="boardreplyDeleteOk.bbs" method="POST" name="replyDel"><input type="hidden" name="no" value='
								+ this.no 
								+'><input type="hidden" name="idx" value= '
								+ <%= idx %> 
								+'>password :<input type="password" name="delPwd" size="4"><input type="submit" value="삭제" onclick="reply_del(this.form)">'
								+'</form></td></tr>'
							)
						})
					}
				}
			
			})
			
		}
		
		function addreply(){
			$('#send').on("click",function(){
			
				var frm = document.reply;
				if (frm.reply_writer.value == "" || frm.reply_content.value == ""
						|| frm.reply_pwd.value == "") {
					alert("리플.. 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
					return false;
				}
				
				var param = {
						       "idx":<%=idx%>,
							   "reply_writer":$('#reply_writer').val(),
							   "reply_pwd":$('#reply_pwd').val(),
							   "reply_content":$('#reply_content').val()
						    };
				//alert("**param : " + $('#reply_writer').val());
				$.ajax({
					url:"boardReplyok.bbs",
					datatype:"text",
					data:param,
					success: function(data){
						console.log("data : " +data);
						if(data.trim()=="success"){
							alert("댓글등록성공");
							getReplyList();
							$('#reply_writer').val("");
							$('#reply_pwd').val("");
							$('#reply_content').val("");
						}else{
							alert("댓글등록실패");
						}
						
					}
					
				})
				return false;
			})
		}
	
	
		function reply_del(frm) {
			console.log("del click");
			
			$(frm).on("submit",function(){
				console.log("submit");
				if (frm.delPwd.value == "") {
					alert("비밀번호를 입력하세요");
					frm.delPwd.focus();
					return false;
				}
				var data = $(this).serialize();
				
				$.ajax({
					url:"boardreplyDeleteOk.bbs",
					datatype:"text",
					data:data,
					success:function(data){
							
						if(data.trim()=="success"){
							alert("댓글삭제!");
							getReplyList();
						}else{
							alert("댓글삭제실패!");
						}
					}
				
				})
			
				return false;
			})
		}
		
		
	
	
		
		
	</script>
	<br>
	<!-- 꼬리글 목록 테이블 -->

		<table id ="replytable" width="80%" border="1">
					<tr><th colspan="2">REPLY LIST</th></tr>
	<%-- <%	   
		for(reply replydto : replylist){
	%>
					<tr align="left">
						<td width="80%">
							[<%= replydto.getWriter() %>] : 
							<%= replydto.getContent() %><br>
							작성일 : <%= replydto.getWritedate().toString() %>
						</td>
						<td width="20%">
							<form action="boardreplyDeleteOk.bbs" method="POST" name="replyDel">
								<input type="hidden" name="no" value="<%= replydto.getNo() %>">
								<input type="hidden" name="idx" value="<%= idx %>">
								password :<input type="password" name="delPwd" size="4">
					 			<input type="button" value="삭제" onclick="reply_del(this.form)">
							</form>
						</td>
					</tr>
		<%
			  }
		%> --%>
		</table>
		<%-- <%
		 }	
		%> --%>
		
		</center>
		</div>
	</div>
</body>
</html>