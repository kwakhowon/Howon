package kr.or.bit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;


@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemoList() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		//MVC 패턴
    	try {
    		  //요청받기
    		
    		  //요청판단 (업무 로직 실행)
    		
    		  memodao dao = new memodao();
    		  List<memo> memolist = dao.getMemoList();
    		  
    		  //요청 결과 저장
    		  request.setAttribute("memolist",memolist);
    		  
    		  //view 지정
    		  RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
    		  dis.forward(request, response);
    		
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		
    	}
    	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
