package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeDetailController implements Controller {

  private NoticeDao noticeDao;
  public void setNoticeDao(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse respoonse) throws Exception {
    
    String seq = request.getParameter("seq");
    Notice notice = noticeDao.getNotice(seq);
    
    ModelAndView mav = new ModelAndView();
    mav.addObject("notice", notice);
    mav.setViewName("noticeDetail.jsp");
    return mav;
  }

}
