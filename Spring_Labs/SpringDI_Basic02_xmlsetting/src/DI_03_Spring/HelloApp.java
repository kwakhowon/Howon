package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
  public static void main(String[] args) {
    //영문
    //MessageBean_en messageBean_en = new MessageBean_en();
    //messageBean_en.sayHello("hong");
    
    //MessageBean_kr messageBean_kr = new MessageBean_kr();
    //messageBean_kr.sayHello("hong");
    
    //interface 다형성 (하나의 참조 변수가 여러개의 주소를 가질 수 있다)
    //MessageBean messageBean = new MessageBean_kr();
    //messageBean.sayHello("hong");
    
    ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
    //필요하다면 컨테이너(context) 안에서 객체를 반환 받아서 사용
    MessageBean message = context.getBean("message",MessageBean.class);
    message.sayHello("hong");
  }
}
