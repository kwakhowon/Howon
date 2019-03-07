import java.util.Properties;

/*
Map 인터페이스를 구현한 클래스
특수한 목적 : 타입을 강제
<String , String> 타입 강제 .....(key , value)

사용목적 : 
App공통 속성 정의 (환경변수 : 상수) : 
1.프로그램의 버전
2. 파일 경로
3. 공통변수
4. 다국어 처리

*/

public class Ex16_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("master_email","bit@bit.or.kr");
		prop.setProperty("version", "1.0.0.0");
		prop.setProperty("defaultpath", "C:\\Temp\\images");
		
		//사용방법
		System.out.println(prop.getProperty("master_email"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("defaultpath"));
	}
}
