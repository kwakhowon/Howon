package com.edu.bbs;
 
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ListImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    String pageNum = req.getParameter("pageNum");
     
    // web.xml에 선언한 context-param에서 값을 읽어온다.
    int pageSize = Integer.parseInt(req.getServletContext().getInitParameter("pageSize"));
    int pageBlock = Integer.parseInt(req.getServletContext().getInitParameter("pageBlock"));
     
    int totalCount = 0;
    ArrayList<BBSDto> articles = null;
    Page page = Page.getInstance();
     
    try {
      totalCount = BBSOracleDao.getInstance().getArticleTotalCount();
//      articles = BBSOracleDao.getInstance().selectArticles(1, 10);
      page.paging(Integer.parseInt(pageNum), totalCount, pageSize, pageBlock);
      articles = BBSOracleDao.getInstance().selectArticles(page.getStartRow(), page.getEndRow());
    } catch (Exception e) {
      e.printStackTrace();
    }
 
    req.setAttribute("totalCount", totalCount);
    req.setAttribute("articles", articles);
     
    req.setAttribute("pageNum", pageNum);
    req.setAttribute("pageCode", page.getSb().toString());
     
    return "/list.jsp";
  }
 
}
