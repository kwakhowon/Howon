package swing;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;


public class Ex09_LayOut_Flow {

	public static void main(String[] args) {
		Frame f = new Frame("Flowlayout");
		f.setSize(800, 600);
		f.setLayout(new FlowLayout(FlowLayout.LEFT)); //정렬방식
		//버튼 10개 생성 Frame 에 add 해보세요
		Button[] btns = new Button[10];
		for(int i = 0 ; i < btns.length ; i++){
			btns[i] = new Button("btn-" + i);
			f.add(btns[i]);
		}
		
		f.setVisible(true);
	
	}

}
