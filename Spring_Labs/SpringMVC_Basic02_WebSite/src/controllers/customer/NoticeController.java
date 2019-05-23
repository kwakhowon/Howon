package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

//게시판 목록 보기(업무)
//Service >> Dao 객체 생성 >> Dao 함수 호출 >> return >> 결과받기
//NoticeController 와 NoticeDao 관계
//NoticeController 는 NoticeDao 에 의존한다.

public class NoticeController implements Controller{

  public NoticeController() {
    System.out.println(" [NoticeController] ");
  }
  
  private NoticeDao noticeDao;
  //NoticeDao noticeDao = new NoticeDao() (방식(x))
  //setter 주입이 일반적(xml 설정 , Annotation 설정)
  public void setNoticeDao(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }
  
  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    //게시판 목록보기 (목록보기 서비스)
    String _page = request.getParameter("pg");
    String _field = request.getParameter("f");
    String _query = request.getParameter("q");
    
    //검색처리 (null) default 값 처리
    int page = 1;
    String field = "TITLE";
    String query="%%";
    
    //조건 처리
    if(_page != null && !_page.equals("")) {
      page = Integer.parseInt(_page);
      
    }
    if(_field != null && !_field.equals("")) {
      field = _field;
      
    }
    if(_query != null && !_query.equals("")) {
      query = _query;
      
    }
    
    //DAO 객체 데이터 목록 받아오기
    List<Notice> list = noticeDao.getNotices(page,field,query);
    
    //SpringMVC (ModelAndView 객체) >> 기존 request.setAttribute("list", list);
    ModelAndView mav = new ModelAndView();
    mav.addObject("list", list);
    mav.setViewName("notice.jsp");
    
    return mav;
  }


  

}
