package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ContentImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String articleNumber = req.getParameter("articleNumber");
    BBSDto article = null;
     
    try {
      article = BBSOracleDao.getInstance().selectArticle(articleNumber);
      BBSOracleDao.getInstance().upHit(articleNumber);
    } catch (Exception e) {
      e.printStackTrace();
    }
     
    req.setAttribute("article", article);
    req.setAttribute("pageNum", req.getParameter("pageNum"));
     
    return "/content.jsp";
  }
 
}
