package practice;

public class Pracetice2_0210 {
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<5-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=5; i>0; i--) {
			for(int j=1; j<=6-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
