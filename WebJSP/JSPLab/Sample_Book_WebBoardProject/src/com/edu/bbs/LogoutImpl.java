package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class LogoutImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 세션의 모든 속성을 삭제한다.
    req.getSession().invalidate();
 
    resp.sendRedirect("/bbs/login.bbs");
     
    return null;
  }
 
}
