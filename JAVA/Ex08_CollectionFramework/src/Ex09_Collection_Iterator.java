import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

//Collection Framework
//나열된 자원에 대해서 [순차적]으로 접근해서 [값]을 return하는 표준 정의
//Iterator 인터페이스 설계

//예를 들어 A 클래스 Iterator 구현
//		 B 클래스 iterator 구현
//내가 보장받는 것은 : hasNext() 구현되어 있다 , Next() 구현되어 있다.

//ArrayList >> Iterator 구현 하고 있다.
//for문을 쓰면 안되요 .... 써도 되요
//우리가 원하는 것은 표준화된 접근

//Iterator : 순방향 데이터 read 표준
//ListIterator : 양방향 데이터 read 표준

public class Ex09_Collection_Iterator {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for(int i =0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//표준화된 인터페이스를 사용해서 출력한다면
		//Iterator
		//Collection { Iterator iterator() } //추상자원
		//List extends Collection
		//ArrayList implements List
		//ArrayList >> iterator() 함수의 { 실행블럭을 구현 }
		//Iterator (부모 타입) 접근 ....
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//generic
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(44);
		intlist.add(55);
		intlist.add(66);
		
		Iterator<Integer> list2 = intlist.iterator();
		while(list2.hasNext()) {
			System.out.println(list2.next());
		}
		
		//역방향
		for(int i=intlist.size()-1; i>=0; i--) {
			System.out.println(intlist.get(i));
		}
		System.out.println();
		//ListIterator (순방향 , 역방향) 역방향가려면 순방향을 갔다가 역방향으로
		ListIterator<Integer> li2 = intlist.listIterator();
		while(li2.hasNext()) {
			System.out.println(li2.next());
		}
		
		while(li2.hasPrevious()) {
			System.out.println(li2.previous());
		}
	}
}
