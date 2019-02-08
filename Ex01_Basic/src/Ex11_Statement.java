import java.util.Scanner;

//반복문(while , do~while)
public class Ex11_Statement {
	public static void main(String[] args) {
		//while(true) {
		//System.out.println();
		//}
		
		int i = 10;
		while(i >=10) { //조건 true
			System.out.println(i);
			//반드시 내부에서 명시적인 증가감 필요합니다.
			i--;
		}
		
		//1~100까지의 합
		int sum = 0;
		int j = 1;
		while(j<=100) {
			//j++;  //주의 ^^ 5150
			sum += j;
			j++;  //5050
		}
		System.out.println(sum);
		
		//while 문으로 구구단
		int x = 2;
		while(x<=9) {
			int y = 1;
			while(y<=9) {
				System.out.printf("[%d]*[%d]=[%d]\t", x,y,x*y);
				y++;
			}
			System.out.println();
			x++;
		}
		System.out.println();
		
		//do ~ while() 강제적 실행
		
		//메뉴구성
		//1. 인사
		//2. 급여
		//1입력하면 인사 ... 2 입력하면 급여... 3번 입력 다시입력해 강제
		Scanner sc = new Scanner(System.in);
		int inputdata = 0;
		do {
			System.out.print("숫자 입력해(0~10) : ");
			inputdata = Integer.parseInt(sc.nextLine());
		}while(inputdata>10); //while true 계속 반복
		//while 문 탈출은 조건이 false 일때 while 탈출
		System.out.println("당신이 입력한 숫자는 : " +inputdata);
	}
}