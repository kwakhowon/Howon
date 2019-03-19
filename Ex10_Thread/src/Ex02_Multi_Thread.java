//Thread : 프로세스에서 하나의 최소 실행단위(method)

//Thread 실행방법 (여러개의 stack 어떻게 만듭니까?)
//1. Thread 클래스를 상속 -> class Test extends Thread()
//반드시 Thread 클래스를 상속할 경우  run()함수 재정의 >> 다른 stack main() 역할

//2. implements Runnable 구현 -> class Test implements Runnable
//반드시 run() 추상함수 재정의

//why 2가지나 제공할까 .....
//class Test extends Car implements Runnable{
//}
//다른 자원을 이미 상속하고 있는 클래스에 대해서 Thread 만들기 위한 방법
//다중상속이 안되니까 ...


//Thread 추상클래스 아닌 일반 클래스
//Thread 독자적으로 객체 생성 가능

class Thread_1 extends Thread{ //별도의 stack 운영가능
	
	@Override
	public void run() { //main 함수 역할 >> 별도의 stack에 run() 올라간다(제일먼저)
		for(int i =0; i<1000; i++) {
			System.out.println("Thread_1 " +i+ this.getName());
		}
		System.out.println("Thread_1 run() END....");
		
	}
}

class Thread_2 implements Runnable{ //이 상태는 일반 클래스 ..

	@Override
	public void run() {
		for(int i =0; i<1000; i++) {
			System.out.println("Thread_2 " +i);
		}
		System.out.println("Thread_2 END");
	}
	
	
}

public class Ex02_Multi_Thread {
	public static void main(String[] args) {
		System.out.println("Main Start");
		
		//1. Thread_1 객체 생성
		Thread_1 th = new Thread_1();
		th.start(); //Point >> stack 메모리를 만들고 (생성하고) stack에 run() 까지 올려넣고 ....
		
		//2번
		Thread_2 th2 = new Thread_2(); //일반 객체
		Thread thread = new Thread(th2);
		thread.start(); //Point >> stack 메모리를 만들고 (생성하고) stack에 run() 까지 올려넣고 ....
		
		
		for(int i =0; i<1000; i++) {
			System.out.println("main : " +i);
		}
		System.out.println("Main END");
	}
}
