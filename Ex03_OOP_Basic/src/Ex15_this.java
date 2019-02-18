//this
//1. 객체 자신을 가르키는 this
//설계도에게 이야기 너 앞으로 객체로 생성될꺼지 ... 생설될꺼라고 가정하고 
//너의 자원을 좀 명시할게

//2. this 객체 자신(생성자 호출이 가능하다) : 
//원칙 : 객체 생성시 생성자 함수는 한개만 호출
//예외적으로 this 사용하면 여러개의 생성자 호출 가능

class Test6 extends Object{
	int i;
	int j;
	Test6(){}
	Test6(int i , int j){
		this.i = i;
		this.j = j;
	}
	public void print() {
		System.out.println(i + " , " +j);
	}
	public void thisPrint() {
		System.out.println(this);
	}
}

class Socar{
	String color;
	String geartype;
	int door;
	Socar() {
	this.color = "red";
	this.geartype = "auto";
	this.door = 2;
	}
	Socar(String color , String geartype, int door){
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		
	}
	
	void print() {
		System.out.println(this.color + " / " +this.geartype + " / " +this.door);
	}
}
public class Ex15_this {
	public static void main(String[] args) {
		Test6 test6 = new Test6(100, 200);
		test6.print();
		System.out.println(test6);
		test6.thisPrint();
		
		Socar so = new Socar();
		so.print();
		
		Socar so2 = new Socar("blue", "auto", 4);
		so2.print();
	}
}
