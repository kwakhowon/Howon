import java.util.Arrays;

import kr.or.bit.Emp;

class Test {
	void print() {
		System.out.println("부모함수_TEST ");
	}
}

class Test2 extends Test {

	@Override
	void print() {
		System.out.println("자식함수_TEST2_개발자 마음대로");
	}

	void print(String s) { //오버로딩
		System.out.println("나는 오버로딩 함수야 ^^");

	}
}

public class Ex05_Inherit_override {
	public static void main(String[] args) {
		Test2 test = new Test2();
		test.print(); //재정의
		test.print("오버로딩");
		System.out.println(test);
		System.out.println(test.toString());
		
		//Emp 클래스에서 Object 가지는 toString() 재정의
		Emp e = new Emp(9999,"아무개");
		String str = e.toString();
		System.out.println(str);
		
		//Arrays  이녀석도 Object가 가지는 toString() 재정의 ....
		int[] arr = {11,23,45,67,77};
		String result = Arrays.toString(arr);
		System.out.println(result);
	}

}
