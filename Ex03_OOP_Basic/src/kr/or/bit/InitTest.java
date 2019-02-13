package kr.or.bit;

public class InitTest {
	public static int cv = 1; //static 변수 , class 변수
	public int iv = 1; //명시적 초기화
	
	static { cv = 2;} //static 초기화 블럭 == class 초기화 블럭
	{iv = 2;}  //인스턴스 초기화 블럭
	
	public InitTest() { //생성자 함수 (초기화 : instance variable 초기화)
		iv = 3;
	}
}
