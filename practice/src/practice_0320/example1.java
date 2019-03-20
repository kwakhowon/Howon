package practice_0320;
/*
 1. 
   String a = "100";
   String b = "200";
   a 와  b의 값을 형변환해서 두수의 곱을 구하시오
   <출력>
   100 * 200 = 20000 
 */
public class example1 {
	public static void main(String[] args) {
		String a = "100";
		String b = "200";
		
		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		System.out.println("100 * 200 = " +(x*y) );
	}
}
