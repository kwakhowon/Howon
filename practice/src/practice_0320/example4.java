package practice_0320;

import java.util.Scanner;

/*
 입력받아 계산하시오
 
    Input name : 소서노 
    kor : 90 
    eng : 70 
    mat : 75

   <출력>
    이름 : 소서노
    total점수 : 235점
    avg점수 :  78.3333333
 */
public class example4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int mat = sc.nextInt();
		int total = kor+eng+mat;
		double avg = (kor+eng+mat)/3;
		System.out.println("이름 : " +name);
		System.out.println("total점수 : " +total+"점");
		System.out.printf("avg점수 : %.6f" ,avg);
	}
}
