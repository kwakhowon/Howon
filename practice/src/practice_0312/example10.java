package practice_0312;

import java.util.Scanner;

/*
 10. 
    연산할 값 2개 입력받기
    Input  a: 3           
    Input  b: 5
    연산자(+,-,*,/) : *   ---> switch문 이용

    3 * 5 = 15         
 */
public class example10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("a : ");
		int a = sc.nextInt();
		System.out.print("b : ");
		int b = sc.nextInt();
		System.out.print("연산자 : ");
		String ox = sc.nextLine();
		switch (ox) {
		case "+" :
			System.out.println(a+b);
			break;
		case "-" :
			System.out.println(a-b);
			break;
		case "*" :
			System.out.println(a*b);
			break;
		case "/" :
			System.out.println(a/b);
		default:
			break;
		}
	}
}
