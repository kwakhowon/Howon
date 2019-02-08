package kr.or.bit;

public class Emp {
	private int empno;
	private String name;
	private int sal;
	private String job;
	private int mgr;
	
	

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		if(mgr <=0) {
			mgr = 9999;
		}else {			
			this.mgr = mgr;
		}
	}

	public int getEmpno() { //getter
		return empno;
	}

	public void setEmpno(int empno) { //setter
		if(empno <= 0) {
			empno = 9999;
		}else {
		this.empno = empno;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
