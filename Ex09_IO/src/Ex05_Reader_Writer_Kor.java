import java.io.FileReader;
import java.io.FileWriter;

//문제점
//1. 한글 1자  >> 2byte >> stream(1Byte) 통로 >> 한글이 통과 불가
//2. 통로 하나 더 만들어 줄게 >> 2byte 통로 >>reader , writer
public class Ex05_Reader_Writer_Kor {
	public static void main(String[] args) {
		//File reader , writer
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			fw = new FileWriter("copy_Ex02.txt");
			
			int data = 0;
			while((data = fr.read())!= -1) {
				//System.out.println(data + " : " +(char)data);
				//fw.write(data);
				//요구사항 : 공백 , 엔터 , tap 은 제거하고 파일을 쓰세요
				if(data != '\n' && data !='\r' && data !='\t' && data != ' ' ) {
					fw.write(data);
				}
				
			}
		}catch(Exception e) {
			
		}finally {
			try {
			fw.close();
			fr.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
