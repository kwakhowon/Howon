//String 클래스
//이 수업을 들으시고 String 클래스다라는 사실을 잊으세요...
//String 8가지 기본타입 사용하는 것처럼 편하게 사용하세요 ^^

//1. String 클래스 : 데이터 저장 (heap) : 자료구조 : char[] 배열
//2. String ename = "a길동"; > [a][길][동]
//3. String s = new String("ABCD");

public class Ex05_String {
	public static void main(String[] args) {
		String str = "ABCD";
		System.out.println(str.length()); //내부적으로 char[] 관리
		System.out.println(str.toString()); //Object toString 재정의
		
		String str1 = "AAA";
		String str2 = "AAA";
		System.out.println("str1 : " +str1.toString());
		System.out.println("str2 : " +str2.toString());
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		
		String str3 = new String("BBB");
		String str4 = new String("BBB");
		System.out.println("str3 : " +str3.toString());
		System.out.println("str4 : " +str4.toString());
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));
		
		//재미로...... ==쓰지말고 equals를 써라 (주소값을 비교할 일 없다.)
		String str5 = "A";
		str5 += "B";
		str5 += "C";
		str5 += "D";
		str5 += "E";
		str5 += "F";
		System.out.println(str5);
		
		String str6 = "hello";
	}
}
