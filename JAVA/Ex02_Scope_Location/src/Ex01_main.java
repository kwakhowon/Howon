
import kr.or.bit.Apt;
import kr.or.bit.Emp;
class Test{
	int i;
	
	void print() {
		System.out.println("default");
	}
}
public class Ex01_main {
	public static void main(String[] args) {
		Person p = new Person();
		p.name = "연습";
		
		//kr.or.bit 폴더 안에 있는 Car 클래스 사용
		//kr.or.bit.Apt apt = new kr.or.bit.Apt();
		Apt apt = new Apt();
		apt.aptName = "현대";
		apt.write_window(0);
		System.out.println(apt.read_window());
		
		Test t = new Test();
		t.i = 100;
		
		Emp e = new Emp();
		e.setEmpno(7777);
		System.out.println(e.getEmpno());
	}
}
