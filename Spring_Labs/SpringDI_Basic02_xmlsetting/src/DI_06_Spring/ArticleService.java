package DI_06_Spring;

public class ArticleService {
  private ArticleDao articledao;
  public ArticleService(ArticleDao articledao) {
    this.articledao = articledao;
    System.out.println("ArticleService 생성자 함수 호출");
  }
  //각각 서비스
  
  //글쓰기 서비스
  public void write(Article article) {
    System.out.println("글쓰기 구현");
    this.articledao.insert(article);
  }
  //글 목록보기 서비스
  
  //수정하기 서비스
  
}
