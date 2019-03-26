
class Car{
	int door;
	String color;
	
}

public class Ex06_Array {
	public static void main(String[] args) {
		//2차원 배열(행과 열) : index = 0
		//[행][열]
		int[][] score = new int[3][2];
		System.out.println(score[0][0]);
		System.out.println(score[2][1]);
		//System.out.println(score[2][2]);
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		System.out.println(score.length); // 행의 개수
		System.out.println(score[0].length); //열의 개수
		//행의 개수 : 배열이름.length > score.length
		//열의 개수 : 배열이름[i].length; > score[0].length
		
		for(int i =0; i< score.length; i++) {
			for(int j = 0; j<score[i].length; j++) {
				System.out.printf("score[%d][%d]=[%d]"+"\n",i,j,score[i][j]);
			}
			System.out.println();
		}
		
		//Today Point (Array(정적) >> Collection(동적)
		//개선된 for문
		//C# : for(Type 변수명 in 배열){ 출력구문 }
		//java : for(Type 변수명 : 배열){ 출력구문 }
		//javascript : for(Type 변수명 in 배열){ 출력구문 }
		
		int[] arr3 = {5,6,7,8,9,10};
		//for(int i = 0; i<arr3.length; i++) {
		//	System.out.println(arr[i]);
		//}
		for(int value : arr3) {
			System.out.println(value);
		}
		
		String[] strarr = {"A","B","C","D","E","FFF"};
		for(String value : strarr) {
			System.out.println(value);
		}
		
		//센스 퀴즈
		//1차 (커피:4000)
		int[][] score3 = new int[][] {
			                         {11,12},
			                         {13,14},
			                         {15,16}
		                           };
		//개선된 for문을 사용해서 값 출력
		for(int[] rows : score3) {
			for(int value : rows)
			System.out.println(value);
		}
		
		//객체 배열
		Car[] cararr = new Car[2];
		cararr[0] = new Car();
		cararr[0].color = "red";
		cararr[0].door = 4;
		
		cararr[1] = new Car();
		cararr[1].color = "blue";
		cararr[1].door = 2;
		
		//일반 for문을 사용해서 자동차의 색상과 문의 개수 출력
		for(int i = 0; i <cararr.length; i++) {
			System.out.print(cararr[i].color+"\t");
			System.out.println(cararr[i].door);
		}
		for(Car obj: cararr) {
			System.out.print(obj.color+"\t");
			System.out.println(obj.door);
		}
	}
}
