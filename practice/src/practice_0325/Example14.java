package practice_0325;

import java.util.Scanner;

/*
 14. 
    년도를 입력받아 윤년/평년 구하기
    (공식)
	①년도를 4로 나누어 떨어져야 함
	②년도를 100으로나누어 떨어지지 않거나
	  년도를 400으로 나누어 떨어져야 함
    
    년도 입력 : 2000
    윤년
    년도 입력 : 2001
    평년
    년도 입력 : 2004
    윤년

    계속입력 받아가 문자가 들어오면 종료
    System.exit(0);   <--비정상 종료
 */
public class Example14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력 : ");
		int year = sc.nextInt();
		if (year % 4 == 0)
			System.out.println("윤년");
		else
			System.out.println("평년");
	}
}
