package practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex05_Reader_Writer_Kor {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			fw = new FileWriter("copy2_Ex02.txt");
			
			int data = 0;
			while((data = fr.read())!= -1) {
				if(data != '\n' && data != '\r'& data !='\t' && data !=' ')
					fw.write(data);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				fw.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
