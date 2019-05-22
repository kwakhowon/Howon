package AOP_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
  public static void main(String[] args) {
    ApplicationContext context = new GenericXmlApplicationContext("classpath:AOP_Annotation/ApplicationContext.xml");
    Calc calc = context.getBean("calc", Calc.class);
    
    calc.add(200, 300);
    calc.mul(10, 15);
    calc.sub(20, 10);
  }
}
