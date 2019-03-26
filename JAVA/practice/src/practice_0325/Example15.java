package practice_0325;
/*
 19. 메서드 

main()함수에서 sum(3,5) / sub(7,2) / mul(4,5) / div(7,3)를 
각각 호출하고 계산된 결과를 return 받아서 main()에서 출력

더하기 : 8
빼  기 : 5
곱하기 : 20
나누기 : 2.33
 */
public class Example15 {
	public static void main(String[] args) {
		Example15 exam = new Example15();
		System.out.println(exam.sum(3,5));
		System.out.println(exam.sub(7, 2));
		System.out.println(exam.div(7,3));
		System.out.println(exam.mul(4, 5));
	}
	
	int sum(int a , int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int mul(int a, int b) {
		return a*b;
	}
	public double div (double a, double b) {
		return a/b;
	}
}
