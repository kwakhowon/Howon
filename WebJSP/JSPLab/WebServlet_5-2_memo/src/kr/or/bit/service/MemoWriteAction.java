package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemoDao;
import kr.or.bit.dto.Memo;

public class MemoWriteAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    String id = request.getParameter("id");
    String email = request.getParameter("email");
    String content = request.getParameter("memo");
    ActionForward forward = new ActionForward();
    int row = 0;

    try {
      Memo memo = new Memo();
      memo.setId(id);
      memo.setEmail(email);
      memo.setContent(content);
      
      MemoDao dao = new MemoDao();
      row = dao.insertMemo(memo);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    forward.setRedirect(false);
    if (row > 0) {
      forward.setPath("/list.do");
    } else {
      forward.setPath("/memo.html");
    }
    
    return forward;
  }

}
