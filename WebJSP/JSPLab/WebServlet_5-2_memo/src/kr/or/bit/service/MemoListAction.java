package kr.or.bit.service;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemoDao;
import kr.or.bit.dto.Memo;

public class MemoListAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    
    List<Memo> memolist = null;
    ActionForward forward = null;
    
    MemoDao dao;
    try {
      dao = new MemoDao();
      memolist = dao.selectAll();
      
      request.setAttribute("memolist", memolist);
      
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("/WEB-INF/memo/memolist.jsp");
    } catch (Exception e) {
      e.printStackTrace();
    } 
    
    return forward;
  }
}