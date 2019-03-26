
import java.io.File;

public class Dos2 {
	public static void main(String[] args) {
		if (args.length != 3 && args.length != 4) {
			System.out.println("사용법 : [java파일명] [디렉토리경로] mkdir [생성디렉토리명]");
			System.out.println("사용법 : [java파일명] [디렉토리경로] rename [파일명] [새로운 파일명]");
			System.out.println("사용법 : [java파일명] [디렉토리경로] delete [파일명]");
			System.exit(0);
		}
		File f = new File(args[0]);
		
		if (!f.exists() || !f.isDirectory()) { // 존재하지 않거나 디렉토리 아니라면
			System.out.println("유효하지 않은 디렉토리입니다");
			System.exit(0);
		}
		else if(args[1].equals("rename")) {
			String oldpath = f+"\\" +args[2];
			String newpath = f+"\\" +args[2];
			File oldFile = new File(oldpath);
			File newFile = new File(newpath);
			if(newFile.exists()) {
				System.out.println("존재하지 않는 파일입니다.");
			}else {
				oldFile.renameTo(newFile);
			}
		}
		else if(args[1].equals("del")) {
			String oldpath = f+"\\" +args[2];
			File oldFile = new File(oldpath);
			if(!oldFile.exists()){
				System.out.println("존재하지 않은 파일입니다.");
			}else {
				oldFile.delete();
			}
		}
		else if(args[1].equals("mkdir")) {
			String newpath = f+"\\"+args[2];
			File newFile = new File(newpath);
			if(newFile.exists()) {
				System.out.println("이미 존재하는 파일입니다.");
			}else {
				newFile.mkdir();
				System.out.println("[" +args[2]+"] 폴더가 생성되었습니다.");
			}
		}
	}
}
