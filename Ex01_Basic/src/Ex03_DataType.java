/*
자바는 시스템에서 기본적으로 제공하는 8가지 기본 타입을 가지고 있다.
8가지 기본 타입은 값을 저장한다.
Tip) [값] 과 [주소]를 저장할 수 있다.

숫자 -> 정수(음의 정수 , 0 , 양의 정수) -> byte(-128~127)
								-> char(한 문자를 표현하는 자료형 : 2byte), unicode
								-> short ...(c언어의 호환성)
								-> int(-21억 ~ 21억) ** java 정수 연산의 기본 타입
								-> long(8byte) int 보다 큰 값
	-> 실수(부동소수점)		-> float(4byte) , double(8byte)
						정밀도가 높다(표현 범위가 크다) -> double ** java 실수 연산 기본타입(double)
						
	-> boolean(true , false) : 프로그램 논리 제어

궁금해요 : 문자열의 표현 : 홍길동, 안녕하세요  어디에 담을까
String 은 class : String s = new String("안녕하세요");
앞 예제 : String s = "안녕하세요";
String에 대해서 별도의 언급이 있기 까지는 String도 int처럼 사용

값타입 : 메모리에 값이 (숫자, 논리)
참조타입 : 클래스, 배열 메모리에 주소 : 번지

class == 설계도 == 타입(Type)
class 작은 타입을 모아 놓은 큰 타입이다.

class 는 반드시 메모리에 올려놓고 사용해야 한다. >> 종이 쪼가리에 불과해서 (new)를 사용했을 때에만 사용 가능
										static void main이 들어있는 class는 new 없이 사용 가능
*/

//최소한 설계도라고 하려면 >> 속성(상태정보) + 행위(기능)
class Car{
	String color; //색상을 담겠다.
	int window; //자동차의 창문 개수
}
 
public class Ex03_DataType {
	public static void main(String[] args) {

		Car c = new Car();
		// Car c c라는 주소 값을 갖는다.
		System.out.println("c라는 변수의 값 : "+c);
		//Car@15db9742 주소값(번지) >> 참조타입
		
		Car c2;
		c2 = c;
		
		c2.color = "red";
		System.out.println("c2라는 변수의 값 : "+c2);
		System.out.println(c==c2);
		
		Car c3; //선언
		c3 = new Car(); //할당 분리
		System.out.println("c3라는 변수의 값 :" +c3);
		c3.color = "gold";
		c3.window = 10;
		System.out.println(c3.color);
		System.out.println(c3.window);
		
		
		int i = 200;
		System.out.println(i);
		//200  메모리안에 값이 200
		//heap : 실제 집이 지어지는 공간
		//new로 생성하면 기본적으로 4byte 할당
		//c. 주소를 찾는 연산자
		
		int j; //선언
		j = 1000;
		//i값의 변화
		
		int a, b; //반드시 초기화
		a = 10;
		b = 20;
	
		int k = 1111;
		int k2 = k;
		
		//int (-21억 ~ 21억)
		//int number = 11111111111;  오류 (컴파일 에러)
		//정수 리터럴의 표현 범위는 int 까지(Today Point)
		//정수 리터럴 >> 표현 숫자값
		//접미사 L
		long number = 100000000000L; //정수 리터럴 값을 long으로 인지
		System.out.println("long 타입 : " +number);
		
		//char : 정수값을 가지고 있다. (2byte)
		//문자를 표현하는 타입
		//1. 한문자 > 2byte 통일
		//2. 한글한자 : 2byte
		//3. 영문자, 숫자, 특수문자, 공백 : 1byte
		//한글, 영문 모두 다 한문자 표현을 하기 위해 2byte
		
		//java 문자열 : "가" : String s = "가" , String s2 = "awklfjasfiowjel";
		//java 문자(한문자) : char c = '가'

		char single = '가';
		System.out.println(single);
		
		char ch = 'A';
		System.out.println(ch);
		System.out.println((int)ch); //casting 타입변환 //ASCII 코드표 10진수값 
		//A : 65 , a : 97
		
		char ch2 = 'a';
		System.out.println(ch2);
		System.out.println((int)ch2);
		
		int ch3 = 65;
		char c4 = (char)ch3;
		System.out.println(ch3);
		System.out.println((char)ch3); //명시적 형변환 >> 암시적 형변환도 존재한다.
		
		int cint2 = c4; //암시적 형변환  사실은  컴파일러가  (int)c4;
		//char는 정수라서 int와 형변환이 가능하다.
		
		//Today Point
		//변수가 가지고 있는 [값을 보지 말고] [변수의 타입]을 보세요.
		//타입의 크기를 보자
		//큰타입에는 작은 타입의 값을 넣을 수 있다.
		//작은 타입에는 큰 타입값을 넣을 수 없다.
		
		//int intvalue = 103029970;
		//byte bytevalue = (byte)intvalue; //(값을 버려요)
		//System.out.println(bytevalue); //쓰레기 값
		
		int intvalue = 10;
		byte bytevalue = (byte) intvalue; 
		System.out.println(bytevalue); 
		
		//String (문자열) 타입
		//String 클래스
		//String str = new String("홍길동");
		//POINT : String 일반 값타입으로 써도 전혀 문제가 없다.
		
		String str = "hello world";
		System.out.println(str);
		
		String str2 = str + "배고프다.";
		System.out.println(str2);
		
		String str3 = "1000";
		String str4 = "10";
		
		String result = str3 + str4; // + >>문자열 + 문자열  (결합연산자)
		
		System.out.println(result);
		
		System.out.println("100"+100); //100100
		System.out.println(100+"100"); //100100
		System.out.println(100+100+"100"); //200100
		System.out.println(100+(100+"100")); //100100100
		System.out.println(100+"100"+100); //100100100		
		
		
		//실수(부동소수점)
		//float(4byte) 
		//double(8byte) ** 실수의 기본 리터럴은 double >> 정밀도가 높다. >> 소수부를 더 많이 표현가능하다.
		
		float f = 3.14F;
		System.out.println(f);
		float f2 = 1.123456789f;
		System.out.println(f2); //1.1234568 //반올림처리 7자리 표현
		
		double d = 1.123456789123456789;
		System.out.println(d); //1.1234567891234568 반올림처리 16자리 표현 
		
		double d2 = 100;
		//컴파일러는 내부적으로 자동으로 형변환을 한다.(암시적 형변환)
		//double d2 = (double)100;
		
		//1232323 		>> 숫자 리터럴은 무조건 : int
		//1.123123123 	>> 실수 리터럴은 무조건 : double
		
		//Quiz
		double d3 = 100;
		int i5 = 100;
		
		//int result2 = d3 + i5;
		//1. 데이터 손실 없이 담을 수 있다.
		//double result2 = d3 + i5; 
		//System.out.println(result2);
		
		//2. 데이터가 손실될 수 있다.
		//int result2 = (int)d3 + i5;
		//System.out.println(result2);
		
		//3. 값이 손실될 수 있다.
		//	int result2 = (int)(d3 + i5);
		
		//Today Point
		//작은 타입 + 큰타입 = 큰타입
		//int + double	=> double
		//int + short	=> int
		//타입간 형변환 >> 변수가 가지는 값을 보지 말고 변수의 타입으로 판단
		
		int i6 = 100;
		byte b2 = (byte)i6;
		System.out.println(i6);
		
		byte b3 = 20;
		int i7 = b3; //사실은 내부적으로 형변호나
					 //컴파일러는 int i7 = (int)b3; >> casting
	}
}
