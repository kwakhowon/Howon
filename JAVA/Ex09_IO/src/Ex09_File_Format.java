import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		//Format 클래스 (형식)
		/*
		//화폐단위처리
		DecimalFormat df = new DecimalFormat("#,###.0"); //"#.###.0" 별도의 표로 제공
		String result = df.format(1234567.89);
		System.out.println(result);
		
		//날짜형식 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String strDate = sdf.format(new Date());
		System.out.println(strDate);
		
		//문자열형식 처리
		String message = "회원ID:{0} \n회원이름:{1} \n회원전화:{2}";
		String result2 = MessageFormat.format(message, "howon0206","홍길동","010....");
		System.out.println(result2);
		*/
		File dir = new File("C:\\Program Files");
		File[] files = dir.listFiles(); //files배열에는 폴더와 파일 모두 ....
		
		for(int i=0; i<files.length; i++) {
			File file = files[i];
			
			String name = file.getName(); // name >> a.txt , name >> new
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			String attribute = "";
			String size = "";
			if(files[i].isDirectory()) {
				attribute ="<DIR>";
			}else { //나머지는 파일 (a.txt , copy.jpg ....)
				size = file.length() + "byte";
				attribute += file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s    %3s    %10s      %s \n", 
					df.format(new Date(file.lastModified()))
					,attribute
					,size
					,name);
		}
	}
}
