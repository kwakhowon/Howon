package practice_0320;

import java.util.Scanner;

/*
  입력받아 계산하시오
   

   **** 삼각형의 넓이 구하기  ****
   밑변 :  10  <---삼각형넓이 = (밑변 * 높이)/2
   높이 :   3
   
   넓이 :   ?  <--- 실수형으로 구하기(형변환)
 */
public class example5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("밑변 : ");
		int a = sc.nextInt();
		System.out.print("높이 : ");
		int b = sc.nextInt();
		System.out.println((float)(a*b/2));
	}
}
