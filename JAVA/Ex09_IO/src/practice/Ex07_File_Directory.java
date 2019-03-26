package practice;

import java.io.File;

public class Ex07_File_Directory {

	public static void main(String[] args) {
		String path = "C:\\Temp\\file.txt";
		File f= new File(path);
		
		String filename = f.getName();
		System.out.println("파일명 : " +filename);
		System.out.println("전체경로 : " +f.getPath());
		System.out.println("절대경로 : " +f.getAbsolutePath());
		System.out.println("너 폴더니? :" +f.isDirectory());
		System.out.println("너 파일이니? : " +f.isFile());
		System.out.println("파일크기 : " +f.length()+"bytes");
		System.out.println("부모경로 : " +f.getParent());
		System.out.println("파일 존재 여부 : "+f.exists());
		f.canExecute();
	}
}
