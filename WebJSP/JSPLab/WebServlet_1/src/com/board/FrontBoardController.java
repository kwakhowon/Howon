package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
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
    	}else if(cmd.equals("login")) {
    		viewpage = "/WEB-INF/login/login.jsp";
    	}else {
    		viewpage = "/error/error.jsp";
    	}
    	
    	//3. 결과 만들고 저장
    	//가정 : List<Emp> list new ArrayList<>();
    	//가정 : list.add(new Emp(2000,"김유신"));
    	// ** request.setAttribute("emplist", list)
    	
    	//4. view 지정 > forward(request 객체 공유)
    	
    	RequestDispatcher dis =  request.getRequestDispatcher(viewpage);
    	
    	//5. view page forward 방식을 통해서 출력할 데이터를 전달(request)
    	dis.forward(request, response);
    	//servlet 가지고 있는 request 객체의 주소 >> view 전달 >> view 출력 .....
    	
    	//문제 : WebContent 폴더 안에 있는 파일은 ....
    	//클라이언트의 직접적인 접근 가능
    	//localhost:8090/WebServlet_1/board/boardlist.jsp
    	//WebContent > WEB-INF 폴더(보안 폴더) > Client (404)
    	
    	//1. WEB-INF 접근 : 404 Error
    	//2. WEB-INF 활용 : views >> board  > *.jsp
    	//						>> member > *.jsp
    	//						>> admin  > *.jsp
    	//내부에서는 서로 접근이 가능
    	//forward 접근 방식을 통해서 보안 폴더의 파일을 서비스 할 수 있다. 
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Get");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Post");
	}

}
