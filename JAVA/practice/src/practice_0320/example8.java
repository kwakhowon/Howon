package practice_0320;

import java.util.Scanner;

/*
 8. 짝수/홀수알아보기 
   숫자 입력받기
    ( %연산자, if이용)
    number : 243
    홀수다!!
 */
public class example8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int su = sc.nextInt();
		if(su%2 !=0) {
			System.out.println("홀수다!!!");
		}else {
			System.out.println("짝수다!!!");
		}
	}
}
