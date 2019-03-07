import java.io.IOException;

public class Ex03_Exception_Finally {
	static void startInstall() {
		System.out.println("INSTALL");
	}
	static void copyFiles() {
		System.out.println("COPY FILES");
	}
	static void fileDelete() {
		System.out.println("DELETE FILES");
	}
	public static void main(String[] args) {
		try {
			copyFiles();
			startInstall();
			
			//개발자의 임의로 예외를 생성 할 수 있다.
			//A, B, C 정상입력 ,,,, D라고 입력(비정상)
			//사용자 예외 던지기 (예외 객체를 개발자가 직접 생성 (new) )
			throw new IOException("INSTALL 처리 중 예외발생");
	
		}catch (Exception e) {
			System.out.println("예외 메세지 출력 : " +e.getMessage());
		}finally {
			fileDelete();
		}
		//주의사항 .....
		//*********************함수 종료(return) 있다해도 finally 블럭이 있으면 실행
		//이 놈을 실행하고 함수 종료 .....***************
		System.out.println("MAIN END");
	}
}
