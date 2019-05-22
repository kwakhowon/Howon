package AOP_Annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.aop.AfterReturningAdvice;

@Aspect
public class CalcAOP {
	
	/*@Pointcut("execution(int *(..))")
	public void use()
	{
		//System.out.println("use함수 실행");
	}*/
	
	@Before("within(AOP_Annotation.*)") //AOP_Annotation 패키지 안의 모든 결합점
	public void useCalc()
	{
		System.out.println("Before : 계산기 함수 실행");
	}
	
	//@AfterReturning("execution(* AOP_Annotation.*.*(..))") //AOP_Annotation 패키지 안	
	@AfterReturning("execution(int *(..))") //리턴 타입이 int인 모든 함수
	public void useCalc2()
	{
		System.out.println("AfterReturning : 계산기 함수 실행2");
	}
	

	 /*implements AfterReturningAdvice 
	@Override
	public void afterReturning(Object returnvalue, Method method, Object[] args,
			Object target) throws Throwable {
		
		Log log = LogFactory.getLog(this.getClass());
		log.info("[AfterReturning Advice Start]");
		log.info("[보조 관심사] : 주 관심사 실행 후 실행 됨 "); 
		
		log.info("returnvalue : " + returnvalue);
		log.info("method : " + method);
		log.info("args : " + Arrays.toString(args));
		
		log.info("target : " + target.toString());
	}*/

}
