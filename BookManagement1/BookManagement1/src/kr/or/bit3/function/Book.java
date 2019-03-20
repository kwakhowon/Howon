package kr.or.bit3.function;

import java.util.ArrayList;
import java.util.List;

import kr.or.bit3.auth.BookMenu;
import kr.or.bit3.auth.NLogin;

public class Book {
	private int bookIndex; // 인덱스값 
	private String searchWord;
	private String bookCategory; // 책 카테고리
	private String bookTitle; // 책이름
	private String bookAuthor; // 책 지은이
	private String bookPublisher; // 출판사
	private String bookPublishedDate; //발간일 
	private String bookPrice; //책가격
	private String user; //사용자(로그인 기준)
	private	String stock; //재고 
	public static List<Book> bookList; // book 검색 배열 
	
	static {
		bookList = new ArrayList<Book>(); 
	}
	
	Book(int bookIndex, String bookCategory, String bookTitle, String bookAuthor, String bookPublisher,
			String bookPublishedDate, String bookPrice, String user,String stock ,String searchWord){
		this.bookIndex = bookIndex;
		this.bookCategory = bookCategory; 
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookPrice = bookPrice;
		this.user = user;
		this.searchWord = searchWord;
		this.stock = stock;
	}
	
	public static void showBookList(String searchWord) {
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getSearchWord().equals(searchWord) && bookList.get(i).getUser().equals(NLogin.userId)) {
				System.out.println(
						(i+1)+". (재고"+bookList.get(i).getStock()+") " + bookList.get(i).getBookTitle()
						);
			}

		}
	}
	
	private static String bookOne() {
		do {
			System.out.print("\n* 번호를 입력하면 해당 책 정보를 볼 수 있습니다 : ");
			String bookOne = NLogin.sc.nextLine(); 
			if (bookOne.matches("^[0-9]+$")) {
				return bookOne;
			} else {
				System.out.print("=>"+bookOne + " - [x]\n");
				System.out.print("=> It's Incorret value.\n");
				System.out.println("\nex) 0123456789 \n");
			}
		}while(true);
	}
	
	public static int bookOneInfo() {
		String bookOne =bookOne();
		if (Integer.parseInt(bookOne)>Crawling.totalCount | Integer.parseInt(bookOne)==0) {
			bookOneInfo();
		}
		System.out.println("\n------------------------------\n");
		System.out.println("	[상세정보]\n");
		System.out.println("    [대분류]: " + bookList.get(Integer.parseInt(bookOne)-1).getBookCategory().replace("[", "").replace("]", ""));
		System.out.println("    [책제목]: " + bookList.get(Integer.parseInt(bookOne)-1).getBookTitle());
		System.out.println("    [지은이]: " + bookList.get(Integer.parseInt(bookOne)-1).getBookAuthor());
		System.out.println("    [출판사]: " + bookList.get(Integer.parseInt(bookOne)-1).getBookPublisher());
		System.out.println("    [발행일]: " + bookList.get(Integer.parseInt(bookOne)-1).getBookPublishedDate());
		System.out.println("    [도서가]: " + bookList.get(Integer.parseInt(bookOne)-1).getBookPrice());
		System.out.println("[대여가능여부]: " + (bookList.get(Integer.parseInt(bookOne)-1).getStock().equals("1")? "대여 가능":"대여 불가능(재고없음)"));
		return Integer.parseInt(bookOne);
	}
	
	public static void bookOutMenu(int bookOne) { //대여 메뉴
		do {
			System.out.println("\n------------------------------\n");
			System.out.println("      [대여 메뉴]\n");
			System.out.println("1. ["+bookList.get(bookOne-1).getBookTitle()+"] 대여하기");
			System.out.println("2. [도서관리 메뉴]로 돌아가기");
			System.out.print("\n메뉴를 선택하세요 : ");
			switch (NLogin.sc.nextLine()) {
			case "1":
				BookOut.bookOutListAdd(bookOne);
				BookMenu.user_ShowMenu();
				break;
			case "2":
				BookMenu.user_ShowMenu();
				break;
			default:
				System.out.println("\n입력 오류입니다. \n");
				break;
			}
		} while (false);
	}
	
	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(int bookIndex) {
		this.bookIndex = bookIndex;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookPublishedDate() {
		return bookPublishedDate;
	}

	public void setBookPublishedDate(String bookPublishedDate) {
		this.bookPublishedDate = bookPublishedDate;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
}
