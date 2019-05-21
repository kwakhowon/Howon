package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
  public static void main(String[] args) {
    
    //요구사항 (Oracle DB 연동) Insert 작업을 수행하세요
    
    //MysqlArticleDao articleDao = new MysqlArticleDao();
    //OracleArticleDao articledao = new OracleArticleDao();
    //ArticleService service = new ArticleService(articledao);
    //Article article = new Article();
    
    //getBean (service) , getBean(article)
    ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
    Article article = context.getBean("article",Article.class);
    ArticleService service = context.getBean("service",ArticleService.class);
    service.write(article);
  }
}
