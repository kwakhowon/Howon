import kr.or.bit.Singleton;

public class Ex15_Singleton_main {
	public static void main(String[] args) {
		Singleton single = Singleton.getInstance(); 
		Singleton single2 = Singleton.getInstance(); 
		Singleton single3 = Singleton.getInstance(); 
		Singleton single4 = Singleton.getInstance(); 
		Singleton single5 = Singleton.getInstance();
		
		System.out.println(single + " , " +single2 + " , " +single3);
		System.out.println(single = single2 = single3);
	}
}
