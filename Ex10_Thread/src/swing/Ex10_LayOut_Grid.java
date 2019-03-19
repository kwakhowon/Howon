package swing;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;


public class Ex10_LayOut_Grid {

	public static void main(String[] args) {
		//Grid (행과열을 가지고 LayOut 설정)
		Frame f = new Frame();
		f.setSize(300, 200);
		f.setLayout(new GridLayout(3, 2));
		
		f.add(new Button("1")); //(0,0)
		f.add(new Button("2")); //(0,1)
		
		f.add(new Button("3")); //(1,0) 
		f.add(new Button("4")); //(1,1)
		
		f.add(new Button("5")); //(2,0)
		f.add(new Button("6")); //(2,1)
		
		f.setVisible(true);
		
	}

}
