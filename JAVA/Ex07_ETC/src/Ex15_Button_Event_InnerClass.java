import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class LoginForm3 extends Frame {
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;

	public LoginForm3(String title) {
		super(title);
		lbl_id = new Label("ID: ", Label.RIGHT);
		lbl_pwd = new Label("PWD : ", Label.RIGHT);

		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('*');
		btn_ok = new Button("login");

		this.setLayout(new FlowLayout()); // add 한 순서대로
		this.setSize(500, 100);
		this.setVisible(true);

		this.add(lbl_id);
		this.add(txt_id);

		this.add(lbl_pwd);
		this.add(txt_pwd);

		this.add(btn_ok);

		//1. 다른 클래스 자원 사용 (생성자 주소값 받기) ....
		//2. Inner class 사용해서 Outer class id, pwd 함수에 사용
		//3. 클래스까지 만들 필요가 있나요 ...
		//3.1 재사용성이 중요하지 않아요 ...
		//3.2 어차피 지금의 코드는 버튼 클릭시 처리되고 재사용이 필요 없는데
		
		//최종 (익명타입) - 1회성 - 재사용성 없다 - 코드의 간소화 .....
		//익명타입 (실제로 인터페이스는 직접 객체생성이 불가능)
		//인터페이스 클래스 없어도 직접 구현하는 방법 제공 (익명 타입)
		
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText().trim();
				String pwd = txt_pwd.getText();
				
				if(id.equals("hong")) {
					System.out.println("정말 방가" +" / " +pwd);
				}else {
					System.out.println("나는 졸고있는 것이 아니다");
				}
			}
				
		});
		
		//익명타입 - 1회성 - 인터페이스 직접 구현 (구현하지 않고)
		//사용하지 않는 추상함수도 구현하고 있다.....
		this.addWindowListener(new WindowAdapter() { //일반클래스
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
			
		});
		
		/*
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
	}
}

public class Ex15_Button_Event_InnerClass {
	public static void main(String[] args) {
		LoginForm3 login = new LoginForm3("Login");
	}
}
