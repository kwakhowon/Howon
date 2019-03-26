//라인 주석
//설계도
public class Person {
	private int age;
	private String name;
	
	public Person() { // 생성자 함수(특수한 함수)
		// 객체 생성과 동시에 호출되는 함수
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void personInfo() {
		System.out.println("이름 : " + this.name + " , 나이 : " + this.age);
	}
}