package com.bit.three;

import java.util.Scanner;

public class Login extends Student{
	private static Master master;
	private Student student;
	static Scanner sc;
	
	static {
		sc = new Scanner(System.in);
		master = new Master();
	}

	public static void loginDisplay() {
		System.out.println("\n------------------------------\n");
		System.out.println("    [학생증명서 자판기]\n");
		System.out.println("1. 학생증으로 로그인");
		System.out.println("2. 회원 로그인(학번/생년월일)");
		System.out.println("\n3. 회원 가입\n");
		System.out.print("로그인 방식을 선택하세요 : ");
		do {
			switch(sc.nextLine()) {
			case "1":
				studentIdCard();
				break;
			case "2":
				loginStudentNumber();
//				studentNumber();
				break;
			case "3":
				addArr(); loginDisplay();
				break;
			case "admin":
				master.MasterPassword();
				break; 
			default : System.out.println("\n\n [Error] 입력값을 확인하세요\n\n"); loginDisplay();
			}
		}while(false);

	}
	
	private static void studentIdCard() {
		System.out.println("\n------------------------------\n");
		System.out.println("몇 초의 시간이 소요될 수 있습니다.\n");
		progressBar("학생증 인식중");
		System.out.println("\n	** 학생증 확인 완료 **\n");
		System.out.println("------------------------------");
	}
	
	private static void studentNumber() {
		System.out.println("\n------------------------------\n");
		System.out.println("몇 초의 시간이 소요될 수 있습니다.\n");
		progressBar("학생정보 확인중");
		System.out.println("\n	** 직접 입력하여 로그인 완료 **\n");
		System.out.println("------------------------------");
	}
	
