/*
간단한 사칙 연산기 (+ , - , * , /)
입력값 3개 (입력값은 nextLine() 받아서 필요하다면 숫자 변환)
목적 : Integer.parseInt() ,  equals() 활용
화면
>입력값:100
>입력값(기호): +
>입력값:600
>연산결과 :700

-------------
>입력값:100
>입력값(기호): -
>입력값:100
>연산결과 :0
  
기호받는 건)
String opr = sc.nextLine();
 
hint) if(){} else if(){} 
hint) if(opr == "+"){ 더하기 연산할거야 } (빵점 XXXXXXXX)
Today Point
문자열에 대한 비교는 == 아니고 (equals() 함수를 사용한다
hint) if(opr.equals("+")){ 더하기 연산 }
*/
import java.util.*;

public class Ex09_Operation_Quiz {
	public static void main(String[] args) {
		/*
		 * String str = "+"; if(str.equals("+")) { System.out.println("+"); }
		 * 
		 * int i = 100; if(i == 100) { System.out.println(i); }
		 */
		int su = 0;
		int su2 = 0;
		String opr = "";
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 수를 입력하세요. ");
		su = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자를 입력하세요. ");
		opr = sc.nextLine();
		
		System.out.print("두번째 수를 입력하세요. ");
		su2 = Integer.parseInt(sc.nextLine());

		if (opr.equals("+")) {
			result = su + su2;
			System.out.println(result);
		} else if (opr.equals("-")) {
			result = su - su2;
			System.out.println(result);
		} else if (opr.equals("*")) {
			result = su * su2;
			System.out.println(result);
		} else if (opr.equals("/")) {
			result = su / su2;
			System.out.println(result);
		}else {
			System.out.println("지원하지 않는 연산자입니다.");
			return;
		}
	}
}
