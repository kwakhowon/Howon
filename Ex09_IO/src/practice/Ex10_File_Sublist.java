package practice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_Sublist {
	static int totalFiles=0; //객체간 공유자원 아니고 static 변수 역할
	static int totaldirs=0;
	
	public static void main(String[] args) {
		if(args.length !=1) {
			System.out.println("사용법 : java [파일명] [경로명]");
			System.out.println("예시 : java Ex10_File_Sublist C:\\Temp" );
			System.exit(0); //프로세스 종료
		}
		
		File f = new File(args[0]); //args[0] > C:\\Temp
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		printFileList(f);
		System.out.println("총 파일 수 : " +totalFiles);
		System.out.println("총 폴더 수 : " +totaldirs);
	}
	static void printFileList(File dir) {
		System.out.println("[Full Path : " +dir.getAbsolutePath() +"]");
		
		List<Integer> subDir = new ArrayList<Integer>();
		File[] files = dir.listFiles();
		
		for(int i=0; i<files.length; i++) {
			String filename = files[i].getName();
			if(files[i].isDirectory()) {
				filename = "<DIR> [" +filename +"]";
				subDir.add(i);
			}else {
				filename = filename+"/" +files[i].length() + "bytes";
			}
			System.out.println(" " +filename);
		}
		int dirnum = subDir.size();
		int filenum = files.length - dirnum;
		
		totaldirs += dirnum;
		totalFiles += filenum;
		
		System.out.println("[Current dirnum]" +dirnum);
		System.out.println("[Current filenum]" +filenum);
		System.out.println("***************************");
		
		for(int j=0; j< subDir.size(); j++) {
			int index = subDir.size();
			printFileList(files[index]); //재귀
		}
	}
}
