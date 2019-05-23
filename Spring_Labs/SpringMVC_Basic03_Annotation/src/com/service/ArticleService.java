package com.service;

import com.model.newArticleCommand;

public class ArticleService {
  public ArticleService() {
    System.out.println("ArticleService 객체 생성자 호출");
  }
  
  public void writeArticle(newArticleCommand command) {
    //DAO 객체 생성
    //DAO 객체 insert 함수 호출 (DB처리) 생략
    System.out.println("글쓰기 작업 완료 : " +command.toString());
  }
}
