import java.io.IOException;

import kr.or.bit.ExClass;
/*
클래스 설계시 내가 만드는 자원에 대해서 개발자가 강제로 예외처리를 하게하는 방법
생성자 , 함수 사용시 예외를 강제하도록 설계......
throws

JAVA API 제공하는 클래스 .....
try {
			FileInputStream fi = new FileInputStream("C:\\Temp\\a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 */

public class Ex04_Exception_throws {
	public static void main(String[] args) {
		ExClass ex;
		try {
			ex = new ExClass("C:\\Temp");
			ex.call();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
