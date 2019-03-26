import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class GradeCheck {
	static HashMap<Integer, Grade> map = new HashMap<Integer, Grade>();
	static int count = 1;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GradeCheck gc = new GradeCheck();
		while (true) {
			System.out.println("성적 관리 프로그램!!!!");
			System.out.print("<1>추가 <2>삭제 <3>출력 <4>저장 <5>로드 <6>종료 : ");

			switch (scan.nextInt()) {
			case 1:
				gc.add();
				break;
			case 2:
				gc.delete();
				break;
			case 3:
				gc.print();
				break;
			case 4:
				gc.save();
				break;
			case 5:
				gc.load();
				break;
			case 6:
				gc.exit();
				break;

			}// switch
		} // while
	}// main

	private void add() {
		Grade grade = new Grade();
		map.put(count, grade.input(grade));
		count++;
	}

	private void delete() {
		System.out.print("삭제하실 넘버를 입력해 주세요 : ");
		int num = scan.nextInt();
		if (map.containsKey(num)) {
			map.remove(num);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("고객넘버를 잘못입력하셨습니다. 해당 정보가 없습니다.");
		}
	}

	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("번호\t수학\t자바\t파이썬\t평균\t등급");
		for (Integer number : set) {
			double math = map.get(number).getMath();
			double java = map.get(number).getJava();
			double python = map.get(number).getPython();
			double avg = map.get(number).getAvg();
			String you = map.get(number).getYou();

			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n", number, math, java, python, avg, you);
		}
	}

	private void save() {
		File file = new File("grade.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);

			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}
		System.out.println("저장되었습니다.");
	}

	private void load() {
		File file = new File("grade.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);

			map = (HashMap) oos.readObject();

			Set<Integer> set = map.keySet();
			System.out.println("번호\t수학\t자바\t파이썬\t평균\t등급");
			for (Integer number : set) {
				double math = map.get(number).getMath();
				double java = map.get(number).getJava();
				double phthon = map.get(number).getPython();
				double avg = map.get(number).getAvg();
				String you = map.get(number).getYou();

				System.out.printf("[%s]\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n", number, math, java, phthon, avg, you);
			}
			oos.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}

	private void exit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close();
	}
}// class
