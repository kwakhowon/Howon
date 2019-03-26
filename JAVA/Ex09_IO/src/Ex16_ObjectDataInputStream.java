import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.or.bit.UserInfo;

//userData.txt에 직렬화된 내용을 read해서 >> 역직렬화 >> 다시 조립 >> 제품 확인
public class Ex16_ObjectDataInputStream {
	public static void main(String[] args) {
		String filename = "UserData.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis); //역직렬화 ....
			
			UserInfo r1 = (UserInfo)in.readObject(); //복원
			UserInfo r2 = (UserInfo)in.readObject(); //복원(역직렬화)
			System.out.println(r1.toString());
			System.out.println(r2.toString());
			
			//객체 단위 read .... 객체가 없다면 null 값 반환
			Object users = null;
			while((users = in.readObject()) !=null) {
				System.out.println(users.toString());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
