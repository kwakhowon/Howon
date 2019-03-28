package DTO;
/*
create table department(
	deptno number,
	dname varchar2(50)
);
 */
public class Department {
	private int deptno;
	private String dname;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + "]";
	}
	
	
}
