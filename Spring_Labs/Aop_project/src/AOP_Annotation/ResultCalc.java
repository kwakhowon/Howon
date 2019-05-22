package AOP_Annotation;

public class ResultCalc implements Calc{

  @Override
  public int add(int x, int y) {
    int sum = x+y;
    System.out.println("sum() 실행 : " +sum);
    return sum;
  }
  @Override
  public int mul(int x, int y) {
    int mul = x * y;
    System.out.println("mul() 실행 : " +mul);
    return mul;
  }

  @Override
  public int sub(int x, int y) {
    int sub = x-y;
    System.out.println("sub() 실행 : " +sub);
    return sub;
  }
  
}
