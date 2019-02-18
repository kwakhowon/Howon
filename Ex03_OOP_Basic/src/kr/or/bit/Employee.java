package kr.or.bit;
/*
사원은 사번 , 이름 . 직종(job)을 가지고 있다 => 원칙 (캡슐화) => read , write 지원 setter , getter
사원 생성시 default 로 사번 = 9999 , 이름 = 아무개  , 직종= 인턴
Employee e = new Employee() 
별도의 함수를 사용(단 사원 생성시) 사번 , 이름  , 직종 을 입력하여 사원 생성이 가능하며
사원을 생성한 후 사원이 가지는 사번 , 이름 , 직종을 생성 후 각각 수정할 수 있다.
사원정보는 사번 , 이름 , 직종을 한번에 확인 할 수 있고 (각각의 정보는 확인 불가하다.)
예외적으로 사원의 이름정보는 조회가능하다. 출력되는 형식은 반드시 님이라는 글자가 ....
 */
public class Employee {
	private int empno;
	private String ename;
	private String job;
	
	public Employee() { //default constructor
		empno = 9999;
		ename = "아무개";
		job = "인턴";
	}
	
	public Employee(int no , String name, String jobdata) {
		empno = no;
		ename = name;
		job = jobdata;
	}
	
	//public int getEmpno() { //read
	//	return empno;
	//}
	public void setEmpno(int empno) { //write
		this.empno = empno;
	}
	public String geteEname() {
		return ename+"님"; //강제...
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	//public String getJob() {
	//	return job;
	//}
	public void setJob(String job) {
		this.job = job;
	}
	
	//일반함수
	public void employeeInfoPrint() {
		System.out.printf("사번 : [%d] , 이름 : [%s] , 직종 : [%s] \n", empno , ename , job);
	}
	
}
