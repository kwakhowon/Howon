import javax.swing.JOptionPane;

/*

문제
main 함수 제외한 Thread 2개
1. 시간(time) 제어 Thread
2. 단어 입력을 처리하는 Thread

main 함수에서 2개 Thrad start

단 단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추고 
프로그램 종료 되게 하세요.

Hint static 자원활용
*/

class WordInputProcess extends Thread {
	@Override
	public void run() {
		String dan = "2";
		String inputdata = JOptionPane.showInputDialog("dan" + "단 값을 입력");
		if (inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame.inputcheck = true;
		}
		System.out.println("입력한 값은: " + inputdata);
	}
}

class WordTimeOut extends Thread {
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {

			if (Ex05_WordGame.inputcheck)
				return; // run함수 탈출

			System.out.println("남은 시간: " + i);
			try {
				Thread.sleep(1000); // 대기실에서 1초간 쉬었다 ....
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex05_WordGame {
	// 변수 : static
	static boolean inputcheck = false;

	public static void main(String[] args) {
		WordInputProcess word = new WordInputProcess();
		WordTimeOut time = new WordTimeOut();

		word.start();
		time.start();
		try {
			word.join(); //main 함수 쓰레드에게 기다려 달라고 ..
			time.join(); //main 함수 쓰레드에게 기다려 달라고 ..
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//word.join(); //main Thread에게 내가 끝날때까지 기다려 달라 함
		//main 함수가 word 라는 Thread를 가지고 있다.
		//time.join(); ////main Thread에게 내가 끝날때까지 기다려 달라 함
		
		//main 함수에게 기다려 달라고 내가 업무가 끝날때까지 ...word , join
		
		//Join 메소드는 하나의 스레드가 다른 스레드가 하는 일이 완료될 때 까지 기다리도록 할 때 쓰인다.
		//가령 현재 돌아가고 있는 Thread(A)에서 또 다른 Thread(B)가 완료될 때 까지 기다리려고 한다면 , 
		//B.join;
		
		//이렇게 호출 해주면 된다. 이렇게 하면,
        //현재 돌아가고 있는 스레드 A 는 스레드 B 가 하는 일이 마칠 때 까지,
        //멈춰있게(pause) 된다. join 메소드를 오버로딩(overloading) 한 메소드 들이 있는데
        //이 메소드들은 개발자가 얼마 동안 멈춰있게 할 지를 결정할 수 있다.
		
		//join() : 다른 스레드의 종료를 기다림
		//주로 다중 계산 작업하는 상황에서 최종적인 결과를 처리할 때
		//경마게임 최종적인 순위 (겨익가 종료 되면)
		System.out.println("Main END");

	}
}
