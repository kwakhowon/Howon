package kr.or.bit;

public class Apt {
	public String aptName;
	//int door; //default 바보 >> 클래스는 public인데 다른 package에서 사용할 수 없다.
	private int window; // 캡슐화 , 은닉화
	
	//간접할당
	//직접할당을 막고 간접할당을 통한 데이터 보호
	public void write_window(int w) { //캡슐화된 자원에 write 함수
		if(w == 0) {
			window = 100;
		}else {
			window = w;
		}
		window = w;
		System.out.println("!1111");
	}
	public int read_window() { //캡슐화된 자원에 read 함수
		return window;
	}
	
}
