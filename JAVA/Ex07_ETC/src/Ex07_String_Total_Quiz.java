import java.util.Scanner;

//main 함수 Scanner 사용 주민번호 입력받고
//앞:6자리 뒷:7자리
//입력값 : 123456-1234567
//1. 자리수 체크(기능) 함수 (14 ok)
//2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수
//3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4, 여자 출력 기능함수
//3개의 함수 static으로 설계

public class Ex07_String_Total_Quiz {
	static boolean juminCheck(String str) {
		return str.length() ==14 ? true : false;
	}
	static void check(String str) {
		for(int i=7; i<=7; i++ ) {
			if(str.charAt(i)-48 >=5) {
				System.out.println("잘못된 입력입니다.");
			}else {
				System.out.println("뒷자리 확인 완료");
			}
		}
	}
	static void checkGender(String str) {
		for(int i=7; i<=7; i++ ) {
			if(str.charAt(i)-48 ==1 || str.charAt(i)==3) {
				System.out.println("남자입니다.");
			}else if(str.charAt(i)==2 || str.charAt(i) ==4){
				
					System.out.println("여자입니다.");
				}else {
					System.out.println("넌 뭐냐");
				}
			}
		}
	public static void main(String[] args) {
		String ssn = "";
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("주민번호 입력 : ");
			ssn = sc.nextLine();
			check(ssn);
			checkGender(ssn);
		}while(!juminCheck(ssn));
	}
}
