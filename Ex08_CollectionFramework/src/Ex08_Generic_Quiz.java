import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kr.or.bit.CopyEmp;
import kr.or.bit.Emp;

public class Ex08_Generic_Quiz {
	public static void main(String[] args) {
		//1. Emp 클래스 사용해서 사원 3명 생성
		//단 ArrayList 제너릭 사용하세요
		List<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(100,"김씨", "경영지원부"));
		emplist.add(new Emp(200,"이씨", "영업부"));
		emplist.add(new Emp(100,"박씨", "IT"));
		
		//2. 위에서 만든 3명의 사원 정보(사번 , 이름 , 직종) 개선된 for문을 사용해서 출력
		//단 toString(사용 금지)
		for(Emp emp : emplist) {
			System.out.println(emp.getEmpno()+"/"+emp.getEname()+"/"+emp.getJob());
		}
		System.out.println();
		
		//3. 2번과 동일
		// 일반 for문 사용
		for(int i=0; i<emplist.size(); i++) {
			System.out.println(emplist.get(i).getEmpno()+"/"+emplist.get(i).getEname()+"/"+emplist.get(i).getJob());
		}
		System.out.println();
		
		//4. CopyEmp 라는 class 만드는데 구조는 emp와 동일
		//job member field 대신에
		//private int sal 추가하고 , (get , set 구현)
		//ArrayList Generic 사용해서 사원 3명 만드세요
		//아래 데이터
		//100 , "김씨" , 1000
		//200 , "이씨" , 2000
		//300 , "박씨" , 3000
		List<CopyEmp> cemplist = new ArrayList<CopyEmp>();
		cemplist.add(new CopyEmp(100,"김씨",1000));
		cemplist.add(new CopyEmp(200,"이씨",2000));
		cemplist.add(new CopyEmp(300,"박씨",3000));
		
		//5. 200번 사원 급여 5000으로 수정해서 출력
		//일반 for문 사용
		for(int i=0; i<cemplist.size(); i++) {
			if(cemplist.get(i).getEmpno()==200) {
				cemplist.get(i).setSal(5000);
			}
			System.out.println(cemplist.get(i).getEmpno()+"/"+cemplist.get(i).getEname()+"/"+cemplist.get(i).getSal());
		}
		System.out.println();
		//6. 300번 사원의 이름을 "궁금해"로 수정해서 출력하세요(개선된 for문 안에서)
		for(CopyEmp cemplist2 : cemplist) {
			if(cemplist2.getEmpno()==300) {
				cemplist2.setEname("궁금해");
			}
			System.out.println(cemplist2.getEmpno()+"/"+cemplist2.getEname()+"/"+cemplist2.getSal());
		}
		System.out.println();
		//7. 사원정보를 Iterator 인터페이스를 사용해서 출력
		Iterator<Emp> emplist2= emplist.iterator();
		while(emplist2.hasNext()) {
			System.out.println(emplist2.next());
		}
	}
}
