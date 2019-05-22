package AOP_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		
		//Spring 사용하기
		 ApplicationContext context = 
	        		new ClassPathXmlApplicationContext("AOP_Annotation/ApplicationContext.xml");
		 Calc calc = (Calc)context.getBean("calc");
		
		/*BeanFactory bf = 
				new ClassPathXmlApplicationContext("AOP_Spring_AspectJ_08/ApplicationContext.xml");  
		Calc calc = (Calc)bf.getBean("calc");*/
		
		
		calc.ADD(100,200);
		System.out.println("----------------");
		calc.MUL(20, 4);
		System.out.println("----------------");
		calc.SUB(15, 4);
	}
	
}
