//연산자
public class Ex06_Operation {
	
	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13/2;
		System.out.println(result);
		
		result = 13%2;
		System.out.println(result);
		
		//증가감 연산자 (++ , --) 1씩 증가 , 1씩 감소
		int i = 10;
		++i; //전치 증가
		System.out.println(i);
		i++; //후치 증가
		System.out.println(i);
		//변수 1개 : 전치 , 후치 동일
		
		//POINT : 전치와 후치 연산자와 결합하면 본질을 드러낸다.
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2; //j2 1증가 시키고 + 연산
		System.out.println(result2);
		//i2 = 5 , j2 = 5 , result = 10
		result2 = i2 + j2++;
		System.out.println(result2);
		//i2 = 5 , j2 = 6 , result = 10
		System.out.println(j2);
		
		//POINT
		//자바의 연산 규칙
		///정수의 모든 [연산]은 int로 변환 후 처리
		// byte + byte => 컴파일러는 int + int로 인지한다.
		byte b = 100; // -128 ~ 127
		byte c = 1;
		byte d = (byte)(b + c); //일단 101 숫자가 1byte 표현 ...
		//1. byte d = (byte)(b+c); 쓰레기 값이 나올 수 있다.
		//2. int d = b + c; 사실은 이 놈이 정답
		System.out.println("d : " +d);
		
		//byte + short => int + int
		//char + char => int + int
		//POINT : 연산에서 int 보다 작은 타입은 int 형 변환(long 타입은 제외)
		//byte , char , short => int로 바꾸어서 연산 처리
		
		//byte + short => int + int >> 결과 int
		//char + int => int + int >> 결과 int
		//int + long => long + long >> 결과 long
		
		//정수와 실수 >> 실수
		//float + int => float + float >> 결과 float
		//long + float => float + float >> 결과 float
		//float + double => double + double >> 결과 double
		
		float num2 = 10.45F;
		int num3 = 20;
		//num2 + num3
		System.out.println(num2+num3);
		
		//char 는 정수 타입
		char c2 = '!';
		char c3 = '!';
		//c2 + c3 	//String > +는 결합
					//char > + 는 산술연산
		//result6 = c2 +c3;
		//char result6 = c2+c3; //!!(x)
		//char result6 = c2+c3;    int = int + int
		int result6 = c2+c3;
		System.out.println(result6);
		System.out.println((char)result6);
		
		//제어문
		//중소기업 시험문제(구구단) => 별찍기
		int sum = 0;
		for(int j = 1; j<=100; j++) {
			//System.out.print(j);
			sum = sum+j;
		}
		System.out.println("sum :" +sum);
		int sum2 = 0;
		for(int l=1; l<=100; l++) {
			if(l%2 ==0)
				sum2 += l;
		}
		System.out.println("1~100까지의 짝수의 합 : "+sum2);
		
		for(int k=2; k<10; k++) {
			for(int m=1; m<10; m++) {
				System.out.print(k*m+"\t");
			}
			System.out.println();
			
			// == 연산자(값(value) 비교하는 연산자)
			// javascript(===)
			
		}
		if(10 == 10.0f) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
		// ! 부정연산자
		if('A' != 65) { //같지 않니?
			System.out.println("같지 않은 값이다.");
		}else {
			System.out.println("같은 값이다.");
		}
		
		//암기하자(POINT)
		//제어문처럼 쓰는 연산자(삼항연산자)
		int p = 10;
		int k = -10;
		int result8 = (p == k)? p:k;
		// ? 앞의 값이 True이면 p False이면 k
		System.out.println("result8 : " +result8);
		if(p == k) {
			System.out.println(p);
		}else {
			System.out.println(k);
		}
		
		/*
		 진리표
		 0 : False
		 1 : True 
		 		OR		AND
		 0 0	False	False
		 0 1	True	False
		 1 0	True	False
		 1 1	True	True
		 
		 sql(oracle)
		 select * 
		 from emp
		 where job='sales and sal > 2000; 
		 
		 select * 
		 from emp
		 where job='sales or sal > 2000; 
		 
		 */
		 
		 //연산자( | (or) , & (and)
		 //0과 1의 bit 연산
		int x = 3;
		int y = 5;
		System.out.println("x|y : " +(x|y));
		//십진수 3을 -> 2진수값으로 변환
		// 128 64 32 16 8 4 2 1 
		//   0  0  0  0 0 0 1 1 (2진수 : 3)
		//   0  0  0  0 0 1 0 1 (2진수 : 5)
		//OR 0  0  0  0 0 1 1 1 >(2진수 : 7) 1+2+4 
		//AND0  0  0  0 0 0 0 1 >(2진수 : 1) 1
		System.out.println("x&y : " +(x&y));
		
		//Point 논리연산 (|| (or) , && (and)) 연산자 return boolean
		//왜 중요할까
		//if(10 > 0 && -1 > 1 && 100 > 2 && 1 > -1){ 실행문 }
		//if(10 > 0 || -1 > 1 || 100 > 2 || 1 > -1){ 실행문 }
	}	
}
