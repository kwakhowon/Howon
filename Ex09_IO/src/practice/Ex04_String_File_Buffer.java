package practice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_String_File_Buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
				fos = new FileOutputStream("data1.txt");
				bos = new BufferedOutputStream(fos);
				
				for(int i=0; i<10; i++) {
					bos.write('A');
				}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
