package practice_0325;

import java.util.Scanner;

/*
11. 
<<구구단>>
단 입력받기

5 * 1 = 5     <---while이용(1 ~ 9반복)
5 * 2 = 10
.
.
5 * 9 = 45

<<변수>>
int dan, cnt=0; //단 , count변수(1~9)
 */
public class Example11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		int cnt = 1;
		while(cnt<10) {
			System.out.println(dan+ " * " + cnt +" = " +dan * cnt);
			cnt++;
		}
	}
}
