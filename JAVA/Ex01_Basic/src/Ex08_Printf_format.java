import java.util.Scanner;

public class Ex08_Printf_format {
	public static void main(String[] args) {
		// java.lang package 아래 있는 자원 (import) 선언 구문 없이 사용 가능
		// default open 되어 있어서
		// C# : Console.WriteLine()
		// C# : Console.ReadLine()

		// java : System.out.println()
		System.out.println("A"); // 줄바꿈
		System.out.print("B");
		System.out.print("C");
		System.out.println("D"); // 줄바꿈
		System.out.println("S");

		int num = 100;
		System.out.println(num);
		System.out.println("num 값은 : " + num + " 입니다.");

		// 형식(format) 문자 (약속)
		// %d (10진수 형식의 정수)
		// %f (실수)
		// %s (문자열)
		// %c (문자)
		// 특수문자 :\t (Tab key) , \n (줄바꿈)

		System.out.printf("num 값은 : %d 입니다\n", num); // %d > 형식문자
		System.out.printf("num의 값은 [%d] 입니다. 그리고 [%d] 도 있어요\n", num, 1000);

		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f의 값은 [%f] 입니다.\n", f);

		System.out.printf("문자열 값은 %s 로 출력하고 %d 다음 숫자 출력\n\n", "ABC", num);

		// cmd (console) 에서 사용자가 입력한 값을 read 오기
		// java.util.Scanner sc = new Scanner(System.in);
		// 위 코드처럼 클래스를 사용하려면 폴더(package) 를 열어 놓아야 합니다.
		// 파일 페이지 상단에 : import java.util;
		Scanner sc = new Scanner(System.in); //입력값을 받을 수 있다.
		System.out.println("값을 입력하세요");
		String value = sc.nextLine(); //사용자가 입력한 값을 read
		System.out.println("입력 값 : "+value);
		
		//System.out.println("숫자값을 입력하세요");
		//int number = sc.nextInt(); // 숫자값으로 read
		//System.out.println("number : " + number);
		
		//sc.hasNextFloat(); Type 별로 read 하는 함수가 존재한다.
		//하지만 nextLine()
		//권장사항 : 그냥 문자로 read 해서 필요하다면 변환해서 사용한다.
		//Today Point////////////////////////////////
		//[[[문자를 -> 숫자로]]]
		//Integer.parseInt(s); 문자를 정수로
		//Float.parseFloat(s); 문자를 실수로
		//Double.parseDouble(s) 문자를 실수로
		/////////////////////////////////////////////
		System.out.println("숫자를 입력하세요");
		int number = Integer.parseInt(sc.nextLine());
		number += 100;
		System.out.println("숫자 : " +number);
		
		//숫자를 >> 문자로 (아주 가끔)
		String data = String.valueOf(1000);
		data += 100;
		System.out.println(data);
				
				
				
				
		//int --> Integer
	}
}
