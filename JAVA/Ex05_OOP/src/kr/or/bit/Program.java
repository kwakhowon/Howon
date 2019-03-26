package kr.or.bit;

public class Program {
	public static void main(String[] args) {
		Pclass pc = new Pclass();
		System.out.println("default : " +pc.d);
		System.out.println("public : " +pc.j);
		System.out.println("protected : " +pc.p); //같은 폴더에서는 default
	}
}
