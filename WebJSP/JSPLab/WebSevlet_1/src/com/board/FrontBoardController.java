package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FrontBoardController")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //Get 방식과 Post 방식 두가지 함수에 동작하는 함수
    //1. HttpServlet 제공하는 service() 함수
    //2. 별도의 사용자 정의 함수 생성해서 : doProcess()
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) {
    	//doGet 방식 , doPost 방식이던 실행되는 함수
    	System.out.println("클라이언트 요청 : " +method);
    	
    	//1. 요청받기 (Get, Post)
    	
    	//2. 요청 판단 (판단의 기준 ^^) : command 방식 
    	//클라이언트 요청 (게시판을 보여달라는 건가 , 글쓰기 , 로그인 )
    	//2.1 Parameter 기준으로 판단
    	//2.2 /board?cmd=login&userid=howon&pwd=1004
    	//String command = request.getParameter("cmd")
    	//if(command.equals("login"){로그인 처리}
    	
    	//cmd >> null >> error.jsp 서비스
    	//cmd >> boardlist >> list.jsp 서비스
    	//cmd >> boardwrite >> write.jsp 서비스
    	
    	//URL 방식 *************************************************
    	//전체 주소값을 가지고 판단
    	//board/boardlist >> /boardlist
    	//board/boardwrite?title=aaa&contents=bbbb >> /boardwrite
    	//if(command.equals("/boardlist"){게시판 목록보기}
    	//if(command.equals("/boardwrite"){게시판 글쓰기}
    	
    	//구현
    	//1. 요청받기 (command 방식)
    	//요청주소
    	//localhost:8090/WebServlet_1/board?cmd=list ......
    	
    	String cmd = request.getParameter("cmd");
    	
    	//2. 요청 판단 (업무에 따라서 서비스 구현)
    	String viewpage = null;
    	//cmd >> null >> error.jsp 서비스
    	//cmd >> boardlist >> boardlist.jsp 서비스
    	//cmd >> boardwrite >> boardwrite.jsp 서비스
    	
    	if(cmd == null) {
    		viewpage = "/error/error.jsp";
    	}else if(cmd.equals("boardlist")) {
    		viewpage = "/board/boardlist.jsp";
    		//DB연결
    		//select ....
    		//실행 > 결과 (rs) > 객체 담기
    		//boarddao dao = new boarddao();
    		//List<board> boardlist = dao.selectboardlist();
    		//request.setAttribute("list", boardlist);
    		//viewpage forward 방식
    		//<c:set var="list" value="<%=request.getAttribute("list")%>
    		
    	}else if(cmd.equals("boardwrite")) {
    		viewpage = "/board/boardwrite.jsp";
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Post");
	}

}
