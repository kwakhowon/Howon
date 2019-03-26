
public class Ex04_DataType {
	public static void main(String[] args) {
		//안에 선언되는 변수 : 지역변수 (main 함수 안쪽)
		byte b = 100;
		System.out.println(b);
		
		int i = 12345;
		System.out.println(i);
		
		long l = 10000000000000L; //정수 리터럴은 int
		System.out.println(l);
		
		float f = 3.14f; //실수 리터럴은 double
		System.out.println(f);
		
		double d = 3.141592;
		System.out.println(d);
		
		boolean bo = true;
		
		char ch = 'A';
		
		String str = "홍길동";
		
		//Tip) java 특수문자 사용 : \ 역슬래시
		//문자를 인식할 수 있다.
		char sing = '\''; // 내가 입력한 것은 값이다.
		System.out.println(sing);
		
		//홍"길"동 >> 자체를 데이터(값)
		String name = "홍\"길\"동";
		System.out.println(name);
		
		//화면에 C:\Temp
		String path = "C:\\Temp";
		System.out.println(path);
		
	}
}
