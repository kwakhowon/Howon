import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
컴퓨터 가장 느린 작업(I/O 파일 read , write : Disk)
1. File 작업(Disk) >> read , write >> byte 단위
문제 해결
//Buffer 메모리(쌓아두고 한번에) 한번에 ...

2. 고민하지만 그냥 buffer 써 ....

3. File I/O 성능개선
4. Line 단위 처리(엔터 기반....)

5. JAVA API
//보조스트림  : 독자적으로 new를 할 수 없다. (parameter 강제)
BufferedInputStream buffer = new BufferedInputStream();
default 생성자를 구현하지 않다 ...... overloading 만 구현
 BufferedOutputStream 
 
BufferedInputStream(InputStream in) > InputStream을 상속 구현한 객체의 주소 
 
*/
public class Ex04_String_File_Buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream("data.txt"); // 파일 생성기능
			bos = new BufferedOutputStream(fos);

			for (int i = 0; i < 10; i++) {
				bos.write('A');
			}
			/*
			 * 궁금한점 buffer 도대체 언제 파일에 write 합니까 java buffer : 8Kbyte - 8192byte 1.buffer는 안에
			 * 내용이 채워지면 자동으로 비운다(꽉차면) 2.buffer 강제로 비우는 방법 : flush() 강제 .... 3.bos.close() :
			 * 내부적으로 flush() 호출
			 */
			// bos.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bos.close(); // flush() 호출한 다음 자원해제
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
