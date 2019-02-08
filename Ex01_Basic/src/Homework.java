import java.util.*;

public class Homework {
	public static void main(String[] args) {
		// 1.
		// 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하는 프로그램을 작성하세요
//		int sum = 0;
//		for (int i = 1; i <= 20; i++) {
//			if (i % 2 == 0 || i % 3 == 0) {
//				continue;
//			}
//			sum += i;
//		}
//		System.out.println(sum);
//		System.out.println("***********************");

//		 3.
//		 가위 , 바위 ,보 게임 또 제어문을 통해서 작성하세요 (IF)
//		 예를 들명)
//		 컴퓨터가 자동으로 나온 가위 , 바위 , 보 에 대해서 사용자가 값을 입력 해서 처리 하세요
//		 ( 예를 들면 : 가위=> 1 , 바위 => 2 , 보 => 3)
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요.(1 = 가위 , 2 = 바위 , 3 = 보)");
		int player = Integer.parseInt(sc.next());
		System.out.print("사용자 : ");
		if(player == 1) {
			System.out.println("가위");
		}else if(player == 2) {
			System.out.println("바위");
		}else if(player == 3) {
			System.out.println("보");
		}else {
			System.out.println("잘못입력하였습니다.");
		}
		int computer = (int)((Math.random()*3)+1);
		System.out.print("컴퓨터 : ");
		if(computer == 1) {
			System.out.println("가위");
		}else if(computer == 2) {
			System.out.println("바위");
		}else if(computer == 3) {
			System.out.println("보");
		}else {
			System.out.println("잘못입력하였습니다.");
		}
		if(player == computer) {
			System.out.println("비겼습니다.");
		}else if(player-computer == 1 || player - computer == -2) {
			System.out.println("사용자가 이겼습니다.");
		}else {
			System.out.println("사용자가 졌습니다.");
		}
		int sum2 = 0;
		for (int x = 1; x <= 6; x++) {
			for (int y = 1; y <= 6; y++) {
				if (x + y == 6) {
					System.out.printf("첫번째 눈 : [%d] , 두번째 눈 : [%d] ", x, y);
					sum2++;
				}
				
			}
		System.out.println();	
		}
		System.out.println("경우의 수 : "+sum2);

	}
}
