package com.bit.three;
import java.util.Arrays;
import java.util.Scanner;

public class Machine {
	private Boolean power;
	public static Certificate certificate;
	private String[] shoppingBaskel;
	static int sum;
	private int i; // 장바구니 카운터용
	private Email email;
	static Time time;
	static String startTime;
	static String currentTime;
	private int temp;
	
	static {
		sum = 0;
		certificate = new Certificate();
		time = new Time();
	}
	
	public Machine(){
//		this.login = new Login();
//		this.login = Login.getInstance();
		this.power= false;
		this.shoppingBaskel = new String[5];
		this.i = 0;
		this.email = new Email();
		this.temp = 0;
	}
	
	public void power(boolean power) {
		this.power = power;
		if(this.power==true) {
			
			startTime = time.currentDateTime();
			System.out.println("학생증명서 자판기 상태: On");
			System.out.println("자판기 작동 시작시간: "+ startTime +"\n\n");
			Login.loginDisplay();
			selectMenu();
		}else {
			time = new Time();
			currentTime = time.currentDateTime();
			System.out.println(time.diffDateTime(startTime, currentTime));
			System.out.println("학생증명서 자판기 상태: OFF\n\n");
			System.exit(1);
		}
			
	}
	
	public void selectMenu() {
		do {
			System.out.println();
			if(certificate.paperStatus() <= (int)(certificate.getPaperDefault()*0.2 ) && certificate.paperStatus() <=0) {
				System.out.println("	** 용지 부족(남은 용지 :" + certificate.paperStatus()  +"장) ** ");
				System.out.println("*** 관리자에게 문의 하세요 1588-3082 ***\n");
			}else if(certificate.paperStatus()<=0) {
				System.out.println("용지가 없어 사용할 수 없습니다.");
				Login.progressBar("자동 로그아웃");
				Login.loginDisplay();
			}
			System.out.println("    [출력 가능한 증명서 목록]\n");
			if(i != 0) {System.out.println("0. 장바구니 결제하기["+sum+"원]");}
			System.out.println("1. 재학 증명서");
			System.out.println("2. 졸업 증명서");
			System.out.println("3. 졸업예정 증명서");
			
			System.out.println("4. 성적 증명서");
			System.out.println("5. 휴학 증명서\n");
			System.out.println("6. 로그아웃");
//			System.out.println("7. 프로그램 종료하기\n");
			System.out.print("\n원하는 증명서를 선택하세요 : ");
			Scanner sc = new Scanner(System.in);
			String menu = sc.nextLine();
			System.out.println();
			switch(menu) {
			
			case "1": selectMenuSecond(menu); break;
			case "2": selectMenuSecond(menu); break;
			case "3": selectMenuSecond(menu); break;
			case "4": selectMenuSecond(menu); break;
			case "5": selectMenuSecond(menu); break;
			case "6": System.out.println("------------------------------\n");i=0;sum=0; Login.loginDisplay();break;
//			case "7": System.out.println("------------------------------\n"); power(false);break;
			case "0": if(sum!=0) {cardPayment(sum); selectMenuThird(menu);break;}
			default : System.out.println("\n메뉴 번호 중에 선택하세요.\n"); System.out.println("------------------------------"); break;
			}
			
		}while(true);
	}
	
	private void cardPayment(String MenuNumber) {
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("\n카드 결제금액은 " + certificate.payment(Integer.parseInt(MenuNumber)) +"원 입니다.");
		System.out.println("\n------------------------------");
		this.temp++;
//		sum =0;	
	}
	private void cardPayment(int sum) {
		if(Machine.sum !=0) {
			Machine.sum = sum;
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("\n장바구니에 있는 " + Arrays.toString(Arrays.copyOf(shoppingBaskel, i)) +"을 모두 결제합니다.");
			System.out.println("\n카드 결제금액은 " + Machine.sum +"원 입니다.\n");
			System.out.println("------------------------------");
		}else {
			System.out.println("장바구니가 비어있습니다.");
			selectMenu();
		}
	}
	
