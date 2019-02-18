class Man {
	String name;
	int age;

}

//함수(method) >> return Type 또는 parameter 자원으로 사용
//1. 8가지 기본 타입 
//2. String		: String m(String str){ return ... }
//3. Array		: int[] m (int[] arr) { return ... }
//4. 사용자 정의 클래스(Type)	: Man m(Man s) { return ... }	
//5. Interface
class Test {
	Man add(Man m) {
		m.name = "누구";
		m.age = 10;
		return m;
	}

	Man add(Man x, Man y) {
		y.name = x.name;
		y.age = x.age;
		return y;
	}
}

public class Ex12_Method_overloading_Object {
	public static void main(String[] args) {
		Test t = new Test();
		Man man = new Man();
		Man man2 = t.add(man);
		System.out.println(man2.name + " / " + man2.age);
		// man 참조변수와 man2 참조변수는 같은 주소값이다.
		System.out.println(man == man2);

		Man man3 = t.add(new Man(), new Man());
		System.out.println(man3.name + " / " + man3.age);
		System.out.println(man2 == man3);
	}

}
