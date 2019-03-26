package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex_02_Point_File_Read_Write {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String path = "C:\\Temp\\c.txt";
		
		try {
			fis = new FileInputStream(path);
			fos = new FileOutputStream("C:\\Temp\\new.txt");
			int data = 0;
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
