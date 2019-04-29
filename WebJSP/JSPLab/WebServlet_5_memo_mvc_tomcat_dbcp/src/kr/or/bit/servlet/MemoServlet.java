package kr.or.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;


@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemoServlet() {
       
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  request.setCharacterEncoding("UTF-8");
    	      	  
    	  String id = request.getParameter("id");
    	  String email = request.getParameter("email");
    	  String memo = request.getParameter("memo");
    	  
    	  
    	  response.setContentType("text/html;charset=UTF-8");
    	  PrintWriter out = response.getWriter();
    	  try {
    		   memodao dao = new memodao();
    		   int n = dao.insertMemo(id, email, memo);
    		   if(n>0){
    			    out.print("<script>");
    		     	out.print("alert('등록성공..');");
    		     	out.print("location.href='MemoList';"); 
    		     
    		    out.print("</script>");
    		   }else{ 
    			    out.print("<script>");
    			    out.print("alert('등록실패..');");
    			    out.print("location.href='memo.html';");
    			    out.print("</script>");
    		   }
    	  }catch(Exception e) {
    		  out.print("<b> 오류 :" +  e.getMessage()  + "</b>");
    	  }
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
