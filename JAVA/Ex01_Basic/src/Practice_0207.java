import java.util.Scanner;

//경품 추첨
//1000점일 경우 : TV , 노트북 , 냉장고 , 수건 , 휴지
//900점 : 노트북 , 냉장고 , 수건 , 휴지
//800점 : 냉장고 , 수건 , 휴지 
//700점 : 수건 , 휴지
//600점 : 휴지
//이외에 칫솔
public class Practice_0207 {
	public static void main(String[] args) {
//		int score = (int) ((Math.random()*10)+1)*100;
//		String present = "";
//		
//		switch (score) {
//		case 1000 :
//			present += "TV ";
//		case 900 :
//			present += "NoteBook ";
//		case 800 :
//			present+= "냉장고 ";
//		case 700 :
//			present += "수건 ";
//		case 600 :
//			present += "휴지 ";
//
//		default:
//			present += "칫솔";
//			break;
//		}
//		System.out.println("뽑은 점수 : " +score);
//		System.out.println("당첨된 경품 : " +present);

//		Scanner sc = new Scanner(System.in);
//		int su = 0;
//		int su2 = 0;
//		String calc = "";
//		System.out.print("첫번째 수를 입력하세요. ");
//		su = Integer.parseInt(sc.nextLine());
//		System.out.print("연산자를 입력하세요.(+ - * /) ");
//		calc = sc.nextLine();
//		System.out.print("두번째 수 입력하세요. ");
//		su2 = Integer.parseInt(sc.nextLine());
//		
//		if(calc.equals("+")) {
//			System.out.println(su+su2);
//		}else if(calc.equals("-")) {
//			System.out.println(su-su2);
//		}else if(calc.equals("*")) {
//			System.out.println(su*su2);
//		}else if(calc.equals("/")) {
//			System.out.println(su/su2);
//		}else
//			System.out.println("지원하지 않는 연산자입니다.");
		
		int score = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 점수를 입력해 주세요. ");
		score = Integer.parseInt(sc.nextLine());
		System.out.println("입력한 점수 : " +score);
		switch(score/10) {
		case 10  :
		case 9 :
			System.out.println("당신의 학점은 A입니다.");
			break;
		case 8 :
			System.out.println("당신의 학점은 B입니다.");
			break;
		case 7 :
			System.out.println("당신의 학점은 C입니다.");
			break;
		default :
			System.out.println("당신의 학점은 D입니다.");
		}
		
	}

}
