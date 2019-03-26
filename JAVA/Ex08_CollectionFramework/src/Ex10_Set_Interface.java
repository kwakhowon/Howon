import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Set 인터페이스를 구현하고 있는 클래스
//Set 순서(x) , 중복(x) 데이터 집합을 다룰때 ....
//구현하는 클래스 : HashSet , TreeSet
//순서 보장하지 않아요 (넣은 순서를 보장하지 않아요)

public class Ex10_Set_Interface {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(100);
		hs.add(55);
		System.out.println(hs.toString());
		// 1. 중복 데이터 처리(POINT);
		hs.add(1);
		boolean bo = hs.add(1); // 기존에 같은 데이터 있으면 추가 (x)
		System.out.println(bo);
		hs.add(2);
		System.out.println(hs.toString());

		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("c");
		hs2.add("z");
		System.out.println(hs2.toString());
		// 순서를 유지하지 않는다 (순차적으로)

		// 1. 중복 데이터 허락하지 않아요 (일상 생활에서 중복데이터 안되요)
		String[] obj = { "A", "B", "A", "C", "D", "B", "A" };
		HashSet<String> hs3 = new HashSet<String>();
		for (int i = 0; i < obj.length; i++) {
			hs3.add(obj[i]);
		}
		System.out.println(hs3.toString());

		// Quiz
		// HashSet 사용해서 1~45까지 난수 6개를 넣으세요
		Set set = new HashSet();
		for (int i = 0; set.size() < 6; i++) {
			int num = ((int) (Math.random() * 45) + 1);
			set.add(num);
		}
		System.out.println(set.toString());
		System.out.println();

		Set set2 = new HashSet();
		while (set2.size() < 6) { // set2.size() < 6
			int num = ((int) (Math.random() * 45) + 1);
			set2.add(num);
		}
		System.out.println(set2.toString());

		HashSet<String> set3 = new HashSet<String>();
		set3.add("AA");
		set3.add("DD");
		set3.add("ABC");
		set3.add("FFFF");
		System.out.println(set3.toString());
		
		Iterator<String> s = set3.iterator();
		while(s.hasNext()) {
			System.out.println(s.next());
		}
		//add 된 순서를 보장하지 않아요 (배열이 아니예요)
		
		//Collections.sort(List<T> list); List 인터페이스를 구현하는 모든 객체 parameter 로
		
		//Set 인터페이스를 구현하는 HashSet 가지고 놀다가 .... 데이터 정렬 ..
		//HashSet >> sort 제공(X)
		List list = new ArrayList(set3);
		System.out.println("before : 무작위 >> " +list.toString());
		Collections.sort(list);
		System.out.println("after : 정렬 >> " +list.toString());
		
	}

}
