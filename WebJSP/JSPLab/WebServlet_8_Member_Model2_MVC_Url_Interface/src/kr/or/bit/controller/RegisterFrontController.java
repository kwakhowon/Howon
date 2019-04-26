package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MvcRegisterDao;
import kr.or.bit.dto.MvcRegister;
import kr.or.bit.service.LoginProcessAction;
import kr.or.bit.service.MemberWriteAction;

//@WebServlet("/Register.do") >> command
//실제로 들어오는 주소는 같아요
//Register.do?cmd=register 회원가입
//Register.do?cmd=registerlist 회원목록보기

//Url 방식 > 주소가 고정되면 안되요
//"*.do" > a.do , b.do , aaaa.do

@WebServlet("*.do")
public class RegisterFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterFrontController() {

    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1. 요청받기
    	//String command = request.getParameter("cmd");
    	//Url 방식은 cmd parameter 없어요
    	
    	//주소값
    	//register.do , registerok.do , registerlist.do
    	
    	//추가 코드...............................
    	ActionForward forward = null; //redirect 와 path 정보가지는 클래스
    	Action action = null;
    	////////////////////////////////
    	
    	//주소 요청의 판단 근거 (함수)
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
    	
    	//requestURI : /WebServlet_7_Member_Model2_Mvc_Url/Register.do
    	//contextPath : /WebServlet_7_Member_Model2_Mvc_Url
    	//url_Command : /Register.do
    	
    	System.out.println("requestURI : "+requestURI);
    	System.out.println("contextPath : "+contextPath);
    	System.out.println("url_Command : "+url_Command);
    	
    	//2. 요청 판단 처리
    	String viewpage = "";
    	if(url_Command.equals("/Register.do")) { //회원가입 페이지 전달(업무)
    		//UI 제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Register.jsp");
    		
    	}else if(url_Command.equals("/ok.do")) { //회원가입 처리(업무)
    		action = new MemberWriteAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/login.do")) {
    		//UI 제공
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/login.jsp");
    	}else if(url_Command.equals("/loginok.do")) {
    		action = new LoginProcessAction(); //다형성
    		forward = action.execute(request, response);
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

}
