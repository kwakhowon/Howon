package practice_0320;

import java.util.Scanner;

/*
 7. 
    값을 입력받아 0보다 작거나 100보다 크면 "입력오류!!"  출력
     (  || 연산자 , if문 이용)
점수 : 120
입력오류!!

점수 : 55
정상처리됨!!
 */
public class example7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 : ");
		int jumsu = sc.nextInt();
		if(jumsu <0 || jumsu >100) {
			System.out.println("입력오류");
		}else {
			System.out.println("점수 : " +jumsu);
			System.out.println("정상처리됨!!");
		}
	}
}
