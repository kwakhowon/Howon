package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
//import java.awt.*;
import javax.swing.JPanel;

public class Ex15_Swing_Panel_LayOut extends JFrame {
	JButton btn1 = new JButton("WestButton");
	JButton btn2 = new JButton("CenterButton");
	
	JPanel jpn = new JPanel();
	JButton btn3 = new JButton("File");
	JButton btn4 = new JButton("HELP");
	
	public Ex15_Swing_Panel_LayOut(){
		super("SWING");
		
		//Jpanel 안에 
		jpn.add(btn3);
		jpn.add(btn4);
		
		//JFrame
		this.add(jpn,"North");
		this.add(btn1,"West");
		this.add(btn2,"Center");
		
		this.setSize(400, 300);
		this.setVisible(true);
		
		//종료(dispose())
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Ex15_Swing_Panel_LayOut();

	}

}
