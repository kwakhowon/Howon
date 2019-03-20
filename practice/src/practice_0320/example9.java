package practice_0320;

import java.util.Scanner;

/*
 9. 4개의 값을 입력받아 처리하시오

Input name: 장윤정
Input age:  25
Input tall: 173.3 
Input gender: F
(성별 : M 이면 "남자", F이면 "여자" - 삼항연산자 이용)

이름 : 장윤정
나이 : 25세
신장 : 173.3cm   <--소수이하1자리까지
성별 : 여자 
 */
public class example9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("age : ");
		int age = sc.nextInt();
		System.out.print("tall : ");
		double tall = sc.nextDouble();
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(tall);
		
		System.out.println(gender.equals("M") ? "남자" : "여자");
	}
}
