package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.newArticleCommand;
import com.service.ArticleService;
/*
클라이언트 요청
1. 화면주세요(글쓰기 화면)   write.do
2. 처리해주세요(글쓰기 처리) writeok.do

/article/newArticle.do (Get 방식 , Post 방식) >> 요청 method (GET) , method(POST)
하나의 요청 : 화면 , 처리 
*/
@Controller
@RequestMapping("/article/newArticle.do") //method GET , POST 구분
public class NewArticleController {
  
  //NewArticleController 와 ArticleService
  private ArticleService articleservice;
  
  @Autowired
  public void setArticleservice(ArticleService articleservice) {
    this.articleservice = articleservice;
  }
  //GET 방식 요청 (사용자 화면단 제공)
  @RequestMapping(method=RequestMethod.GET)
  public String form() {
    System.out.println("GET 방식에 대한 요청");
    return "article/newArticleForm";
    
    //ViewResolver 에 의해서
    // /WEB-INF/views/article/newArticleForm.jsp
  }
  /*
  1. 전통적으로 사용되는 Client 요청 데이터 받는 방법
  (Spring에서 더이상 사용하지 않아요)
  public String submit(HttpServletRequest request){
  request.getParameter("title");
  
  2. Parameter DTO 타입을 명시
  public String submit(newArticleCommand command)
    동작원리 JSP(UseBean Action 태그 : setProperty)
  input name="이름" >> dto 객체 memberfield 같다면 ... setter
  
  submit(NewArticleCommand command)
  DTO 타입의 memberfield 명과 parameter 이름이 같다면
  1. 자동으로 DTO 객체 생성 : NewArticleCommand command = new NewArticleCommand();
  2. 넘어온 parameter 값을 setter 통해서 자동으로 주입
  1.1 NewArticleCommand 객체 IOC 컨테이너 안에서 생성 id="newArticleCommand" 자동 생성
  
    원칙 : ModelAndView mav = new ModelAndView()
       mav.addObject("newArticleCommand" , command);
       return mav;
  1.2 위 원칙이 없어도 view 페이지에 DTO 객체 자동으로 forward(KEY POINT : newArticleCommand)
  
    다시한번 정리하면 
    
  1. submit(NewArticleCommand command)
     >> 자동 객체 생성 , 주입 , 객체변수명이 자동(key) : NewArticleCommand
     >> forward >> view page 전달
     
  2. 객체의 이름이 자동으로 생성되는 것이 싫어요
     submit(@ModelAttribute("Articledata" NewArticleCommand command)
     >>자동으로 생성되는 객체 변수명이 Articledata 강제 (key : Articledata)
  
  */
  //POST 방식 요청 (글쓰기 처리)
  @RequestMapping(method=RequestMethod.POST)
  public String submit(@ModelAttribute("Articledata")newArticleCommand command) {
    articleservice.writeArticle(command);
    return "article/newArticleSubmitted";
  }
}
