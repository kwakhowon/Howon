package project;

public class Student {
	private String studentNumber;
	private String birth;
	private String grade;
	private String major;
	private String name;

	public Student() {
	}

	public Student(String name, String studentNumber, String birth, String grade, String major) {
		this.studentNumber = studentNumber;
		this.birth = birth;
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

	public String getBirth() {
		return birth;
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
