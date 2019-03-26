package practice_0325;
/*
 17. 메서드를 이용 구구단출력
    

단 입력 : 5

5 * 1 = 5
5 * 2 = 10
.
   .
데이타를 입력받아 함수에서 출력할것, for문 이용
메소드명:  Calc(a)
 */
public class Example17 {
	public static void main(String[] args) {
		Example17 exam17 = new Example17();
		exam17.Calc(5);
	}
	public void Calc(int dan) {
		for(int i=0; i<10; i++) {
			System.out.println(dan + " * " + i + " = " +dan * i);
		}
	}
}
