
public class Ex10_Statement {
	public static void main(String[] args) {
		/*
		 * 
		 * 제어문 조건문(분기문) : if(단일 , else , else if) , switch() case break ... 반복문 :
		 * for(반복횟수 명확) , while(조건이 맞으면) , do~while() 강제적 실행 //break(블럭탈출) , continue(아래
		 * 구문 skip)
		 */
		int count = 0; // local variable (초기화)
		if (count < 1) {
			System.out.println("True 입니다.");
		}

		if (count < 1)
			System.out.println("True 입니다. {생략}");

		char data = 'A';
		switch (data) { // 조건 값으로 : [숫자] , [char] , [String] 가능
		case 'A':
			System.out.println("문자비교");
			break;
		default:
			System.out.println("default");
		}

		// 반복문
		int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		for (int i = 0; i <= 10; i++) {
//			System.out.println("i : " +i);
			sum += i;
		}
		System.out.println("1~10까지 합 : " + sum);

		for (int i = 1; i <= 10; i += 2) {
			sum2 += i;
		}
		System.out.println("1~10까지 홀수 합 : " + sum2);

		// 1 ~ 100 까지의 짝수의 합
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				sum3 += i;
			}
		}
		System.out.println("1~100까지 짝수 합 : " + sum3);

		// 입사시험 대표적인 문제(구구단) : 변형
		// for문 (중첩) >> 행 과 열
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				// System.out.print(i +" * " +j +" = " +i*j+"\t");
				System.out.printf("[%d]*[%d]=[%d]\t", i, j, i * j);
			}
			System.out.println();
		}
		System.out.println();
		// KEY POINT (break(탈출) , continue(스킵))
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == j)
					break;
				// System.out.print(i +" * " +j +" = " +i*j+"\t");
				System.out.printf("[%d]*[%d]=[%d]\t", i, j, i * j);
			}
			System.out.println();
		}
		System.out.println("************************");

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == j)
					continue;
				// System.out.print(i +" * " +j +" = " +i*j+"\t");
				System.out.printf("[%d]*[%d]=[%d]\t", i, j, i * j);
			}
			System.out.println();
		}
		System.out.println("**************************");

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i < j) {
					// System.out.print(i +" * " +j +" = " +i*j+"\t");
					System.out.printf("*");
				} else {
					System.out.print(" ");

				}
			}
			System.out.println("*****************************");
			System.out.println();
		}

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 100; i >=0; i--) { //시작값을 큰 값으로 처리 가능
			System.out.println("i : " +i);
		}
		
		//재미로 ... (피보나치) ... 정보처리
		System.out.println("피보나치");
		int a = 0 , b = 1 , c = 0;
		for(int i = 0; i <10; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println(" " +c);
		}
		
	}

}