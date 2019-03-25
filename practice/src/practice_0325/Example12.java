package practice_0325;
/*
 12
    for문을 1번만 이용하여 1~100까지중에 홀수합, 짝수합, 전체합을 구하시오
   
    결과)
    홀수합 = 2500
    짝수합 = 2550
    전체합 = 5050
 */
public class Example12 {
	
	public static void main(String[] args) {
		int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		for(int i=0; i<=100; i++) {
			sum+= i;
			if(i%2 == 0)
				sum2 += i;
			else
				sum3 += i;
		}
		System.out.println("전체 합 : " +sum);
		System.out.println("짝수 합 : " +sum2);
		System.out.println("홀수 합 : " +sum3);
	}
}
