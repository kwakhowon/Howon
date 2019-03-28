package practice_0328;

import java.util.Scanner;

/*
배열을이용하여 날짜를 기억시킨후
int []month={31,28,31,30,31,30,31,31,30,31,30,31};

원하는 달 : 3
3월은 31일입니다...
*/
public class Example20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []month = {31,28,31,30,31,30,31,31,30,31,30,31};
		System.out.println("원하는 달 :");
		int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(choice+"월은 "+month[0]+"입니다.");
				break;
			case 2:
				System.out.println(choice+"월은 "+month[1]+"입니다.");
				break;
			case 3:
				System.out.println(choice+"월은 "+month[2]+"입니다.");
				break;
			case 4:
				System.out.println(choice+"월은 "+month[3]+"입니다.");
				break;
			case 5:
				System.out.println(choice+"월은 "+month[4]+"입니다.");
				break;
			case 6:
				System.out.println(choice+"월은 "+month[5]+"입니다.");
				break;
			case 7:
				System.out.println(choice+"월은 "+month[6]+"입니다.");
				break;
			case 8:
				System.out.println(choice+"월은 "+month[7]+"입니다.");
				break;
			case 9:
				System.out.println(choice+"월은 "+month[8]+"입니다.");
				break;
			case 10:
				System.out.println(choice+"월은 "+month[9]+"입니다.");
				break;
			case 11:
				System.out.println(choice+"월은 "+month[10]+"입니다.");
				break;
			case 12:
				System.out.println(choice+"월은 "+month[11]+"입니다.");
				break;

			default:
				break;
			}
	}
}
