package swing;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;


public class Ex05_Component_Canvas {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(400, 300);
		f.setLayout(null);
		
		Canvas c = new Canvas();
		c.setBackground(Color.ORANGE);
		c.setBounds(50, 60, 200, 50); //왼쪽, 위 , 넓이 , 높이
		
		f.add(c);
		f.setVisible(true);
		

	}

}