	private void ShoppingBasket(String MenuNumber) {
		if(i<=4) {
			shoppingBaskel[this.i++] = certificate.certificate[Integer.parseInt(MenuNumber)];
//			this.i++;

			sum+=certificate.certificatePrice[Integer.parseInt(MenuNumber)];
			System.out.println("------------------------------");
			System.out.println("\n장바구니에는 최대 5개의 증명서를 담을 수 있습니다.("+this.i+"/"+this.shoppingBaskel.length+")\n");
			System.out.println("로그아웃하면 장바구니 내역이 삭제됩니다.\n");
			System.out.println("장바구니 내역: "+Arrays.toString(Arrays.copyOf(shoppingBaskel, i)));
			System.out.println("\n예상 결제금액은 "+sum+"원입니다.\n");
			System.out.println("------------------------------");
			selectMenu();
		}else {
			System.out.println("------------------------------");
			System.out.println("\n장바구니에 더 이상 담을 수 없습니다.\n");
			System.out.println("------------------------------");
			selectMenu();
		}
		
	}
	
	
	private void printP(String MenuNumber) {
		if(temp!=1) {
			System.out.println("\n선택하신 " + Arrays.toString(Arrays.copyOf(shoppingBaskel, i)) + "가 출력되었습니다.\n");
			certificate.setPaperUse(i);
		}else {
			System.out.println("\n선택하신 [" + certificate.certificate[Integer.parseInt(MenuNumber)] + "]가 출력되었습니다.\n");
			certificate.setPaperUse(1);
		}
		System.out.println("------------------------------");
		System.out.println(certificate.paperStatus());		
	}
	
	private void emailTrans(String MenuNumber) {
			System.out.println();
			System.out.print("이메일 주소를 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			String emailAddress = sc.nextLine();
			if(email.validate(emailAddress) == true && shoppingBaskel[0]!=null && temp !=1) {
				System.out.println("\n------------------------------");
				System.out.print("\n선택하신 " + Arrays.toString(Arrays.copyOf(shoppingBaskel, i)) + "가 ");
				System.out.println("이메일로 전송되었습니다.\n");
				System.out.println("------------------------------");
				sum=0; i=0;
			}else if(email.validate(emailAddress) == true && shoppingBaskel[0]==null){
				System.out.println("\n------------------------------");
				System.out.print("\n선택하신 [" + certificate.certificate[Integer.parseInt(MenuNumber)] + "]가 ");
				System.out.println("이메일로 전송되었습니다.\n");
				System.out.println("------------------------------");
				sum=0; i=0;

			}else {
				System.out.println("이메일 주소가 옳지 않습니다.\n");
				System.out.println("------------------------------\n");
				String temp = MenuNumber;
				emailTrans(temp);
			}
	}
	// 여기 아래부터는 uml에 추가필요
	private void selectMenuSecond(String menuNumberFirst) {
		int temp=Integer.parseInt(menuNumberFirst);
		menuNumberFirst = String.valueOf(temp-1);
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("    [결제 메뉴]\n");
		System.out.println("1. 카드 결제["+certificate.certificatePrice[Integer.parseInt(menuNumberFirst)]+"원]");
		System.out.println("2. 장바구니에 담기("+this.i+"/"+this.shoppingBaskel.length+")\n");
		if(i!=0) {
		System.out.println("3. 장바구니 결제하기");
		}
		System.out.print("\n메뉴를 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		String menuNumber=sc.nextLine();
		do {
			switch(menuNumber) {
			case "1" : cardPayment(menuNumberFirst); selectMenuThird(menuNumberFirst);break;
			case "2" : ShoppingBasket(menuNumberFirst); break;
			case "3" : if(i<=0) {
				cardPayment(sum);selectMenuThird(menuNumberFirst);break;
			}
			default : System.out.println("\n올바른 값을 입력하세요.\n");
			System.out.println("------------------------------");
			}
		}while(false);
		
	}
	
	private void selectMenuThird(String menuNumberFirst) {
		System.out.println("------------------------------");
		System.out.println();
		System.out.println("    [출력 메뉴]\n");
		System.out.println("1. 이메일 전송");
		System.out.println("2. 종이 출력");
		System.out.print("\n메뉴를 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		String menuNumber=sc.nextLine();
		do {
			switch(menuNumber) {
			case "1" : emailTrans(menuNumberFirst);break;
			case "2" : 
				printP(menuNumberFirst);
				if(temp!=1) {
					sum=0;i=0;break;
				}else {
					temp=0;
					break;
				}
				
			default : System.out.println("올바른 값을 입력하세요.");
			}
		}while(false);
	}

	public Certificate getCertificate() {
		return certificate;
	}	
	
}