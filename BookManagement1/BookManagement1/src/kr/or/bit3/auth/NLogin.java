package kr.or.bit3.auth;

import java.util.Scanner;

import kr.or.bit3.function.Book;
import kr.or.bit3.function.Crawling;
import kr.or.bit3.function.DataBaseExcel;

public class NLogin {
		public static Scanner sc;
		private static NAdmin admin; //관리자 접속 
		public static String userId; // 로그인 정보 저장용 
		private static DataBaseExcel databaseexcel;
		private static DataBaseExcel databaseexcel2;
		static { //공유자원 초기화
			sc = new Scanner(System.in);
			userId = "GUEST";
			databaseexcel = new DataBaseExcel();
			databaseexcel2 = new DataBaseExcel();
		}
		public NLogin(){
			admin = new NAdmin();

		}
		public void startApp() {
			databaseexcel.dataBase_ExcelCreate("RegisterDataBase"); //회원정보 폴더가 없을 경우 생성
			databaseexcel.synchronization("./DataBase/RegisterDataBase.xls"); //회원정보 동기화
			databaseexcel2.dataBase_ExcelCreate2("BookDataBase"); //검색 내역 폴더가 없을 경우 생성
			databaseexcel2.synchronization2("./DataBase/BookDataBase.xls"); // 검색내역 동기화
			Crawling.totalCount = Book.bookList.size(); // 스테틱 변수 크기 동기화
			loginDisplay();
		}
		
		
		public static void loginDisplay() {
			System.out.println("\n------------------------------\n");
			System.out.println("      [도서관리 프로그램]\n");
			System.out.println("1. 회원 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비밀번호 찾기");
			System.out.println("5. 비회원 로그인\n");
			System.out.print("메뉴를 선택하세요 : ");
			do {
				switch(sc.nextLine()) {
				case "1":
					login_CheckIdPwd(); //로그인(아이디 & 비밀번호)
					BookMenu.user_ShowMenu();
					break;
				case "2":
					addArr(); loginDisplay(); //회원가입 및 로그인 화면으로 돌아가기 
					break;
				case "3":
					login_FindId(); loginDisplay(); //아이디 찾기(이름 & 전화번호)
					break;
				case "4":
					login_FindPwd(); loginDisplay(); //비밀번호 찾기(아이디 & 전화번호)
					break;
				case "5":
					nonMember(); //비회원 로그인(조회만 가능)
					BookMenu.user_ShowMenu();
					break;
				case "admin": //어드민 계정 로그인 
					admin.MasterPassword();
					break; 
				default : System.out.println("\n\n [Error] 입력값을 확인하세요\n\n"); loginDisplay();
				}
			}while(false);
		}
		
		private static void nonMember() { //비회원 로그인 (테스트용) 
			userId = "GUEST"; // 유저아이디 초기화
			System.out.println("\n------------------------------\n");
			System.out.println("몇 초의 시간이 소요될 수 있습니다.\n");
			progressBar("게스트 로그인중",250);
				System.out.println("\n	** 게스트 로그인 완료 **");
			
		}
		private static void login_FindId() { //아이디 찾기 
			System.out.println("\n------------------------------\n");
			System.out.println("	[아이디 찾기]\n");
			System.out.print("이름을 입력하세요 : ");
			String userName = sc.nextLine();
			System.out.print("휴대폰 번호를 입력하세요 : ");
			String userPhone = sc.nextLine();
			System.out.println("\n------------------------------\n");
			progressBar("회원정보 확인중",250);
			progressBar("전원을 끄지 마세요.\n 몇 초의 시간이 소요될 수 있습니다.", 250);
			
			for (int i = 0; i < NUser.userArr.size(); i++) { // 이름 == 전화번호 
				if (NUser.userArr.get(i).getName().equals(userName) && NUser.userArr.get(i).getPhone().equals(userPhone)) {
					System.out.println("\n------------------------------\n");
					System.out.println("     * 회원정보 확인 성공! *\n");
					System.out.println(userName+"님의 아이디는 ["+NUser.userArr.get(i).getId() + "]입니다.");
					return;
				}
			}
			System.out.println("\n- 일치하는 회원 정보가 없습니다.");
			System.out.println("- 비회원이시라면, [회원가입]후 로그인 하세요.");
		}
		
