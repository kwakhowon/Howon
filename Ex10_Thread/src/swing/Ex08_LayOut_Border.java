package swing;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;


public class Ex08_LayOut_Border {

	public static void main(String[] args) {
		Frame f = new Frame("Boarderlayout");
		f.setSize(500, 400);
		f.setLayout(new BorderLayout());
		//영역을 5가지 (동서남북 가운데)
		Button n = new Button("N");
		Button s = new Button("S");
		Button e = new Button("E");
		Button w = new Button("W");
		Button c = new Button("C");
		
		f.add(n,"North");
		//f.add(s,"South");
		//f.add(e,"East");
		//f.add(w,"West");
		f.add(c,"Center");
		
		f.setVisible(true);
		
	}

}
