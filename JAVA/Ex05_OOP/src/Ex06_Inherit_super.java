//하나의 클래스
//this : 객체 자신을 가르키는 this(this.name , this.age)
//this : 생성자를 호출하는 thiss (this(100, "홍길동"));

//상속관계에서 
//super(부모의 주소를 담고 있다.) : 상속관계에서 부모의 자원에 접근 하는 방법
//this와 역할이 동일
//1. super : 상속관계에서 부모 자원에 접근
//2. super : 상속관계에서 부모 자원의 생성자를 명시적으로 호출

//C# : base

class Base{
	String basename;
	Base(){ 
		System.out.println("Base 클래스 기본 생성자 ");
	}
	Base(String basename){
		this.basename = basename;
		System.out.println("this.basename : " +this.basename);
	}
	void baseMethod() {
		System.out.println("Base.baseMethod()");
	}
}

class Derived extends Base{
	String dname;
	
	public Derived() {
		System.out.println("Derived 클래스의 기본 생성자 ");
	}
	
	Derived(String dname){
		//super(); //부모의 default 생성자 호출
		super(dname); //부모의 overloading 된 생성자 호출
		this.dname = dname;
		System.out.println("this.dname : " +this.dname);
	}
	@Override
	void baseMethod() {
		System.out.println("부모 함수를 재정의 하였습니다.");
	}
	//부모님이 그리워 졌어요(재정의)
	void P_method() {
		super.baseMethod();//super 부모의 주소 접근... 자원 read
	}
}



public class Ex06_Inherit_super {
	public static void main(String[] args) {
		//Derived d = new Derived();
		//d.basename
		//d.dname
		
		Derived d = new Derived("홍길동");
		d.baseMethod();
		d.P_method();
	}
}
