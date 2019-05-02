package com.edu.bbs;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ReplyImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
     
    BBSDto article = new BBSDto();
     
    article.setId(req.getSession().getAttribute("id").toString());
    article.setTitle(req.getParameter("title"));
    article.setContent(req.getParameter("content"));
    article.setGroupId(Integer.parseInt(req.getParameter("groupId")));
    article.setDepth(Integer.parseInt(req.getParameter("depth")));
    article.setPos(Integer.parseInt(req.getParameter("pos")));
    article.setFileName(req.getParameter("fileName"));
 
    try {
      BBSOracleDao.getInstance().replyArticle(article);
    } catch (Exception e) {
      e.printStackTrace();
    }
     
    // 이중 submit을 막기 위해 redirect 해준다.
    resp.sendRedirect("/bbs/list.bbs?pageNum="+req.getParameter("pageNum"));
     
    return null;
  }
}
