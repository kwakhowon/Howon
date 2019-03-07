class Parent{
	int x = 100;
	void pmethod() {
		System.out.println("parent method");
	}
}

class Child3 extends Parent{
	int y = 200;
	int x = 2000; //c# 재정의 : 변수 무시하기
	
	void parent_x() {
		System.out.println(super.x);
	}

	@Override
	void pmethod() {
		super.pmethod();
		System.out.println("부모 함수 재정의");
	}
	
}
public class Ex14_Inherit_Override {
	public static void main(String[] args) {
		Child3 ch = new Child3();
		Parent pa = ch; //다형성
		//pa.y 접근 ..... (x) 자식꺼니까 
		System.out.println("ch.x : " +ch.x);
		ch.parent_x();
		///////////////////////////////
		ch.pmethod();
		pa.pmethod();
		//부모함수로 접근해도 오버라이딩 되어있으면 재정의된 함수로 출력
		ch.pmethod();
	}
}
