
public class Ex02_Exception {
	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		
		try {
			for(int i = 0; i< 10; i++) {
				result = num/(int)(Math.random()*10);
				System.out.println("result : " +result + " i :" +i);
			}
				
		}catch(ArithmeticException ar) {
			System.out.println("연산예외 : " +ar.getMessage());
		}catch(Exception e) { // 가독성 ... 떨어지는 코드
			System.out.println("나머지 예외는 내가 처리....." +e.getMessage());
		}
		//여러개의 catch 블럭을 만들수 있다.
		//하위 예외가 항상 부모 위에 존재해야 한다.
		System.out.println("Main End");
	}
}
