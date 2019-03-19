//우선순위 : CPU 점유율을 높이겠다.
//모든 Thread : 상수값 5 (default)
//Max : 10 , Min : 1(상대적 ....)


class Pth extends Thread{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("~~~~~~~~~~~~~");
		}
	}
}

class Pth2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("|||||||||||||||");
		}
	}
}

class Pth3 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("*****************");
		}
	}
}

public class Ex06_Priority {
	public static void main(String[] args) {
		Pth ph = new Pth();
		Pth2 ph2 = new Pth2();
		Pth3 ph3 = new Pth3();
		
		System.out.println(ph.getPriority());
		System.out.println(ph2.getPriority());
		System.out.println(ph3.getPriority());
		
		ph.setPriority(10);
		
		ph.start();
		ph2.start();
		ph3.start();
		
		System.out.println("Main End &&&&&&&&&&");
	}
}
