package AOP_Basic_05;

import org.springframework.aop.framework.ProxyFactoryBean;
public class NewCalc implements Calc {

  @Override
  public int add(int x, int y) {
    //보조업무 (공통사항 : cross-cutting-concern)
    int sum = x+y; //주업무(core-concern)
    //보조업무 (공통사항 : cross-cutting-concern)
    return sum;
  }

  @Override
  public int mul(int x, int y) {
  //보조업무 (공통사항 : cross-cutting-concern)
    int mul = x*y; //주업무(core-concern)
    //보조업무 (공통사항 : cross-cutting-concern)
    return mul;
  }

  @Override
  public int sub(int x, int y) {
  //보조업무 (공통사항 : cross-cutting-concern)
    int sub = x-y; //주업무(core-concern)
    //보조업무 (공통사항 : cross-cutting-concern)
    return sub;
  }

}
