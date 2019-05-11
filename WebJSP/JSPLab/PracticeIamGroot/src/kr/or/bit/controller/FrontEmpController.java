package kr.or.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.EmpDeleteAction;
import kr.or.bit.service.EmpListAction;
import kr.or.bit.service.EmpLoadAction;
import kr.or.bit.service.EmpLoginAction;
import kr.or.bit.service.EmpRegInputAction;
import kr.or.bit.service.EmpRegisterAction;
import kr.or.bit.service.EmpUpdateAction;
import kr.or.bit.service.EmpUpdatePageAction;
import kr.or.bit.service.EmpUploadAction;

@WebServlet("*.do")
public class FrontEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontEmpController() {
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlCommand = requestUri.substring(contextPath.length());
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if (urlCommand.equals("/login.do")) {
    	      action = new EmpLoginAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/list.do")) { // 조회
    	      action = new EmpListAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/regInput.do")) {
    	      action = new EmpRegInputAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/register.do")) {
    	      action = new EmpRegisterAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/updatePage.do")) {
    	      action = new EmpUpdatePageAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/update.do")) {
    	      action = new EmpUpdateAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/delete.do")) {
    	      action = new EmpDeleteAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/upload.do")) {
    	      action = new EmpUploadAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/load.do")) {
    	      action = new EmpLoadAction();
    	      forward = action.execute(request, response);
    	    } else if (urlCommand.equals("/main/chart.do")) {
    	      forward = new ActionForward();
    	      forward.setRedirect(false);
    	      forward.setPath("/WEB-INF/views/chart.jsp");
    	    } else if (urlCommand.equals("/main/logout.do")) {
    	        forward = new ActionForward();
    	        forward.setRedirect(false);
    	        forward.setPath("/WEB-INF/views/logout.jsp");
    	      }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
