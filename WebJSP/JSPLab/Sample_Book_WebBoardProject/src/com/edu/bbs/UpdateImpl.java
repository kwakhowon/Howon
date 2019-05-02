package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class UpdateImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
     
    BBSDto article = new BBSDto();
    int result = 0;
     
    article.setArticleNumber(Integer.parseInt(req.getParameter("articleNumber")));
    article.setTitle(req.getParameter("title"));
    article.setContent(req.getParameter("content"));
    article.setFileName(req.getParameter("fileName"));
     
    try {
      result = BBSOracleDao.getInstance().updateArticle(article);
    } catch (Exception e) {
      e.printStackTrace();
    }
     
    resp.sendRedirect("/bbs/list.bbs?pageNum="+req.getParameter("pageNum"));
     
    return null;
  }
 
}
