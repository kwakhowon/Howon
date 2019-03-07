/*
인터페이스(interface)
범용적 의미
1. 약속 , 표준 , 규칙 , 규약등을 만드는 행위
ex) 나사 , 신발(사이즈)
ex) iso 표준 ...

소프트웨어 개발
>>인터페이스는 개발의 최상위 단계 (무에서 유를)
>>설계 표준 , 약속을 정의하는 행위

1. 인터페이스를 [다형성] 입장에서 접근 (인터페이스는 부모 타입이다)
2. 서로 연관성이 없는 크래스에 대해서 하나로 묶는 기능 (부모가 동일)

interface
1. 실제 구현부가 없다 : 실행블럭이 없다 : 추상함수(자원) >> void move(int x, int y);
2. 표준화된 설계를 보장(완벽한 강제성 보장)
3. 공통설계

JAVA API
(개발자가 필요한 인터페이스는 가지고 있다) : 모든 클래스는 인터페이스 기반으로 설계
>> Collection : (Vector , ArrayList , HashSet , HashMap ...... Stack , Queue ......)

1. 생성방법
상수 (final) : public static final int NUM = 0; >> int NUM = 0;
함수(method) : public abstract void run(); >> void run();
함수(method) : public abstract String move(int x, int y); >> String move(int x, int y);
인터페이스는 구현이 없는 추상메서드만 가진다...
 
1. 인터페이스는 객체 생성 불가 (상수 제외한 나머지 추상함수)
2. 구현을 통해서만 사용 가능(class Test implements Ia ....)
3. 클래스는 인터페이스는 다중 구현이 가능하다(class Test implements Ia , Ib , Ic ...)
4. 인터페이스끼리는 상속이 가능하다 (Ia extends Ib : 큰 규칙을 만들 수 있다.)
5. 인터페이스도 하나의 타입이다.
*/

interface Ia {
	// 상수(시스템 자원 값)
	public static final int VERSION = 1;
	// int VERSION=1;
	// [public static final] default
	String GENDER = "남";
	// public static final String GENDER ="남";
	
	public abstract String print();
	// String print();
	//[public abstract] default 값
	String message(String str);
}

interface Ib{
	int AGE = 0;
	void info();
	String value(String s);
}

class Test extends Object implements Ia, Ib{

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String value(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String message(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class Ex04_Interface {
	public static void main(String[] args) {
		Test t = new Test();
		Ia ia = t; //다형성 (부모타입)
		
	}
}
