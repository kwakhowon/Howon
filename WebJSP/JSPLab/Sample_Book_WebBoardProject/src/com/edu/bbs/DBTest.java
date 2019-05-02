package com.edu.bbs;
 
public class DBTest {
 
  public static void main(String[] args) {
    BBSDto article = new BBSDto();
    article.setId("kim");
    article.setTitle("첫 번째 게시글 제목");
    article.setContent("첫 번째 게시글 내용");
     
    try {
       if(BBSOracleDao.getInstance().insertArticle(article) == 1) {
         System.out.println("레코드 삽입이 성공하였습니다.");
       } else {
         System.out.println("레코드 삽입이 실패하였습니다.");
       }
    } catch (Exception e) {
      e.printStackTrace();
    }
   /*  
    try {
      System.out.println(BBSOracleDao.getInstance().selectArticle("1").toString());
    } catch (Exception e) {
      e.printStackTrace();
    }*/
  }
   
}
