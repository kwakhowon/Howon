package practice_0312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("jdbc");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBatis");
		
		int size = list.size();
		System.out.println("총 객체 수 : " +size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: " +skill);
		System.out.println();
		
		for(int i = 0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i +" : " +str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBatis");
		
		for(int i =0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i +" : " +str);
		}
		
		List<String> list1 = Arrays.asList("홍길동","신용권","김자바");
		for(String name : list1) {
			System.out.println(name);
		}
		
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value : list2) {
			System.out.println(value);
		}
	}
}
