package com.edu.bbs;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class WriteFormImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    // 로그인 유무를 확인
    HttpSession session = req.getSession();
    session.setAttribute("id", "kim");    // 임의로 세션에 id를 심는다.
//    if(session.getAttribute("id") == null) {
//      return "/login.jsp";
//    }
     
    return "/writeForm.jsp";
  }
 
}
