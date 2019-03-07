import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;

//DataOutputStream write 한 데이터는 반드시 DataInputStream read 해야 한다.
public class Ex14_DataInputStream {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			while(true) {
				score = dis.readInt();
				System.out.println("score int 타입 : "+score);
				sum+= score;
			}
			
		}catch(Exception e) {
			System.out.println("예외 발생 : " +e.getMessage());
			System.out.println("sum 결과 : " +sum);
		}finally {
			try {
				dis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
