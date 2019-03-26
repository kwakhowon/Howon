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
		//이 시점 (폴더라고 판단되는 시점)
		printFileList(f);
		System.out.println("총 파일 수 : " +totalFiles);
		System.out.println("총 폴더 수  : " +totaldirs);
	}
	
	static void printFileList(File dir) {
		System.out.println("[Full Path : " +dir.getAbsolutePath() + "]");
		
		//질문 1 Collection 사용 이유 
		List<Integer> subDir = new ArrayList<Integer>();
		File[] files = dir.listFiles(); //C:Temp 입력했다면 하위 자원을 배열로....
		
		//C:\\Temp	[0] a.txt
		//			[1] New
		//			[2] c.jpg  이런 정보를 File[]에 담아서 관리
		for(int i=0; i<files.length; i++) {
			String filename = files[i].getName(); //폴더명 , 파일명
			if(files[i].isDirectory()) {
				filename = "<DIR> [" +filename + "]";
				//POINT 질문 (add)의미
				subDir.add(i);
				//add 1
				//add 3
				
				//[0] 1 (NEW)
				//[1] 3 (OLD)
			}else {
				filename = filename+" / " +files[i].length() + "Byte";
			}
			System.out.println("  " +filename);
		}
		
		int dirnum = subDir.size();
		int filenum = files.length - dirnum;
		
		//누적값
		totaldirs += dirnum; //폴더에 대한 누적 개수
		totalFiles += filenum; //파일 누적 개수
		
		System.out.println("[Current dirnum] : " +dirnum);
		System.out.println("[Current filenum] :" +filenum);
		System.out.println("************************");
		
		//for문 해석
		for(int j=0; j< subDir.size(); j++) {
			int index = subDir.size();
			printFileList(files[index]); //재귀
		}
		
	}
}
