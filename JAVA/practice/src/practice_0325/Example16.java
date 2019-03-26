package practice_0325;
/*
 26. 메서드 

main()함수에서 output(10,'#')을 호출하여 함수에서 처리하고 
제어권만 되돌아옴(for문이용)

<결과>
# # # # # # # # # # 
 */
public class Example16 {
	public static void main(String[] args) {
		Example16 exam16 = new Example16();
		exam16.output(10, '#');
	}
	public void output(int a, char b) {
		for(int i=0; i<a; i++) {
			System.out.print(b+" ");
		}
	}
}
