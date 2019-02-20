/*
객체지향언어 (OOP) 3대 특징
상속
다형성
캡슐화(은닉화) : private
 
 1. 상속
 java 	: Child extends Base child 는 Base를 확장시킨다.
 c#		: Child : Base
 
 2. 상속 특징
 -다중상속은 불가 (복잡성 ....)
 -단일상속이 원칙 (계층적 상속을 사용해서 다중상속을 구현)
 -다중상속을 지원 ( 유일하게 Interface)
 
 3. 의미
 진정한 의미 : [재사용성] >> 반복적인 코드 ... 공통코드 ... 부모
 단점 : 초기 설계 비용이 많이 들어간다 ...
 
 재사용성 >> 설계시 >> 비용적인 측면 고려(시간 , 공통분모 , 추상화 작업)
 
 Memory 로딩 ... 모습 .... 누구 먼저 Memory에 올라갔을까
 */

class GrandFather{
	public int gmoney = 5000;
	private int pmoney = 50000; 
	                             //내가 먹고 죽을꺼야 (무덤까지...)
	                             //참조변수도 접근 불가
	                             //상속관계 접근 불가
	public GrandFather() {
		System.out.println("할아버지 생성자");
	}
}

class Father extends GrandFather{
	public int fmoney = 1000;
	public Father() {
		System.out.println("아버지 생성자");
	}
}

class Child extends Father{
	public int cmoney = 100;
	public Child() {
		System.out.println("자식 생성자");
	}
}

public class Ex01_Inherit {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.gmoney); //할아버지 돈 내돈
		System.out.println(c.fmoney); //아버지 돈 내돈
		System.out.println(c.cmoney); //내돈 내돈
		//System.out.println(c.pmoney); 접근 불가
	}
}
