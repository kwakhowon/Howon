package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemoDao;

public class MemoIdCheckAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    String id = request.getParameter("id");
    ActionForward forward = new ActionForward();
    String check = "false";
    
    try {
      MemoDao dao = new MemoDao();
      check = dao.hasId(id);
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    request.setAttribute("hasId", check);
    
    forward.setRedirect(false);
    forward.setPath("/WEB-INF/memo/checkId.jsp");
    return forward;
  }
}
