package swing;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;


public class Ex07_MenuComponent {

	public static void main(String[] args) {
		Frame f = new Frame("Frame with menu");
		f.setSize(500, 400);
		
	MenuBar mb = new MenuBar();
			Menu mFile = new Menu("File");
				MenuItem miNew = new MenuItem("New");
				MenuItem miOpen = new MenuItem("Open");
				Menu mOthers = new Menu("Others");
					MenuItem miPrint = new MenuItem("Print");
					MenuItem miPrintpriview = new MenuItem("PrintPriview");
				MenuItem miExit = new MenuItem("Exit");
			Menu mEdit = new Menu("Edit");
			Menu mView = new Menu("View");
			Menu mInfo = new Menu("Info");
				
		//add 연결고리
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(mOthers); //Menu 추가 
			mOthers.add(miPrint);
			mOthers.add(miPrintpriview);
		mFile.addSeparator(); //----------------------------
		mFile.add(miExit);

		mb.add(mFile); //bar에 추가 (File Menu)
		mb.add(mEdit);
		mb.add(mView);
		mb.add(mInfo);
		f.setMenuBar(mb); //Frame에서 bar 추가
		f.setVisible(true);
	}

}
