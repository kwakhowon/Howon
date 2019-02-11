package practice;

import java.util.Scanner;

public class Practice_0210 {
	public static void main(String[] args) {
//		System.out.print("출력하고 싶은 줄의 수 입력 : ");
//		int a = sc.nextInt();
//		for(int i = 0; i < a; i++) {
//			for(int j = 0; j<=i; j++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//			
//		}

//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 3 - i; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j < 2 * i + 1; j++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
		
		for(int i = 0; i<5; i++) {
			for(int j=5; j<0; j--) {
				if(i<j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
