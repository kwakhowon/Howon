package com.edu.bbs;
 
import java.io.UnsupportedEncodingException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class ReplyFormImpl implements BBSService {
 
  @Override
  public String bbsService(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, UnsupportedEncodingException {
     
    req.setAttribute("pageNum", req.getParameter("pageNum"));
    req.setAttribute("depth", req.getParameter("depth"));
    req.setAttribute("groupId", req.getParameter("groupId"));
    req.setAttribute("pos", req.getParameter("pos"));
     
    return "/replyForm.jsp";
  }
 
}
