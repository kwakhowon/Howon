package DI_08_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
  public static void main(String[] args) {
    /* IOC 컨테이너
    JobExecute jobexecute = new JobExecute("hong", 100L);
    //생성자 주입
    
    ArticleDao articledao = new ArticleDao();
    jobexecute.setArticledao(articledao); //setter 주입 (주소값 주입)
    
    jobexecute.setData(500); //setter 주입 (값 주입)
    */
   ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_08.xml");
  }
}
