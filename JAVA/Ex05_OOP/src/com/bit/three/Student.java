package com.bit.three;

public class Student {
	private String studentNumber; //학번
	private String residentNumber; //주민등록번호(생년월일만)
	private String grade; //학년
	private String major;//전공
	public String name;//이름
	public static Student[] studentRegisterArr;
	public static int index;
	
	static {
		studentRegisterArr = new Student[100];
		studentRegisterArr[0] = new Student("정규현", "201811043", "920812","4","경영");
		index = 1;
	}
	public Student() {	}
	public Student(String name, String studentNumber, String residentNumber, String grade, String major) {
		this.studentNumber = studentNumber;
		this.residentNumber = residentNumber;
		this.grade = grade;
		this.major = major;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public String getResidentNumber() {
		return residentNumber;
	}

	public String getGrade() {
		return grade;
	}

	public String getMajor() {
		return major;
	}

	public String getName() {
		return name;
	}
}