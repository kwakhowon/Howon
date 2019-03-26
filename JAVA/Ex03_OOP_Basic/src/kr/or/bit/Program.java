package kr.or.bit;

public class Program {
	public static void main(String[] args) {
		// 사원 한명 생성
		Emp emp = new Emp();
		emp.empno = 7788;
		emp.ename = "smith";
		emp.job = "manager";
		emp.setSal(8000);

		// int sal = emp.getSal();
		// System.out.println("급여정보 : "+sal);
		String result = emp.getEmpInfo();
		System.out.println(result);

		Emp emp2 = new Emp();

	}
}
