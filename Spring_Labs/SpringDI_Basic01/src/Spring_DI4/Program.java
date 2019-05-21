package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
  public static void main(String[] args) {
    //NewRecordView view = new NewRecordView(100,70,80);
    
    /*
     * XML 설정에서 작업 .......
     * NewRecordView view = new NewRecordView(); 
     * NewRecord record = new NewRecord();
     * 
     * view.setRecord(record);
     */
    
    //view.input();
    //view.print();
    
    //SpringFramework 이 제공하는 메모리 (IOC 컨테이너)사용
    //(IOC 컨테이너) 만들고 그 공간에 [객체 생성 조립 >> xml 문서에게]
    ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
    RecordView view = (RecordView)context.getBean("view"); 
    //코드가 실행되면 IOC 컨테이너 생성 -> DIConfig.xml read -> 객체 생성 , 주입 > End
    
    view.input();
    view.print();
    
  }
}
