package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex06_FileReader_FileWriter_Buffer {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);

			String line = "";

			for (int i = 0; (line = br.readLine()) != null; i++) {
				if (line.indexOf(";") != -1) {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
