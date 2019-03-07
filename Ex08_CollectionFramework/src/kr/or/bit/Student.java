package kr.or.bit;

public class Student {
	private String name;
	private String studentNumber;
	private String birth;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Student(String name, String studentNumber, String birth) {
		super();
		this.name = name;
		this.studentNumber = studentNumber;
		this.birth = birth;
	}
	
	
}
