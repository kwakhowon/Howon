package kr.or.bit;

import java.util.Scanner;

public class Practice_0208 {
	public static void main(String[] args) {

//		System.out.print("출력하고 싶은 줄의 수 입력 : ");
//		Scanner sc = new Scanner(System.in); //Scanner 객체 생성
//		int floor = sc.nextInt(); // floor 변수에 입력받은 값 저장
//		for(int i = 1; i <=floor; i++) { // i=1에서 입력받은 값까지 반복
//			for(int j =1; j<=i; j++) { // j = 1부터 i까지 반복
//				System.out.print("*"); //별 출력
//			}
//			System.out.println();       
//		}
//		System.out.println();

//		System.out.print("출력하고 싶은 줄 수 입력 : ");
//		Scanner sc = new Scanner(System.in); //Scanner 객체 생성
//		int floor = sc.nextInt(); // floor 변수에 입력받은 값 저장
//		for(int i = 1; i<=floor; i++) { // i=1에서 입력받은 값까지 반복
//			for(int j = floor; j>0; j--) { 
//				if(i<j) {
//					System.out.print(" "); // i < j 이면 공백을 출력
//				}else {
//					System.out.print("*"); // i <j 이면 * 출력
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();

//		System.out.print("출력하고 싶은 줄 수 입력 : ");
//		Scanner sc = new Scanner(System.in); // Scanner 객체 생성
//		int floor = sc.nextInt(); // floor 변수에 입력받은 값 저장
//		for(int i = 0; i<floor; i++) { // i = 0 부터 입력받은 값까지 반복
//			for(int j = 0; j< floor-i; j++) { 
//				System.out.print(" "); // 공백 출력
//			}
//			for(int j=0; j<2*i+1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.print("출력하고 싶은 줄 수 입력 : ");
//		Scanner sc = new Scanner(System.in);
//		int floor = sc.nextInt();
//		for (int i = floor; i < 0; i--) {
//			for (int j = floor; j < floor - i; j++) {
//				System.out.print("*");
//			}
//			for (int j = 0; j < 2 * i + 1; j++) { //2 * i + 1인 이유 == 별 찍는게 홀수가 나와야하기 때문에
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println();
		
		for(int i = 0; i <5; i++) {
			for(int j=5; j>=0; j--) {
				if(i<j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
