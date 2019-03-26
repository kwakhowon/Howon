package kr.or.bit;
/*
 만든이 : 곽호원
 날짜 : 2019.02.08
 파일 : Emp.java(사원정보)
 
 class 설계도이다.
 설계도의 기본적인 구성요소는 (상태,고유정보 + 행위정보(기능))
 					    속성(변수)field + 기능(함수)method
 
 */

public class Emp {
	public int empno; //사번(정보 > 변수 > member field(intstance variable)
	public String ename; //이름
	public String job; //직종
	
	private int sal; //급여 (캡슐화, 은닉화 : 간접할당)
	//sal 값을 write(set) , read(get)
	
	public int getSal() { //read
		return sal;
	}

	public void setSal(int sal) { //write 간접할당
		if(sal < 0) {
			this.sal = 0;
		}else {			
			this.sal = sal;
		}
	}
	
	private int mgr; //관리자 사번

	public int getMgr() { //read (getter)
		return mgr;
	}

	public void setMgr(int mgr) {  //write 자동 으로 ....
		this.mgr = mgr;
	}
	
	
	//기능(함수)
	public String getEmpInfo() {
		return empno  + "/" + ename + "/" + job +"/" +sal;
	}
	
	
}