		private static void login_FindPwd() { //비밀번호 찾기 
			System.out.println("\n------------------------------\n");
			System.out.println("	[비밀번호 찾기]\n");
			System.out.print("아이디을 입력하세요 : ");
			String userId = sc.nextLine();
			System.out.print("휴대폰 번호를 입력하세요 : ");
			String userPhone = sc.nextLine();
			System.out.println("\n------------------------------\n");
			progressBar("회원정보 확인중",250);
			progressBar("전원을 끄지 마세요.\n 몇 초의 시간이 소요될 수 있습니다.", 250);
			
			for (int i = 0; i < NUser.userArr.size(); i++) { // 아이디 == 전화번호 
				if (NUser.userArr.get(i).getId().equals(userId) && NUser.userArr.get(i).getPhone().equals(userPhone)) {
					System.out.println("\n------------------------------\n");
					System.out.println("     * 회원정보 확인 성공! *\n");
					System.out.println(NUser.userArr.get(i).getName()+"님의 비밀번호는 ["+NUser.userArr.get(i).getPwd() + "]입니다.");
					return;
				}
			}
			System.out.println("\n- 일치하는 회원 정보가 없습니다.");
			System.out.println("- 비회원이시라면, [회원가입]후 로그인 하세요.");
		}

		public static void progressBar(String comment) {
			try {
				System.out.print(" "+comment);
				Thread.sleep(500);
				for(int i=0; i<10; i++) {
					System.out.print(".");
					Thread.sleep(500);
				}
				System.out.println();
			}catch(Exception e) {
				System.out.println("[Error] 메시지를 확인하세요.");
				System.out.println(e);
			}
		}
		
		public static void progressBar(String comment, int sleeptime) {
			try {
				System.out.print(" "+comment);
				Thread.sleep(sleeptime);
				for(int i=0; i<10; i++) {
					System.out.print(".");
					Thread.sleep(sleeptime);
				}
				System.out.println();
			}catch(Exception e) {
				System.out.println("[Error] 메시지를 확인하세요.");
				System.out.println(e);
			}
		}

		private static void login_CheckIdPwd() {
			System.out.println("\n------------------------------\n");
			System.out.println("	[로그인]\n");
			System.out.print("아이디을 입력하세요 : ");
			userId = sc.nextLine(); //유저 아이디 저장용
			System.out.print("비밀번호를 입력하세요 : ");
			String userPw = sc.nextLine();
			System.out.println("\n------------------------------\n");
			progressBar("회원정보 확인중",250);
			progressBar("\n전원을 끄지 마세요\n몇 초의 시간이 소요될 수 있습니다.", 250);
			
			for (int i = 0; i < NUser.userArr.size(); i++) { // 아이디 == 비밀번호 
				if (NUser.userArr.get(i).getId().equals(userId) && NUser.userArr.get(i).getPwd().equals(userPw)) {
					System.out.println("\n------------------------------\n");
					System.out.println("\n * 로그인 성공! *");
					System.out.println("["+NUser.userArr.get(i).getName() + "]님 환영합니다.");
					return;
				}
			}
			System.out.println("\n- 일치하는 회원 정보가 없습니다.");
			System.out.println("- 비회원이시라면, [회원가입]후 로그인 하세요.");
			loginDisplay(); 	
		}
		private static Boolean IsID_DuplicateCheck(String id) {
			for(int i=0; i<NUser.userArr.size(); i++) {
				if(NUser.userArr.get(i).getId().equals(id)) {
					return false;
				}
			}return true;
		}
		
