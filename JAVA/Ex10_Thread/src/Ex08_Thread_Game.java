import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

class TimeStart implements Runnable {
	@Override
	public void run() { // main() 과 같은 역할
		for (int i = 10; i > 0; i--) {
			System.out.println("남은시간 : " + i);

			try {
				Thread.sleep(1000); // CPU를 점유하는 너는 잠깐 쉬어
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
}

class Gugudan extends Thread {
	static HashMap<String, Integer> answer2 = new HashMap<String, Integer>();

	@Override
	public void run() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			int a = (int) ((Math.random() * 9) + 1);
			int b = (int) ((Math.random() * 9) + 1);
			int answer = a * b;
			answer2.put(a + "*" + b, answer);
			String input = JOptionPane.showInputDialog(a + " X " + b + "?");
			try {
				if (answer == Integer.parseInt(input)) {
					result.add("O");
				} else {
					result.add("X");
				}
			} catch (Exception e) {
				input = "0";
			}
			if (Ex08_Thread_Game.over)
				break;
		}
	}
}

public class Ex08_Thread_Game {
	static boolean over = false;

	public static void main(String[] args) {

		Thread gugudan = new Thread(new Gugudan());
		gugudan.start();
		TimeStart time = new TimeStart();
		time.run();
			over = true;
		System.out.println("Game over");
		System.out.println("풀었던 문제와 답");
		System.out.println("문제와 답 : "+Gugudan.answer2);
		System.out.println("정오 : " );

	}
}
