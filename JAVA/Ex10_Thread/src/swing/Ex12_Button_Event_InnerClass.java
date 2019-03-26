package swing;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//버튼을 클릭시 이벤트 처리
//인터페이스 검색 (ActionListener)
//Handler class 
class Btn_Handler implements ActionListener{

	//actionPerformed 는 버튼 클릭시 호출되는 함수 
	//Btn_Handler > TextField Add > Enter
	//Btn_Handler > Button Add    > Click 
	
	private TextField txtid;
	private TextField txtpwd;
	
	public Btn_Handler(TextField txtid , TextField txtpwd){
		this.txtid = txtid;
		this.txtpwd = txtpwd;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//txt_id 입력된값 가지고 오기
		//txt_pwd  입력된값 가지고 오기
		//System.out.println("버튼 클릭");
		//System.out.println(txtid.getText() + "/ " + txtpwd.getText());
		
		if(txtid.getText().equals("kglim")){
			System.out.println("방가 " + " / " + txtpwd.getText() );
		}else{
			System.out.println("졸고있는 너는 누구냐 ^^");
		}
		
	}
	
}


class LoginForm extends Frame{
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm(String title){
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
		
		//이벤트 처리
		this.btn_ok.addActionListener(new Btn_Handler(txt_id, txt_pwd));
		
	}
	
}

public class Ex12_Button_Event_InnerClass {

	public static void main(String[] args) {
		LoginForm loginform = new LoginForm("login");

	}

}