		private static Boolean IsPhone_DuplicateCheck(String phone) {
			for(int i=0; i<NUser.userArr.size(); i++) {
				if(NUser.userArr.get(i).getPhone().equals(phone)) {
					return true;
				}
			}return false;
		}
		
		private static String signUpName() {
			System.out.println("\n------------------------------\n");
			System.out.println("	[회원 가입 신청서]\n");
				do {
						System.out.print("* [이름] :");
						String name = sc.nextLine(); 
						if (name.matches("^[a-z|A-Z|가-힣\\s]+$")) { //최장수인 기준 1900년대분까지 계심
							System.out.print("=>"+name + " - [v]\n");
							return name;
						} else {
							System.out.print("=>"+name + " - [x]\n");
							System.out.print("=> It's Incorret value.\n");
							System.out.println("\nex) 국문 또는 영문 이름을 적어주세요.\n");
						}
					}while(true);
				}
		
		
			private static String signUpId() {
				do {
					System.out.println();
					System.out.print("* [아이디] : ");
					String id = sc.nextLine();
					if (id.matches("^[a-zA-Z0-9+]{4,12}$") && IsID_DuplicateCheck(id)) {
						System.out.print("=>"+id + "	- [v]\n");
						return id;
					} else if(IsID_DuplicateCheck(id)==false) {
						System.out.print("=>"+id + "	- [x]\n");
						System.out.print("=> It's overlap.\n");
						System.out.println("\n다시 확인해주세요.\n");
					} else {
						System.out.print("=>"+id + "	- [x]\n");
						System.out.println("\n 4~12자리, 영어 대소문자 및 숫자로만 구성이 가능합니다.\n");
					}
				}while(true);
			}
		
			private static String signUpPwd() {
				do {
					System.out.print("\n* [비밀번호] : ");
					String pwd = sc.nextLine(); //920812
					if (pwd.matches("^[a-zA-Z0-9+]{6,18}$")) { //최장수인 기준 1900년대분까지 계심
						System.out.print("=>"+pwd + " - [v]\n");
						return pwd;
					} else {
						System.out.print("=>"+pwd + " - [x]\n");
						System.out.print("=> It's Incorret value.\n");
						System.out.println("\n6~18자리 영어 대소문자 및 숫자로만 구성이 가능합니다.\n");
					}
				}while(true);
			}
			
			private static String signUpPhone() {
				do {
					System.out.print("\n* [휴대폰 번호] : ");
					String phone = sc.nextLine(); 
					if (phone.matches("^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$")
							&& !IsPhone_DuplicateCheck(phone)) {
						System.out.print("=>"+phone + " - [v]\n");
						return phone;
					} else {
						System.out.print("=>"+phone + " - [x]\n");
						System.out.print("=> It's Incorret value. or It already joined.\n");
						System.out.println("\nex) 01012345678 \n");
					}
				}while(true);
			}
			
			private static String signUpEmail() {
				do {
					System.out.print("\n* [이메일] : ");
					String email = sc.nextLine(); 
					if (email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")) { 
						System.out.print("=>"+email + " - [v]\n");
						return email;
					} else {
						System.out.print("=>["+email + "] - [x]\n");
						System.out.print("=> It's Incorret value.\n");
						System.out.println("\nex) bitcamp@or.kr\n");
					}
				}while(true);
			}
			
			private static void addArr() {
				String s1 = signUpName();
				String s2 = signUpId();
				String s3 = signUpPwd();
				String s4 = signUpPhone();
				String s5 = signUpEmail();
					System.out.println("\n------------------------------\n");
					NUser.userArr.add(new NUser(s1,s2,s3,s4,s5));
					DataBaseExcel.dataBase_Write("RegisterDataBase");
					System.out.println(NUser.userArr.get(NUser.userArr.size()-1).getName() +"님 회원가입을 축하드립니다^^");
			}

	}


