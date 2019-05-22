package AOP_Annotation;


//주 관심사를 처리하는 클래스
public class NewCalc implements Calc {
 

	@Override
	public int ADD(int x, int y) {
		
		//주관심과 보조 관심을 분리
		//Cross-Cutting-Concern)
		int sum = x + y;
		System.out.println("sum 함수 실행 : " +  sum);
		
		//주관심과 보조 관심을 분리
		//Cross-Cutting-Concern)
		return sum;
	}

	@Override
	public int MUL(int x, int y) {
		
		//주관심과 보조 관심을 분리
		//Cross-Cutting-Concern)
		int mul = x * y;
		System.out.println("mul 함수 실행 : " +  mul);
		//주관심과 보조 관심을 분리
		//Cross-Cutting-Concern)
		return mul;
	}

	@Override
	public int SUB(int x, int y) {
		
		//주관심과 보조 관심을 분리
		//Cross-Cutting-Concern)
		int sub = x - y;
		System.out.println("sub 함수 실행 : " +  sub);
		//주관심과 보조 관심을 분리
		//Cross-Cutting-Concern)
		return sub;
	}

}
