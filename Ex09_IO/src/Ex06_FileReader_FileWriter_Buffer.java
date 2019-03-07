import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex06_FileReader_FileWriter_Buffer {
	public static void main(String[] args) {
		/*
		try {
			FileWriter fw = new FileWriter("today.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("로또");
			bw.newLine(); // 개행 \n\r (Enter)
			bw.write("1,2,3,4,5");
			bw.flush(); //bw.close()
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		FileReader fr = null;
		BufferedReader br = null;
				
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);
			
			String line="";
			//br.readLine(); 엔터를 기준으로 한줄씩 read POINT
			for(int i=0; (line = br.readLine()) != null; i++) {
				//System.out.println(line);
				// ; 포함된 문장만 read 하고 싶어요
				if(line.indexOf(";") != -1) {
					System.out.println(line);
				}
			}
					
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
}
