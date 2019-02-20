package kr.or.bit;

public class Emp {
	private int empno;
	private String ename;

	public Emp() {
	}

	public Emp(int empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	// Emp 클래스 Object 상속하고 있어요
	// toString() Object가 당신이 이 함수를 사용하면 주소값을 반환
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + "]";

	}
}
