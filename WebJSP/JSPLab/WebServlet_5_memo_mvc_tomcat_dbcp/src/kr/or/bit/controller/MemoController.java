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
import kr.or.bit.service.MemoListAction;
import kr.or.bit.service.MemoWriteAction;

@WebServlet("*.do")
public class MemoController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public MemoController() {
  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String requestUri = request.getRequestURI();
    String contextPath = request.getContextPath();
    String urlCommand = requestUri.substring(contextPath.length()); 
    
    ActionForward forward = null;
    Action action = null;
    
    System.out.println("requestUri: " + requestUri);
    System.out.println("contextPath: " + contextPath);
    System.out.println("urlCommand: " + urlCommand);
    
    if (urlCommand.equals("/list.do")) { 
      // 리스트 불러오기
      action = new MemoListAction();
      forward = action.execute(request, response);
    } else if (urlCommand.equals("/write.do")) {
      // 메모를 DB에 넣고 목록을 새로 보여주기
      action = new MemoWriteAction();
      forward = action.execute(request, response);
    } // id 하기
    
    if (forward != null) {
      if (forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
      } else {
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