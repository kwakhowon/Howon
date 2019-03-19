import java.io.File;

public class Ex08_File_Directory {
	public static void main(String[] args) {
		// System.out.println(args.length);
		// System.out.println(args[0]);
		// System.out.println(args[1]);
		if (args.length != 1) {
			System.out.println("사용법 : java 파일명 [디렉토리명]");
			System.exit(0);
		}
		// java Ex08_File_Directory C:\\kkkk (O)
		// java Ex08_File_Directory (x) 강제종료

		File f = new File(args[0]);
		if (!f.exists() || !f.isDirectory()) {
			// 존재하지 않거나 디렉토리가 아니라면
			System.out.println("유효하지 않은 경로야");
			System.exit(0);

		}
		// 이제서야 분석
		// POINT
		File[] files = f.listFiles(); // File 타입 배열 주소값 return
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			System.out.println(files[i].isDirectory() ? "DIR-" + name : "FILE" + name);

		}
	}
}
