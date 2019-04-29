package kr.or.bit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/carsave")
public class CarSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CarSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String product = request.getParameter("product");
		
		//session 다루기
		//request 객체로 부터 session 얻기
	    HttpSession session = request.getSession();
	    
	    System.out.println("sessionID:" + session.getId());
	    
	    
	 
		List<String> list =  (ArrayList<String>)session.getAttribute("productlist");
	    System.out.println("list collection : " + list);
	    
	    if(product == null) {
	    	System.out.println("상품 선택 하시 않았어요");
	    }else {
	    	if(list == null) {
	    		System.out.println("list collection is null");
	    		list = new ArrayList<String>();
	    		list.add(product);
	    		session.setAttribute("productlist", list);
	    	}else {
	    		System.out.println("list collection is not null");
	    		list.add(product);
	    	}
	    }
	    
	    out.print("<html>");
	    	out.print("<body>");
	    		out.print("<a href='carbasket'>장바구니 보기</a>");
	    	out.print("</body>");
	    out.print("</html>");
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
