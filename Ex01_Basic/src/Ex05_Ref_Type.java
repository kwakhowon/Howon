//클래스는 설계도이다 , 클래스는 타입이다.
//클래스  == 설계도 == 타입
//클래스는 반드시 메모리에 올려야 사용할 수 있다.(설계도 기반으로 땅에 아파트를 지어야 아파트이다.)
//new 통해서 설계도를 기반으로 구체화된 산물(객체)을 만든다.

//설계도(속성(상태정보) + 행위(기능))
class Apt2{
	int door; //instance variable (객체 변수) : 초기화를 안해도 된다. >> 아파트의 층수는 다 다르게 지을 수 있기 때문에 굳이 초기화해줄 필요가 없다.
	int window;
}

public class Ex05_Ref_Type {
	public static void main(String[] args) {
		int i = 100; //i 는 100이라는 값을 갖는다
		//Apt2 타입(사용자 정의 타입 : 여러개의 타입을 모아 넣은 큰 타입)
		Apt2 lg = new Apt2(); //lg 변수는 Apt2 객체의 주솟값을 갖는다.
		//lg : 주소값을 가지는 변수 : 참조변수 , 객체변수
		System.out.println("lg 변수의 값은 주소 : " +lg);
		
		Apt2 ssapt = lg; //lg가 가지는 주소를 ssapt에게 전달
		//ssapt 녀석과 lg 녀석은 같은 집에 ....
		System.out.println(ssapt == lg); //true
		//참조변수의 할당은 주소값 할당
		ssapt.window = 50;
		
		System.out.println(lg.window);
		
	}

}
