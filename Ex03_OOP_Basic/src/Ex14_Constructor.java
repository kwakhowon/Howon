import kr.or.bit.Employee;

public class Ex14_Constructor {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.employeeInfoPrint();
		
		Employee emp2 = new Employee(20190101, "홍길동", "영업팀");
		emp2.employeeInfoPrint();
		emp2.setJob("IT 개발팀");
		emp2.employeeInfoPrint();
		
		//Array 를 사용해서 사원 3명을 만들어 보세요
		Employee[] emplist = {new Employee(1, "김씨", "영업팀"), 
							  new Employee(2, "이씨", "개발팀"), 
							  new Employee(3, "박씨", "경영지원부")};
		for(Employee e : emplist) {
			e.employeeInfoPrint();
		}
	}
}
