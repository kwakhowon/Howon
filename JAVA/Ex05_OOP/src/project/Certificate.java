package project;

import java.util.Scanner;

public class Certificate extends Paper {
	Student stduent;
	Student stu = new Student();
	private String[] certificate;
	private int[] certificatePrice;
	private int certificateNumber;
	static Scanner sc;
	static int key;
	Login login = new Login();
	

	public String[] getCertificate() {
		return certificate;
	}

	public void setCertificate(String[] certificate) {
		this.certificate = certificate;
	}

	public int[] getCertificatePrice() {
		return certificatePrice;
	}

	public void setCertificatePrice(int[] certificatePrice) {
		this.certificatePrice = certificatePrice;
	}

	public int getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(int certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	Certificate() { // 기본생성자
		certificate = new String[] { "재학증명서", "졸업증명서", "졸업예정증명서", "성적증명서", "휴학증명서" };
		certificatePrice = new int[] { 300, 1000, 500, 300, 0 };
	}

	private int price(int certificateNumber) {
		this.certificateNumber = certificateNumber;
		int price = (Integer.parseInt(certificate[certificateNumber])) * certificatePrice[certificateNumber];
		setPaperUse(getPaperUse() + 1);

		return price;
	}

	private void output_paper() {
		System.out.print("출력하고 싶은 매수를 선택하세요(1~5)");
		System.out.print(" (출력 가능 매수 : "+getPaperDefult()+") : ");
		Scanner sc = new Scanner(System.in);
		int output = sc.nextInt();
		switch (output) {
		case 1:
			System.out.println("1장을 출력합니다.");
			System.out.println("가격 : " +(output *certificatePrice[key-1]));
			certificate_enrollment();
			break;
		case 2:
			System.out.println("2장을 출력합니다.");
			System.out.println("가격 : " +(output *certificatePrice[key-1]));
			certificate_enrollment();
			break;
		case 3:
			System.out.println("3장을 출력합니다.");
			System.out.println("가격 : " +(output *certificatePrice[key-1]));
			certificate_enrollment();
			break;
		case 4:
			System.out.println("4장을 출력합니다.");
			System.out.println("가격 : " +(output *certificatePrice[key-1]));
			certificate_enrollment();
			break;
		case 5:
			System.out.println("5장을 출력합니다.");
			System.out.println("가격 : " +(output *certificatePrice[key-1]));
			certificate_enrollment();
			break;
		default:
			System.out.println("잘못된 선택입니다. 다시 입력해주세요");
			output_paper();
			break;
		}

	}

	private void certificate_enrollment() {
		System.out.println("──────────────────────────────────────────────");
		System.out.println("│                                     ");
		System.out.println("│                 재학증명서                       ");
		System.out.println("│          이름 : ");
		System.out.println("│          학번 : "  );
		System.out.println("│          학과 : "+stu.getMajor()+"                                  ");
		System.out.println("│                                            ");
		System.out.println("──────────────────────────────────────────────");
		
	}
	
	private void certificate_graduation() {
		System.out.println("──────────────────────────────────────────────");
		System.out.println("│                                     ");
		System.out.println("│                 졸업증명서                       ");
//		System.out.println("│          이름 : "+login.name);
//		System.out.println("│          학번 : "+login.stn  );
		System.out.println("│             위 학생을 졸업했음을 증명합니다.");
		System.out.println("│                                            ");
		System.out.println("──────────────────────────────────────────────");
		
	}
	
	private void certificate_graduation_pre() {
		System.out.println("──────────────────────────────────────────────");
		System.out.println("│                                     ");
		System.out.println("│                 졸업예정증명서                       ");
//		System.out.println("│          이름 : "+login.name);
//		System.out.println("│          학번 : "+login.stn  );
		System.out.println("│             위 학생을 졸업예정임을 증명합니다.");
		System.out.println("│                                            ");
		System.out.println("──────────────────────────────────────────────");
		
	}
	
	private void certificate_absence() {
		System.out.println("──────────────────────────────────────────────");
		System.out.println("│                                     ");
		System.out.println("│                 휴학증명서                    ");
//		System.out.println("│          이름 : "+login.name);
//		System.out.println("│          학번 : "+login.stn  );
		System.out.println("│             위 학생을 휴학중임을 증명합니다..");
		System.out.println("│                                            ");
		System.out.println("──────────────────────────────────────────────");
		
	}
	
	private void certificate_absence2() {
		System.out.println("──────────────────────────────────────────────");
		System.out.println("│                                     ");
		System.out.println("│                 휴학증명서                    ");
//		System.out.println("│          이름 : "+login.name);
//		System.out.println("│          학번 : "+login.stn  );
		System.out.println("│             위 학생을 휴학중임을 증명합니다..");
		System.out.println("│                                            ");
		System.out.println("──────────────────────────────────────────────");
		
	}
	
	public void Menu() {
		System.out.println("***********************************증명서 출력 메뉴***************************");
		System.out.print("0:종료 \t 1: 재학증명서\t" + "2:졸업증명서\t" + "3:졸업예정증명서\t" + "4:성적증명서\t" + "5:휴학증명서\t 6: 로그인 화면으로 돌아가기\n");
		System.out.print("당신의 선택 : ");
		Scanner sc = new Scanner(System.in);
		key = sc.nextInt();
		try {

			switch (key) {
			case 0:
				return;
			case 1:
				System.out.println("재학증명서가 선택되었습니다.");
				output_paper();
				payment();
				check_email();
				break;
			case 2:
				System.out.println("졸업예정증명서가 선택되었습니다");
				output_paper();
				payment();
				check_email();
				break;
			case 3:
				System.out.println("졸업증명서가 선택 되었습니다.");
				output_paper();
				payment();
				check_email();
				break;
			case 4:
				System.out.println("성적증명서가 선택되었습니다");
				output_paper();
				
				payment();
				check_email();
				break;
			case 5:
				System.out.println("휴학증명서가 선택되었습니다");
				output_paper();
				payment();
				check_email();
				break;
			case 6 :
				login.LoginMethod();
			default:
				System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
				Menu();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void payment() {
		System.out.print("결제 하시겠습니까???(y / n)");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		try {
		switch (choice) {
		case "y" :
		case "Y" :
			System.out.println("카드 결제중.....");
			Thread.sleep(2000);
			System.out.println("결제가 완료되었습니다.");
			break;
		case "n" :
		case "N" :
			System.out.println("결제가 실패되었습니다.");
			System.out.println("메뉴화면으로 돌아갑니다.");
			Menu();
		default:
			break;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void check_email() {
		System.out.println("Email로 받아 보시겠습니까??? (y , n)");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		try {
			switch (choice) {
			case "y" :
			case "Y" :
				System.out.print("Email을 입력하세요 : ");
				String email = sc.next();
				System.out.println(email + "으로 메일이 전송되었습니다.");
				
				Thread.sleep(2000);
				System.out.println("로그인 화면으로 돌아갑니다.\n");
				login.LoginMethod();
				Menu();
			case "n":
			case "N" :
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				check_email();
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}


}
