package swing;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;


//창 (Dialog)
//모달창     :띄워진 창을 닫아야 작업 가능
//모랄리스창 :띄워진 창에 관계없이 다른 작업 가능

public class Ex06_Component_Dialog {

	public static void main(String[] args) {
		/*Frame f = new Frame("부모창");
		f.setSize(400, 300);
		
		//Dialog info = new Dialog(f, "information",true); //true(모달), false(모달리스) 
		Dialog info = new Dialog(f, "information",false); //true(모달), false(모달리스) 
		info.setSize(150, 100);
		info.setLocation(50, 50);
		info.setLayout(new FlowLayout());
		
		//팝업창 component 추가
		Label msg = new Label("this is popup");
		Button btn = new Button("버튼");
		info.add(msg);
		info.add(btn);
		
		
		f.setVisible(true);
		info.setVisible(true);
		*/
		
		
		Frame f = new Frame("부모창");
		f.setSize(400, 300);
		f.setVisible(true);
		FileDialog fileOpen = new FileDialog(f,"my file open",FileDialog.LOAD);
		fileOpen.setDirectory("C:\\Temp");
		fileOpen.setVisible(true);
		
		System.out.println(fileOpen.getDirectory());
		System.out.println(fileOpen.getFile());
		
		
		
		
	}

}
