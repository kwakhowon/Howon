package kr.or.bit;
//디자인 패턴(생성 패턴) (new .....)
//싱글톤 :: 객체를 하나만 만들어서 공유

//하나의 객체를 생성해서(공유) ...
//이 패턴을 사용하면 하나의 객체만 사요 .. 보장

//static (객체간 공유 자원)...

//JDBC (DB 연동 하는 작업시 사례 .....)

public class Singleton {
	private static Singleton p;
	//Singleton 사용하면 method area 영역에 올라가 있다.
	private Singleton() {} //생성자 private 객체를 생성 불가
	
	public static Singleton getInstance() {
		if(p == null) {
			p = new Singleton(); //생성자 호출(private 클래스 내부 .....)
		}
		return p;
	}
}
