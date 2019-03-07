
/*
	    HashMap 사용한 로그한 시스템
	    
		//회원 로그인 데이터 HashMap 으로 관리
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		//시스템에 로그인 하는 시나리오
		//ID(0) , PWD(0)  >> 회원  (환영)
		//ID(0) , PWD(x)  >> 실패  (비번다시 입력)
		
		//ID(x) , PWD(x)  >> 실패  (다시 입력해)
		//ID(x) , PWD(0)
		
		//Scanner 사용해서  ID, PWD 입력받으세요
		//loginmap 통해서 검증 로직 처리
		//ID 또는  PWD 틀리면 다시 입력 요청
		//ID , PWD 다 맞으면 회원님 방문 환영합니다 ^^ (출력 프로그램 종료)
	    //ID 는 소문자 구분없이 처리 합니다.
*/
import java.util.*;

public class Ex13_HashMap_Quiz {
	public static void main(String[] args) {
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		// 회원 데이터 ....
		Set set = loginmap.keySet();
		Collection vlist = loginmap.values();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println();
		System.out.println(vlist.toString());
		// 구현 로그인 시스템
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디를 입력하세요.");
			String id = sc.next();
			System.out.println("비밀번호를 입력하세요.");
			String password = sc.next();
			if (!loginmap.containsKey(id)) { //!loginmap.containsKey(id)
				System.out.println("ID확인 요망");
			} else {
				if (loginmap.get(id).equals(password)) { //loginmap.get(id).equals(password)
					System.out.println("환영합니다.");
					break;
				} else {
					System.out.println("비밀번호 확인 요망");
				}
			}
		}
	}
}
