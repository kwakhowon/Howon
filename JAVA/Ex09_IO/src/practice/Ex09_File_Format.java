package practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		File dir = new File("C:\\Program Files");
		File[] files = dir.listFiles();
		
		for(int i=0; i<files.length; i++) {
			File file = files[i];
			
			String name = file.getName();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			String attribute = "";
			String size = "";
			if(files[i].isDirectory()) {
				attribute = "<DIR>";
			}else {
				size = file.length() + "bytes";
				attribute += file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s     %3s     %10s       %s \n", df.format(new Date(file.lastModified())),attribute,size,name);
		}
	}
}
