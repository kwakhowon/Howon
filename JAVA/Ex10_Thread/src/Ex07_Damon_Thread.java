//개념 : Damon Thread(보조) : 한글작업시 3초 마다 자동저장
public class Ex07_Damon_Thread implements Runnable{
	static boolean autosave = false;
	@Override
	public void run() { //Damon Thread ....
		while(true) {
			try {
				Thread.sleep(3000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(autosave) { //true
				autoSaveFunction();
			}
		}
	}
	
	public void autoSaveFunction() {
		System.out.println("문서가 3초 간격으로 자동 저장 됩니다.");
	}
	
	public static void main(String[] args) { //일반 스레드 ...(non-damon)
		Thread th = new Thread(new Ex07_Damon_Thread()); //implements Runnable
		th.setDaemon(true); //너는 보조 쓰레드야.....
		th.start();
		
		//main 함수 (Ex07_Damon_Thread 보조)
		//main 함수 (글쓰기)
		for(int i=0; i<=30; i++) {
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Main Thread : " +i);
			if(i == 5) { //i가 5되는 시점부터
				System.out.println(i);
				autosave = true;
				
			}
		}
	}
}
