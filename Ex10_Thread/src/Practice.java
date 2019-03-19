import javax.swing.JOptionPane;

class Word extends Thread{

	@Override
	public void run() {
		String inputdata = JOptionPane.showInputDialog("dan" + "단 값을 입력");
		if(inputdata != null && !inputdata.equals("")) {
			Practice.wordCheck=true;
		}
		System.out.println("입력한 값 : " +inputdata);
	}
	
}

class Time extends Thread{

	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			if(Practice.wordCheck) return;
			System.out.println("남은시간 : " +i);
			try {
				sleep(1000);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
public class Practice {
	static boolean wordCheck = false;
	public static void main(String[] args) {
		Word word = new Word();
		Time time = new Time();
		word.start();
		time.start();
		
		
	}
}
