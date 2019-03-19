package swing;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//이벤트 처리
//1. Event Resource : 발생지(Button , TextField , TextArea)
//2. Event Handler  : 처리기(버튼 클릭되면 > 창을 닫기 , 창을 열기 , 글을 쓸것인지)
//JAVA API : Interface 제공 > class aaa implements 인터페이스(이벤트를 가지고 있는)
//인터페이스 : 이벤트 (사건) 사건이 일어났을때 호출되는 (행위) 함수까지 가지고 있다

//3. Resource  에  Handler  를 붙이는 작업 (연결)

class EventHandler implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	//각각의 사건 : window 창이 닫힐때
	@Override
	public void windowClosing(WindowEvent e) { //발생지(Frame) 주소
		//호출시점 : Frame Closing 할때
		//System.out.println("호출");
		e.getWindow().setVisible(false); //보이지 않기
		e.getWindow().dispose(); //메모리 제거
		System.out.println("창닫기 성공");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}



public class Ex11_Event {

	public static void main(String[] args) {
		 Frame f = new Frame("login");
		 f.setSize(300, 200);
		 f.addWindowListener(new EventHandler());
		 f.setVisible(true);

	}

}
