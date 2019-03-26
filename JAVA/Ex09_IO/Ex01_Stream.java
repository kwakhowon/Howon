import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
I/O
1. stream(연결통로 , 입출력통로 , 중간매개체) ex) 빨대
2. stream(통로의 크기가 제한적 >> 입력 출력 크기 >> 1Byte >> Byte 단위 입출력

3. JAVA API 제공하는 입력 출력 클래스 공부

Stream(Byte) 

InputStream(read) , OutputStream(write)
두개의 추상클래스는 상속을 통한 재정의 목적(강제 구현)

대상 (memory)
ByteArrayInputStream 	:	ByteArrayOutputStream

대상(file : a.txt)
FileInputStram			:	FileOutputStream

추가적으로(pipe(process) .....)
PipedInputStream		:	PipedOutputStream

도움을 주는 클래스 (성능)
Buffer (I/O) 성능향상
BufferedInputStream , BufferedOutputStream


*/
public class Ex01_Stream {
	public static void main(String[] args) {
		// Memory(Array , Collection)
		// Byte(-128 ~ 127) 정수값

		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(inSrc[5]);

		byte[] outSrc = null;

		ByteArrayInputStream input = null; // 데이터 통로를 통해서 read()
		ByteArrayOutputStream output = null; // 데이터 통로를 통해서 write()
		input = new ByteArrayInputStream(inSrc);
		// inSrc 배열주소에서 read()

		output = new ByteArrayOutputStream(); // write 대상(memory)

		System.out.println("before output : " + Arrays.toString(outSrc));

		// 공식같은 로직(암기)
		int data = 0;
		while((data = input.read()) !=-1) { //배열의 값이 없다 -1
			System.out.println("data : " +data);
			
			output.write(data); //data 값을 자기자신(output)에게 write
			//write 대상 : ByteArrayInputStream rad() -> write
		}
		outSrc = output.toByteArray();
		//자신이 가지고 있는 값을 배열로 만들어서
		//outSrc 에서 주소값 할당
		System.out.println("outSrc : After >>" +Arrays.toString(outSrc) );
		
		
		
//		while(input.read() !=-1) {
//			System.out.println("data : " +input.read());
//		read() 함수는 내부적으로 next() 기능을 가지고 있다.	
//		}

	}
}
