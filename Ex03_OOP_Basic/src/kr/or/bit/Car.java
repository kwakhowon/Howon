package kr.or.bit;

/*
접근자(한정자 , 수정자) : modifier
public 	: (공유 : 폴더(package) 구분없이 모든 자원 공유)
private	: (개인 : class 내부에서는 공유 , 참조변수(객체) 사용불가 한 자원

**객체지향 특징 : 캡슐화 , 은닉화
1. 클래스 내부에서 private int age;
1.1 private : 직접할당을 막고 간접할당을 통해서 자원 보호
1.2 설계자의 의도(원하는 값만 처리) age 변수에 1~200 정수만 허용 > 별도의 함수로 구현
1.3 캡슐화된 자원의 간접할당을 처리하는 특수한 함수 : (setter , getter)
	private member field 에 read , write를 할 수 있는 함수이다.
	
1.4 private int age;
	-setter (o) 함수
	-getter (o) 함수
	
	-- 필요에 따라서는 setter 만 구현, getter만 구현해도 된다.
 */
public class Car {
	private int window;
	private int speed;

	// 자동완성 기능
	public int getWindow() { // read
		return window;
	}

	public void setWindow(int window) { // writed
		this.window = window;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		// 간접할당
		if (speed < 0) {
			this.speed = 0;
		} else {
			this.speed = speed;
		}

	}
	//자동완성 기능
	//필요하다면 추가 함수(기능)
	public void speedUp() {
		speed += 10;
	}
	public void speedDown() {
		if(speed > 0){
			speed -= 5; // speed = speed - 5
		}else {
			speed = 0;
		}
	}
}
