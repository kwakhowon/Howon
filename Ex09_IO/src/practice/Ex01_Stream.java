package practice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex01_Stream {
	public static void main(String[] args) {
		byte[] insrc = {0,1,2,3,4,5,6,7,8,9};
		
		byte[] outsrc = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		input = new ByteArrayInputStream(insrc);
		
		output = new ByteArrayOutputStream();
		System.out.println("before output : " +Arrays.toString(outsrc));
		
		int data = 0;
		while((data = input.read()) != -1) {
			System.out.println("data : "+data);
			output.write(data);
		}
		
		outsrc = output.toByteArray();
		System.out.println(Arrays.toString(outsrc));
	}
}
