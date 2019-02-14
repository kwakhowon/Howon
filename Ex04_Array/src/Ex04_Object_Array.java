import java.util.Arrays;

//배열을 만들 수 있는 타입
//8가지 기본 타입 + String , 사용자 정의 클래스(Type) , Interface , Collection
//

class Person{
	String name;
	int age;
	
}

public class Ex04_Object_Array {
	public static void main(String[] args) {
		int [] intarr = new int [10];
		boolean[] booarr = new boolean[5];
		System.out.println(Arrays.toString(booarr));
		
		//클래스는 타입이다.
		Person[] objarr = new Person[3];
		System.out.println(Arrays.toString(objarr));
		//참조 타입 배열은 방을 만들고 각각 방에 객체를 넣어주는 작업
		
		objarr[0] = new Person();
		objarr[1] = new Person();
		objarr[2] = new Person();
		
		System.out.println(Arrays.toString(objarr));
		//객체배열 : 1. 방만들기, 2. 방 객체 주소넣기
		objarr[0].name = "홍길동";
		objarr[0].age = 100;
		System.out.println(objarr[0].name);
		System.out.println(objarr[0].age);
		
		System.out.println("배열 : " +objarr);
		
		for(int i = 0; i<objarr.length; i++) {
			System.out.println(objarr[i].name +"/" +objarr[i].age);
		}
		
		Person[] parray = new Person[5];
		for(int i =0; i<parray.length; i++) {
			parray[i] = new Person();
			System.out.println("주소값 : " +parray[i]);
		}
		
		//2. int[] arr = new int[]{10,20,30};
		Person[] array2 = new Person[] {new Person() , new Person() , new Person()};
		
		//3.int[] arr = {10,20,30};
		Person[] array3 = {new Person() , new Person() , new Person()};
	}
}
