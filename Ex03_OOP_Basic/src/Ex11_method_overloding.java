/*
 객체 지향 언어 특징
 상속 , 캡슐화 , 다형성 ...
 
 캡술화 (은닉화) -> private
 
 [method overloading]
 [하나의 이름]으로 [여러가지 기능]을 하는 함수
 사용 : System.out.println() 대표적인 예
 특징 : 오버로딩 성능향상에 도움을 주지 않는다.
 	  why? 편하게 사용하려고 >> 개발자
 	   설계시 어떤 점을 고려 : 함수의 활용이 많은 경우

문법 : 함수의 이름은 같고 parameter 의 개수와 타입을 달리하는 방법
1. 함수의 이름은 같아야 한다.
2. [parameter] 개수 또는 [Type]은 달라야 한다.
3. return Type 은 overloading 판단 기준이 아니다.
4. parameter 순서가 다름을 인정한다......
 
 */

class Human {
	String name;
	int age;
}

class OverTest{
	
	void add(Human h) {
		h.name = "홍길동";
		h.age = 100;
		System.out.println(h);
	}
	
	int add(int i) { 
		return 100 + i;
	}
	
	String add(String s) {
		return "hello" + s;
	}
	
	
	//void add(int k) {} 안되요(parameter type 충돌)
	
	int add(int i , int j) {
		return i + j;
	}
	
	void add(int i , String s) {
		System.out.println("오버로딩");
	}
	
	void add(String s , int i) { //순서가 다름을 인정
		System.out.println("순서 인정 : overloading" );
	}
}

public class Ex11_method_overloding {
	public static void main(String[] args) {
		System.out.println(100);
		System.out.println("HELLO");
		
		OverTest ot = new OverTest();
		System.out.println(ot.add(100));
		//ot.add(3.1f); // add(float f) 존재(x)
		
		ot.add(100 , "H");
		
		Human human = new Human();
		ot.add(human);
		System.out.println(human.name);
		System.out.println(human.age);
		
		ot.add(new Human());
	}
}
