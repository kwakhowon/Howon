package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class LoginImpl implements BBSService, LoginStatus {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
     
    String id = req.getParameter("id");
    String pw = req.getParameter("pw");
    int result = 0;
     
    try {
      result = BBSOracleDao.getInstance().loginCheck(id, pw);
    } catch (Exception e) {
      e.printStackTrace();
    }
     
    if(result == LOGIN_SUCCESS) {
      resp.sendRedirect("/bbs/list.bbs?pageNum=1");
 
      // session에 id를 심는다.
      req.getSession().setAttribute("id", id);
      return null;
    } else {
      return "login.jsp";
    }
     
  }
 
}
