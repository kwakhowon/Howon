package project;

import java.util.Scanner;

public class Student {
	private String name; // 이름
	private String grade; //학년
	private String major; //전공
	private int studentNumber; //학번
	private String residentNumber; //주민번호
	private String studentId; // 학생증
	Scanner sc = new Scanner(System.in);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void LoginMethod() {
		while (true) {
			System.out.println("로그인 방식을 선택해 주세요.(1. 학생증) ,(2. 학번 , 생년월일)");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				login_studentId();
				break;
			case 2:
				login_birth();
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}

	}

	private void login_birth() {
		try {
			System.out.println("학번을 입력해주세요");
			String studentId = sc.next();
			if (studentId != null) {
				System.out.println("check");
			}
			System.out.println("생년월일을 입력해주세요");
			String birth = sc.next();
			if (birth != null) {
				System.out.println("check");
			}
			Thread.sleep(1000);
			System.out.println("인증이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void login_studentId() {
		try {
			System.out.println("학생증을 투입해주세요.");
			Thread.sleep(1000);
			System.out.println("인증이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
