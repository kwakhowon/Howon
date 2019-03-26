package practice_0304;

import java.util.ArrayList;

public class Ex01_Array {
	public static void main(String[] args) {
		int[] odds = {1,3,5,7,9};
		//String[] weeks = {"월","화","수","목","금","토","일"};
		String[] weeks = new String[7];
		weeks[0] ="월";
		weeks[1] ="화";
		weeks[2] ="수";
		weeks[3] ="목";
		weeks[4] ="금";
		weeks[5] ="토";
		weeks[6] ="일";
		System.out.println(weeks[3]);
		for(int i=0; i<weeks.length; i++) {
			System.out.print(weeks[i]+"\t");
		}
		System.out.println();
		ArrayList pitches = new ArrayList();
		pitches.add("138");
		pitches.add("129");
		pitches.add("142");
		pitches.add(0,"133");
		System.out.println(pitches.get(1));
		System.out.println("pitches size : " +pitches.size());
		System.out.println(pitches.contains("142")); //boolean값 true / false
		System.out.println(pitches.remove("129"));
		System.out.println(pitches.remove(0));
	}
}
