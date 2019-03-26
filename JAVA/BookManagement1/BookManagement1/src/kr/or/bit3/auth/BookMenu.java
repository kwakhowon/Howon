package kr.or.bit3.auth;

import kr.or.bit3.function.Book;
import kr.or.bit3.function.BookOut;
import kr.or.bit3.function.Crawling;

public class BookMenu {
	
	
	public static void user_ShowMenu() {
		do {
			System.out.println("\n------------------------------\n");
			System.out.println("      [도서관리 메뉴]\n");
			System.out.println("0. 도서 검색");
			if(NLogin.userId !="GUEST") {
				System.out.println("1. 마이페이지");
				System.out.println("2. 대여 목록");
				System.out.println("3. 일괄 반납");
			}
			System.out.println("4. 로그아웃");
			System.out.print("\n메뉴를 선택하세요 : ");
			
			switch (NLogin.sc.nextLine()) {
			case "0":
//				Crawling.crawling();
				Book.showBookList(Crawling.crawling());
				int temp = Book.bookOneInfo();
				if(NLogin.userId != "GUEST") {
					Book.bookOutMenu(temp);
				}
				user_ShowMenu();
				break;
			case "1" :
				if(NLogin.userId != "GUEST") {
					NUser.UserMyInfo();
				}
				user_ShowMenu();
				break;
			case "2" :
				if(NLogin.userId !="GUEST") {
					BookOut.bookOutShow();
				}
				user_ShowMenu();
				break;
			case "3":
				if(NLogin.userId !="GUEST") {
					BookOut.bookOutShow();
				}
				BookOut.returnBook();
				user_ShowMenu();
				break;
			case "4":
				NLogin.userId = "GUEST";
				NLogin.loginDisplay();
				break;
			default:
				user_ShowMenu();
				break;
			}
			
		}while(false);

	}
}
