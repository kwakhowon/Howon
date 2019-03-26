//Inner Class
//클래스 안에 클래스가 있다.

//Inner Class 개념
//AWT , SWING , ANDROID(event) 처리 : 버튼 클릭 , 마우스 오버 , .....

class OuterClass{
	public int pdata = 10;
	public int data = 20;
	
	//1. 자원에 접근을 편하게 하기 위해서....
	//2. member filed 가 선언되는 곳에
	//장점 : [[[[[[[Outerclass 가지고 있는 자원에 대한 접근 용이]]]]]]]]]]
 	class InnerClass{  //inner 클래스
		void msg() {
			System.out.println("outerclass data : " +data);
			System.out.println("outerclass data : " +pdata);
		}
	}
}


public class Ex11_InnerClass {
	public static void main(String[] args) {
		OuterClass outobj = new OuterClass();
		System.out.println("outobj.pdata : " +outobj.pdata);
		
		OuterClass.InnerClass innerobj = outobj.new InnerClass();
		innerobj.msg();
	}
}
