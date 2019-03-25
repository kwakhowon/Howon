package practice_0325;

import java.util.Scanner;

/*
 18. 값을 입력받아 메서드호출하여 처리하시오

입력받아  compute(item, qty, price)함수를 이용하여 금액구하기
금액 = 수량 * 단가

(입력)
품명 : apple
수량 : 10
단가 : 1200

(출력)
품명 : apple
금액 : 12000원
 */
public class Example18 {
	public static void main(String[] args) {
		Example18 exam18 = new Example18();
		Scanner sc = new Scanner(System.in);
		System.out.print("품명 : ");
		String item = sc.nextLine();
		System.out.print("수량 : ");
		int qty = sc.nextInt();
		System.out.print("단가 : ");
		int price = sc.nextInt();
		exam18.compute(item, qty, price);
	}
	public void compute(String item, int qty, int price) {
		System.out.println("품명 : " +item);
		System.out.println("금액 : " +qty * price);
	}
}
