package practice_0320;

import java.util.Scanner;

/*
  숫자 입력받기
( 삼항연산자 이용)
     Input a : 5
     Input b : 13

     큰수 : 13
 */
public class example6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("a : ");
		int a = sc.nextInt();
		System.out.print("b : ");
		int b = sc.nextInt();
		System.out.println("큰 수 : " +(a > b ? a : b));
	}
}
