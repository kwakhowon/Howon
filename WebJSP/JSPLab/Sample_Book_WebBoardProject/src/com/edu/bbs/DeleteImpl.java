package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DeleteImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
    try {
      BBSOracleDao.getInstance().deleteArticle(req.getParameter("articleNumber"));
    } catch (Exception e) {
      e.printStackTrace();
    }
     
    return "/list.bbs?pageNum=" + req.getParameter("pageNum");
  }
 
}
