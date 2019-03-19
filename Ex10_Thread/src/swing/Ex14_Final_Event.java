package swing;

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



class LoginForm3 extends Frame{
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm3(String title){
		super(title);
		lbl_id = new Label("ID:",Label.RIGHT);
		lbl_pwd = new Label("PWD:",Label.RIGHT);
		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('#');
		btn_ok = new Button("login");
		
		
		this.setLayout(new FlowLayout());//순서대로
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		this.add(lbl_pwd);
		this.add(txt_pwd);
		this.add(btn_ok);
		
		//inner class > 익명 클래스
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txt_id.getText();
				String pwd = txt_pwd.getText();
				
				System.out.println(id + " / " + pwd);
				
				if(!id.equals("kglim")){
					System.out.println("유효하지 않은 ID");
					txt_id.requestFocus();
					txt_id.selectAll();
				}else if(!pwd.equals("1004")){
					System.out.println("유효하지 않은 PWD");
					txt_pwd.requestFocus();
					txt_pwd.selectAll();
				}else{
					System.out.println(txt_id.getText() + " 방가");
				}
				
			}
		});
		
		//만약에 WindowListener 인터페이스 모든 자원 강제구현
		//위 코드 개선 WindowAdapter 필요한 것만 재정의
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
			
		});
	}
}
public class Ex14_Final_Event {

	public static void main(String[] args) {
		LoginForm3 login = new LoginForm3("final");

	}

}
