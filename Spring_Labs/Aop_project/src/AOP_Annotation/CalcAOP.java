package AOP_Annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalcAOP {
  @Before("within(AOP_Annotation.*)") // 패키지 안의 모든 클래스
  public void useCalc() {
    Log log = LogFactory.getLog(this.getClass());
    log.info("[Before Advice Start]");
  }
  
  @AfterReturning("pointCut()") //return 타입이 int인 모든 함수
  public void useCalc2() {
    Log log = LogFactory.getLog(this.getClass());
    log.info("[After Advice Start]");
    log.info("[보조업무] 주업무 함수가 실행되고 돌아와서 바로 실행되는 함수");
  }
  @Pointcut("execution(* AOP_Annotation.ResultCalc.sub(..))")
  public void pointCut() {
    
  }
}
