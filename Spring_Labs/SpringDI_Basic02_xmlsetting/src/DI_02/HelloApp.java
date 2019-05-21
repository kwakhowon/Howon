package DI_02;

public class HelloApp {
  public static void main(String[] args) {
    //영문
    //MessageBean_en messageBean_en = new MessageBean_en();
    //messageBean_en.sayHello("hong");
    
    //MessageBean_kr messageBean_kr = new MessageBean_kr();
    //messageBean_kr.sayHello("hong");
    
    //interface 다형성 (하나의 참조 변수가 여러개의 주소를 가질 수 있다)
    MessageBean messageBean = new MessageBean_kr();
    messageBean.sayHello("hong");
  }
}
