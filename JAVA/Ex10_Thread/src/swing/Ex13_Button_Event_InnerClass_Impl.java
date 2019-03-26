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




class LoginForm2 extends Frame{
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm2(String title){
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
		
		
		//Inner class
		class Btn_Handler implements ActionListener{
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
			
		}
		
		
		this.btn_ok.addActionListener(new Btn_Handler());
		
		//익명클래스 사용해서 window 창 닫기
		//인터페이스 직접 구현 (추상 클래스를 직접 구현하는 방식)
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
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				
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
	}
	
}

public class Ex13_Button_Event_InnerClass_Impl {

	public static void main(String[] args) {
		LoginForm2 login = new LoginForm2("innerclass");

	}

}
