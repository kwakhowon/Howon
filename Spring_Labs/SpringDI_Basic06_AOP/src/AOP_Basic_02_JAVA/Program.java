package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {
  public static void main(String[] args) {
    Calc calc = new NewCalc();
    calc.add(100, 200);
    
    //Proxy 객체 통해서 처리
    
    Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(), //실제 클래스 메타 정보 
                           calc.getClass().getInterfaces(), //행위정보(인터페이스)
                           new LogPrintHandler(calc)); //보조관심 >> 실객체 주소
    //cal.mul(x, y);
    int result = cal.mul(5000, 2000);
    System.out.println("main : " +result);
  }
}
