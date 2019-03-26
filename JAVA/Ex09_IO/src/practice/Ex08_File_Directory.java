package practice;

import java.io.File;

public class Ex08_File_Directory {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java 파일명 [디렉토리명]");
			System.exit(0);
		}
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 경로야");
			System.exit(0);
		}
		
		File[] files = f.listFiles();
		for(int i=0; i<files.length; i++) {
			String name = files[i].getName();
			System.out.println(files[i].exists() ? "DIR-"+name : "FILE" +name);
		}
	}
}
