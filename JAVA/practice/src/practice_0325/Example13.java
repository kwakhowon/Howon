package practice_0325;
/*
 13.  
    1~100사이의수 중에서  3의 배수이면서 7의 배수 구하기

     for(int i=1; i<=100; i++)
     {
              .
              .
           System.out.println(i + "   ");
     }
 */
public class Example13 {
	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			if(i%3 ==0 && i%7 ==0)
					System.out.println(i);
		}
	}
}
