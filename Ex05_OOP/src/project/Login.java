package project;

import java.util.Arrays;
import java.util.Scanner;

public class Login extends Student {

	Student[] register = new Student[50];
	private int loginType; // 로그인 타입
	Scanner sc = new Scanner(System.in);
	int index = 0;

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public void LoginMethod() { // 로그인 방식 선택
		System.out.println("***************학생 증명서 관리 프로그램***************");
		try {
			System.out.println("로그인 방식을 선택해 주세요.(1. 학생증) , (2. 학번 , 생년월일) (3. 회원가입)");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				login_studentId();
				break;
			case 2:
				// login_birth();
				login_stn();
				check_stn();
				break;
			case 3:
				register();
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void check_stn() {

	}

	private void login_stn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학번을 입력하세요");
		String stn = sc.nextLine();
		System.out.println("생년월일 입력하세요");
		String birth = sc.nextLine();
		for (int i = 0; i < index; i++) { // 학번 == 배열 i
			if (register[i].getStudentNumber().equals(stn)) {
				System.out.println(register[i].getName() + "님 환영합니다.");
			} else {
				LoginMethod();
				System.out.println("에러");
			}
		}
	}

	private void register() {
		System.out.print("이름을 입력하세요.");
		String name = sc.next();
		System.out.print("학번을 입력하세요.");
		String studentNumber = sc.next();

		System.out.print("생년월일 입력하세요");
		String birth = sc.next();
		System.out.println("학과 입력해주세요");
		String major = sc.next();
		System.out.println("학년을 입력해주세요");
		String grade = sc.next();
		register[index++] = new Student(name, studentNumber, birth, major, grade);
		System.out.println("회원가입이 완료되었습니다.");
		System.out.println(Arrays.toString(register));
		LoginMethod();
	}

	private void login_birth() { // 학번 + 생년월일로 로그인
		try {
			System.out.println("학번을 입력해주세요");
			String studentId = sc.next();
			if (studentId.matches("^[2][0][1][0-9][0-9]{5}$")) {
				System.out.println("check");
			} else {
				System.out.println("잘못 입력되었습니다 다시 입력해주세요");
				login_birth();
			}
			System.out.println("생년월일을 입력해주세요");
			String birth = sc.next();
			if (birth.matches("^[0-9]{2}[0-1][0-9][0-3][0-9]$")) {
				System.out.println("check");
			} else {
				System.out.println("잘못 입력하였습니다 학번부터 다시 입력해주세요.");
				login_birth();
			}
			Thread.sleep(2000);
			System.out.println("인증이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login_studentId() { // 학생증으로 로그인
		try {
			System.out.println("학생증 식별중입니다.......");
			Thread.sleep(2000);
			System.out.println("인증이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
