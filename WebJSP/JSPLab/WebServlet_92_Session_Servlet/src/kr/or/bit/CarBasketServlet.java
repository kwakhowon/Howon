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


@WebServlet("/carbasket")
public class CarBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CarBasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니 목록 보기
    	//session 에서 정보 출력
    	response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); //servlet 마다 
		System.out.println("CarBasketServlet sessionID:" + session.getId());
		/*
		 1. getSession() or getSession(true)
		    -HttpSession 이 존재하면 그 존재하는 HttpSession 객체 를 반환하고
		    -존재하지 않으면 새로운 새션을 생성
		    
		 2. getSession(false)
		    -HttpSession 이 존재하면 현재 HttpSession 객체 를 반환하고
		    -존재하지 않으면 null return
		 
		 */
		out.print("<html><body>");
			out.print("<h3>장바구니</h3>");
			if(session != null) {
				//구매한 상품 리스트 출력하기
				List<String> list = (ArrayList<String>)session.getAttribute("productlist");
				out.print("상품목록 : " + list.toString() + "<br>");
			}else {
				out.print("장바구니 비어있어요<br>");
			}
			
			out.print("<a href='Product.html'>상품 구매 페이지 이동</a><br>");
			out.print("<a href='cardelete'>장바구니 비우기</a><br>");
			out.print("</body></html>");	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
