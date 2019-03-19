package swing;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;


public class Ex04_TextArea {

	public static void main(String[] args) {
		Frame f = new Frame("TextArea");
		f.setSize(400, 300);
		f.setBackground(Color.pink);
		f.setLayout(new FlowLayout());
		
		TextArea comments = new TextArea("글을 쓰세요",10,50);
		comments.selectAll();
		f.add(comments);
		f.setVisible(true);
	}

}
