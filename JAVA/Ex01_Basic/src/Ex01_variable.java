//변수 : variable
// 변수 scope(유효범위) : 선언되는 위치에 따라서
//1.instance variable : 객체변수 class Test{ private int age;
//2.local variable : 지역변수(함수간 공유자원)
//class Test{ public void run(){int speed = 0;}}
//3.static variable : 공유변수(객체간 공유자원)
//설계도 == 클래스 == 타입(사용자 정의 타입)
class Test {
	int iv; // instance variable
	// 이 변수는 초기화를 하지 않아도 된다. (기본값 : default) 가지고 있다.
	// why : int iv = 100; 초기화를 하지 않아도 사용가능하게 했을까요.
	// ex iv가 아파트의 층수라고 가정했을때 층수가 다 같지 않기 때문에
	// 객체마다 다른 값을 가지게 하기 위해서

	void print() {
		int i = 100; // 함수안에 있는 변수를 local variable
		// 함수가 호출되면 그때 stack 메모리에 생성되고 함수가 종료되면 같이 소멸
		// 지역변수는 반드시 초기화를 하여야 한다(암기)
		System.out.println(i);
	}

	void write() {
		System.out.println("iv 전역변수(객체): " + iv);
		// System.out.println(i);
		// Error : i 변수의 scope : print() 함수 내부
		int i = 200; // 언제라도 가능하다.
		// int iv = 300; Error는 아니지만 의미가 없다.
		System.out.println(i);
	}
}

public class Ex01_variable {
	public static void main(String[] args) {
		// 프로그램의 시작점을 가지고 있는 클래스

		int s = 5; // local variable >>선언과 동시에 초기화
		System.out.println("지역변수 : s " + s);
		int s2; // 선언부
		s2 = 100; // 초기화
		System.out.println(s2);
		s2 = 300; // override
	}
}