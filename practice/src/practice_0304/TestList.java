package practice_0304;

import java.util.ArrayList;
import java.util.HashMap;

public class TestList {
	public static void main(String[] args) {
		ArrayList<String> pitches = new ArrayList<String>();
		pitches.add("138");
		pitches.add("129");
		pitches.add("142");
		
		System.out.println(pitches.get(1));
		System.out.println(pitches.size());
		System.out.println(pitches.contains("142"));
		
		System.out.println(pitches.remove("129"));
		System.out.println(pitches.size());
		System.out.println(pitches.remove(0));
		
		ArrayList<String> alist = new ArrayList();
		alist.add("hello");
		alist.add("java");
		String hello = alist.get(0);
		String java = alist.get(1);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("people", "사람");
		map.put("baseball", "야구");
		
		System.out.println(map.get("people"));
		System.out.println(map.containsKey("people"));
		System.out.println(map.size());
		
	}
}
