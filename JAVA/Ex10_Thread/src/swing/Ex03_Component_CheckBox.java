package swing;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

//Checkbox > Checkbox , radio 두가지역활 (그룹)
public class Ex03_Component_CheckBox {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(300, 200);
		f.setLayout(new FlowLayout()); //왼쪽 -> 오른쪽 순서대로 배치
		
		Label q1 = new Label("선택하세요");
		Checkbox news = new Checkbox("news", true);
		Checkbox music = new Checkbox("music");
		Checkbox game = new Checkbox("game");
		f.add(q1);
		f.add(news);
		f.add(music);
		f.add(game);
		
		Label q2 = new Label("단일선택");
		CheckboxGroup group = new CheckboxGroup(); //그룹안에서 단일선택
		Checkbox M = new Checkbox("남",true,group);
		Checkbox G = new Checkbox("여",false,group);
		
		
		f.add(q2);
		f.add(M);
		f.add(G);
		
		
		f.setVisible(true);
		
		

	}

}
