// 변수 <-> 상수
//상수 : 한번 값이 정해지면 변경 불가...
//시스템에서 한번 값이 정해지면 변경 되지 말아야 될것 : 시스템 버전 번호 , 약속된 표현
//일반 상식선에 값이 정해지면 변경되지 말아야 될것 : 교유값 주민번호 , PI 

//상수 관용적으로 대문자
//Java 	: final int NUM = 100;
//C#	: const int NUM = 200;

//final 키워드
//클래스 앞에 : final class Car() >> 상속불가 (extends 불가)
//함수 앞에 : public final void print(){ } >> 상속관계에서 재정의 하지마(사용빈도 X)

class Vcard{
	final String KIND = "heart";
	final int NUM = 10;
	void method() {
		//시스템 상수 (static final double PI = 3.141592....
		System.out.println(Math.PI);
	}
}

//질문 : Vcard 타입으로 만드는 모든 객체는 결국 같은 상수 값을 갖는다.
//객체마다 다른 상수값을 가지고 싶어요 ??
//상수 값이 한번 설정되면 변경 불가 ....

class Vcard2{
	final String KIND; //객체 만들고 초기화 안하면 어떻게 하지....
	final int NUM;
	
	//Vcard2(){
	//this.KIND = "heart";
	//this.NUM = 100;
	//}
	
	//강제적으로 초기화를 할 수 있는 코드를 제공 (생성자)
	Vcard2(String kind , int num){
		this.KIND = kind;
		this.NUM = num;
	}
}



public class Ex07_Final {
	public static void main(String[] args) {
		Vcard v = new Vcard();
		//v.KIND = "aa"; 안되요
		System.out.println(v.KIND);
		v.method();
		
		Vcard2 v2 = new Vcard2("space", 1);
		System.out.println(v2.KIND + " / "+v2.NUM);
		
		Vcard2 v3 = new Vcard2("heart", 10);
		System.out.println(v3.KIND + " / " +v3.NUM);
	}
}
