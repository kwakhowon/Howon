package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    ModelAndView mav = new ModelAndView();
    mav.addObject("name", "bituser");
    mav.setViewName("intro"); //resolver 가 없다면 : /WEB-INF/view/intro.jsp
    
    return mav;
  }

}
