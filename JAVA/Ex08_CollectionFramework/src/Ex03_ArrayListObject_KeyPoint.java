

import java.util.ArrayList;

import kr.or.bit.Emp;
import kr.or.bit.Student;

public class Ex03_ArrayListObject_KeyPoint {
	public static void main(String[] args) {
		
		//1. 사원 1명의 정보를 담으세요
		Emp e = new Emp(100, "김유신", "군인");
		System.out.println(e.toString());
		
		//*********2. 사원 2명을 만드세요.
		Emp[] emplist = {new Emp(10,"김씨" , "IT"), new Emp(20,"박씨", "SALES")};
		for(Emp emp : emplist) {
			System.out.println(emp.toString());
		}
		//실수 했어요 한명이 입사를 더 했어요.....
		//위 정적배열에 추가 불가 (x) -> 새로 new ....(x)
		
		//동적(ArrayList)
		ArrayList alist = new ArrayList();
		alist.add(new Emp(1,"김", "IT"));
		alist.add(new Emp(2,"이", "IT"));
		alist.add(new Emp(3,"박", "영업"));
		System.out.println(alist.toString());
		
		//***********일반 for문을 사용해서 사원 정보 출력하세요 (down casting)
		for(int i=0; i<alist.size(); i++) {
			//System.out.println(alist.get(i).toString());
			Emp emp = (Emp)alist.get(i); //return Object   자식타입 = (자식타입)부모타입
			System.out.println(emp.getEmpno()+"/" +emp.getEname()+"/" +emp.getJob());
		}
		
		//개선된 for문
		for(Object obj : alist) {
			Emp emp = (Emp)obj;
			System.out.println(emp.getEmpno()+"|"+emp.getEname()+"|"+emp.getJob());
		}
		
		//사실은    .... 위 코드가 불편해요 (Object)
		//generic (현대적인 ... 99%)
		
		ArrayList<Emp> alist2 = new ArrayList<Emp>();
		alist2.add(new Emp(1,"A","IT"));
		alist2.add(new Emp(2,"B","IT"));
		for(Emp emp : alist2) {
			System.out.println(emp.getEmpno()+"/"+emp.getEname()+"/"+emp.getJob());
		
		}
		
		ArrayList<Student> stu = new ArrayList<Student>();
		stu.add(new Student("김씨", "2013", "940206"));
		stu.add(new Student("최씨", "2014", "950111"));
		stu.add(new Student("황씨", "2012", "930512"));
		stu.add(new Student("이씨", "2015", "961221"));
		stu.add(new Student("양씨", "2017", "9801125"));
		for(Student student : stu) {
			System.out.println(student.getName()+"/"+student.getStudentNumber()+"/"+student.getBirth());
		}
		
	}
}
