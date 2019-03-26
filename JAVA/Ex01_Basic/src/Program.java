public class Program {

	public static void main(String[] args) {
		// 시작점, 진입점
		// 프로그램이 실행되면 가장 먼저 실행되는 영역
		System.out.println("Hello");
		Person kim = new Person(100, "김유신");
		kim.personInfo();
		Person park = new Person(10, "박씨");
		park.personInfo();
		// new를 하는 순간 Person 클래스를 확인함 아파트 짓기 시작(메모리 상에)
	}

	/*
	 * hello.java (소스코드 : 인간이 인식 가능)
	 * javac hello.java(class파일이 생성됨) >> 실행파일 //
	 * java hello >> hello 결과 도출
	 * 
	 * stack >> 함수를 올리는 공간으로 활용 //heap 자유공간
	 * 멀티스레드 >> stack이 여러개라서 한번에 몇가지 함수를 한번에 실행시킬 수 있다.
	 * 
	 */ }
