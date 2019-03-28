package practice_0328;

import java.util.Scanner;

/*
19. 객체생성한후 Sadari(아랫변,윗변,높이) 메서드를 이용하여
    사다리꼴의 넓이를 구하시오, 출력은 Sadari()함수에서 할것

    ★사다리꼴넓이 = (아랫변 + 윗변) * 높이 /2	

<입력>
아랫변 : 5
윗  변 : 4
높  이 : 3  

<출력>
사다리꼴의 넓이 : 13.5

 */
public class Example19 {
	public static void main(String[] args) {
		Example19 exam = new Example19();
		exam.sadari();
	}
	public void sadari() {
		Scanner sc = new Scanner(System.in); 
		System.out.print("아랫변 입력 : ");
		int a = sc.nextInt();
		System.out.print("윗변 입력 : ");
		int b = sc.nextInt();
		System.out.print("높이 : ");
		double height = sc.nextInt();
		double result = (a+b)*height/2;
		System.out.println("넓이 : " +result);
		
	}
}