	public static void progressBar(String comment) {
		try {
			System.out.print(" "+comment);
			Thread.sleep(500);
			for(int i=0; i<10; i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("[Error] 메시지를 확인하세요.");
			System.out.println(e);
		}
	}
	
	public static void progressBar(String comment, int sleeptime) {
		try {
			System.out.print(" "+comment);
			Thread.sleep(sleeptime);
			for(int i=0; i<10; i++) {
				System.out.print(".");
				Thread.sleep(sleeptime);
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("[Error] 메시지를 확인하세요.");
			System.out.println(e);
		}
	}

	private static void loginStudentNumber() {
		System.out.println("\n------------------------------\n");
		System.out.println("	[로그인]\n");
		System.out.print("학번을 입력하세요 : ");
		String studentNumber = sc.nextLine();
		System.out.print("생년월일 입력하세요 : ");
		String residentNumber = sc.nextLine();
		System.out.println("\n------------------------------\n");
		progressBar("회원정보 확인중",250);
		progressBar("전원을 끄지 마세요.\n 몇 초의 시간이 소요될 수 있습니다.", 250);
		
		for (int i = 0; i < index; i++) { // 학번 == 배열 i
			if (studentRegisterArr[i].getStudentNumber().equals(studentNumber) && studentRegisterArr[i].getResidentNumber().equals(residentNumber)) {
				System.out.println("\n------------------------------\n");
				System.out.println("\n * 로그인 성공! *");
				System.out.println("["+studentRegisterArr[i].getName() + "]님 환영합니다.");
				System.out.println("\n------------------------------\n");
				return;
			}
		}
		System.out.println("\n- 일치하는 회원 정보가 없습니다.");
		System.out.println("- 비회원이시라면, [회원가입]후 로그인 하세요.");
		loginDisplay(); 	
	}
	private static Boolean IsStudentNumber_DuplicateCheck(String studentNumber) {
		for(int i=0; i<index; i++) {
			if(studentRegisterArr[i].getStudentNumber().equals(studentNumber)) {
				return false;
			}
		}return true;
	}
	
	private static String signUpName() { // 학번 + 생년월일로 로그인
//				System.out.println("\n------------------------------\n");
//				System.out.println("	[회원 가입]\n");
//				System.out.println("				*표시는 필수 입력\n");
//				System.out.print("* [이름] : ");
//				String name = sc.nextLine();
//				System.out.println();
//				return name;
				do {
					System.out.print("* [이름] :");
					String name = sc.nextLine(); //920812
					if (name.matches("^[a-z|A-Z|가-힣\\s]+$")) { //최장수인 기준 1900년대분까지 계심
						System.out.print("=>"+name + " - [v]\n");
						return name;
					} else {
						System.out.print("=>"+name + " - [x]\n");
						System.out.print("=> It's Incorret value.\n");
						System.out.println("ex) 국문 또는 영문 이름을 적어주세요.\n");
					}
				}while(true);
			}
	
	
		private static String signUpNumber() {
			do {
				System.out.println();
				System.out.print("* [학번(9자리)] : ");
				String studentNumber = sc.nextLine();
				if (studentNumber.matches("^[2][0][1][0-9][0-9]{5}$") && IsStudentNumber_DuplicateCheck(studentNumber) ) {
					System.out.print("=>"+studentNumber + "	- [v]\n");
					return studentNumber;
				} else if(IsStudentNumber_DuplicateCheck(studentNumber)==false) {
					System.out.print("=>"+studentNumber + "	- [x]\n");
					System.out.print("=> It's overlap.\n");
					System.out.println("다시 확인해주세요.\n");
				} else {
					System.out.print("\n"+studentNumber + "	- [x]\n");
					System.out.println("ex) 201812345 와 같이 올바른 학번을 입력해 주세요.\n");
				}
			}while(true);
		}
	
		private static String signUpBirth() {
			do {
				System.out.print("\n* [생년월일 앞 6자리] :");
				String birth = sc.nextLine(); //920812
				if (birth.matches("^[0-9]{2}[0-1][0-9][0-3][0-9]$")) { //최장수인 기준 1900년대분까지 계심
					System.out.print("=>"+birth + " - [v]\n");
					return birth;
				} else {
					System.out.print("=>"+birth + " - [x]\n");
					System.out.print("=> It's Incorret value.\n");
					System.out.println("ex) 901010 과 같이 올바른 생년월일을 입력해 주세요.\n");
				}
			}while(true);
		}
		
		private static String signUpGrade() {
			do {
				System.out.print("\n* [학년(숫자만)] :");
				String grade = sc.nextLine(); //920812
				if (grade.matches("^[1-6]{1}$")) { //최장수인 기준 1900년대분까지 계심
					System.out.print("=>"+grade + "학년 - [v]\n");
					return grade;
				} else {
					System.out.print("=>"+grade + "학년 - [x]\n");
					System.out.print("=> It's Incorret value.\n");
					System.out.println("ex) 1학년->1 | 2학년->2 | 3학년->3 | 4학년->4 | 석사->5 | 박사->6\n");
				}
			}while(true);
		}
		
		private static String signUpMajor() {
			do {
				System.out.print("\n* [전공] :");
				String major = sc.nextLine(); //920812
				if (major.matches("^[a-z|A-Z|가-힣\\s]{1,10}$")) { //최장수인 기준 1900년대분까지 계심
					System.out.print("=>"+major + " - [v]\n");
					return major;
				} else {
					System.out.print("=>["+major + "] 전공 - [x]\n");
					System.out.print("=> It's Incorret value.\n");
					System.out.println("ex) 올바른 전공명을 적어주세요(1~10글자 사이).\n");
				}
			}while(true);
		}
		
		private static void addArr() {
			String s1 = signUpName();
			String s2 = signUpNumber();
			String s3 = signUpBirth();
			String s4 = signUpGrade();
			String s5 = signUpMajor();
			if(index<100) {
				studentRegisterArr[index++] = new Student(s1,s2,s3,s4,s5);
			}else {
				System.out.println("더 이상 회원 가입할 수 없습니다.");
				System.out.println("학생증을 통한 로그인 혹은 관리자에게 문의하세요.");
			}
			
//			System.out.println(studentRegisterArr[1]);
//			System.out.println(index);
			 
		}
	
	
}