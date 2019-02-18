/*
 int [] arr = new int[5]; >>default 값
 arr[0] = 100; >> 초기화
  생성자 함수(constructor) : 초기화(member field) 함수
  1. 특수한 목적을 가지는 함수(초기화)
  2. 초기화(instance variable : member field)
  
  일반함수와 다른점
  1. 함수의 이름이 고정 (class 이름과 동일(반드시))
  2. 생성자 함수는 : return type(x) , void(x) : default void
     why : 생성시점 ... 함수는 객체 생성과 동시에 호출 ... 값을 넘길 곳이 없다.
     
  목적 : 생성되는 객체마다 다른 초기값을 가지고 싶을때
  
  생성자 함수 : overloading 이 가능하다 (param 의 개수와 타입)
       
       Class Car { int door; Car(){door = 10;} } 
  시점 : Car c = new Car(); :
      1. Stack c변수 > default > null
      2. Heap Car 클래스 객체화 > 영역 > 영역안에 memberfield 로딩 > 
         > 생성자 함수 호출(로딩된 member field 초기화) > 
      3. class 생성시 default 생성자는 생략 가능
         (내가 직접 설계하지 않아도 컴파일러가 알아서 생성)
         
      Tip) 생성자 함수가 overloading 하지 않으면 글쎄요 .................
*/

class Car{
	String name;
	//당신이 직접 구현하지 않아도
	//컴파일러는 생성자가 있다고 가정
	//Car(){} 생략(default)
}

class Car2{
	String name;
	Car2(){ //default constructor(생성자 함수)
		System.out.println("나는 생성자 함수");
		System.out.println("before : " +name);
		name = "pony";
		System.out.println("after : " +name);
	}
}

class Car3{
	int number;
	//권장사항 : 코드상에서 default 생성자는 일반적으로 생략
}

class Car4{
	int door;
	int wheel;
	
	Car4(){
		//default
		System.out.println("default");
	}
	Car4(int num){ // overloading
		door = num;
		System.out.println("overloading door : " +door);
	}
	Car4(int num , int num2){
		door = num;
		wheel = num2;
		System.out.println("overloading door : wheel" +door + " , " +wheel);
	}
}

class Apt{
	String color;
	Apt(String color){
		this.color = color;
	}
}

class Apt2{
	String color;
	Apt2(){System.out.println("Default");}
	Apt2(String color){
		this.color = color;
	}
}
//1. class 생성시 Overloading 생성자가 하나라도 존재한다면 default 생성자는 자동 생성되지 않는다.(컴파일러가 자동으로 만들지 않는다.)

//why ? 강제성 (설계도)에 강제성 부여 (나는 overloading 을 강제 사용 하게 ...)
//      

public class Ex13_Constuctor_Function {
	public static void main(String[] args) {
		//Car c = new Car(); 
		//Car2 c2 = new Car2();
		//Car3 c3 = new Car3();
		Car4 c4 = new Car4(); //default [호출]해서 객체 생성
		System.out.println();
		Car4 c5 = new Car4(2); //param 1개 [호출]해서 객체 생성
		System.out.println();
		Car4 c6 = new Car4(2, 3); //param 2개 [호출]해서 객체 생성
		
		Apt2 apt = new Apt2();
		Apt2 apt2 = new Apt2("gold");
	}
}

//1. class 생성시 생성자 함수 구현하지 않으면 ... (default 생성자 자동 생성)
//ex) class Tv{String name;}

//2. class 생성시 overloading 생성자 함수를 하나라도 구현했다면 ...
// ** default 생성자는 사용 할 수 없다.**
//ex) class Tv{ String name; Tv(String name){this.name = name} }

//3. class 생성시 default , overloading 둘다 구현...
//ex) class Tv{ String name; Tv(){} Tv(String name){ this.name = name; } }