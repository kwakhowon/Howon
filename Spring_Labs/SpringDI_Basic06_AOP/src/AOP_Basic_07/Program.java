package AOP_Basic_07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
  public static void main(String[] args) {
     ApplicationContext context = new GenericXmlApplicationContext("classpath:AOP_Basic_07/ApplicationContext.xml");
     Calc calc = context.getBean("proxy", Calc.class);
     
     //int result = calc.sub(10000, 50000);
     int result = calc.mul(10000, 50000);
     
     System.out.println("결과 : " +result);
  }
}
 