package kr.or.bit3.function;

import java.util.ArrayList;
import java.util.List;

import kr.or.bit3.auth.BookMenu;
import kr.or.bit3.auth.NLogin;
import kr.or.bit3.utils.Calender;

public class BookOut {
	private Book book;
	private String checkOutDate; //대여일
	private String returnDate; //반납일
	public static List<BookOut> bookOutList;
	
	static {
		bookOutList = new ArrayList<BookOut>();
	}
	
	BookOut(Book book, String checkOutDate, String returnDate){
		this.book = book;
		this.checkOutDate = checkOutDate;
		this.returnDate = returnDate;
	}
	
	public static void bookOutListAdd(int bookOne) {
		System.out.println("\n------------------------------\n");
		if(Book.bookList.get(bookOne-1).getStock().equals("1")) {
			Book.bookList.get(bookOne-1).setStock("0"); // 재고 변경(1->0)
			bookOutList.add(new BookOut(Book.bookList.get(bookOne-1), Calender.currentDateTime(), Calender.returnDateTime())); // 대여 배열에 추가
			System.out.println("["+Book.bookList.get(bookOne-1).getBookTitle() +"](이)가 대여되었습니다.");
			DataBaseExcel.dataBase_Write2("BookDataBase");
		}else {
			System.out.println("재고가 없어, 대여가 불가능합니다.");
		}
	}
	public static void returnBook() {
//		System.out.println("\n------------------------------\n");
		bookOutShow();
		if(bookOutList.size() !=0) {
	        System.out.println("\n* 일괄 반납 하시겠습니까?(yes/no)");
	        System.out.print(">>> ");
	        switch (NLogin.sc.nextLine().toLowerCase()) {
	        case "yes":
	        case "y":
	            for(int i=0; i<bookOutList.size(); i++) {
	                bookOutList.removeAll(bookOutList);
	            }
	            for(int i=0; i< Book.bookList.size(); i++) {
	            	if(Book.bookList.get(i).getStock().equals("0")) {
	            		Book.bookList.get(i).setStock("1");
	            	}
	            }
	            DataBaseExcel.dataBase_Write2("BookDataBase");
	            BookMenu.user_ShowMenu();
	            break;

	        default :
	        BookMenu.user_ShowMenu();
	            break;
	        }
		}else {
			System.out.println("\n반납 가능한 [대여목록]이 존재하지 않습니다.");
			BookMenu.user_ShowMenu();
		}

    }
	
	public static void bookOutShow() { //대여 내역보기
		System.out.println("\n------------------------------\n");
		System.out.println("      [대여 목록]\n");
		if(bookOutList.size()==0) {
			System.out.println("대여한 내역이 존재하지 않습니다.");
			return;
		}
		for(int i=0; i<bookOutList.size(); i++) {
			if(Book.bookList.get(i).getStock().equals("0")) {
				System.out.print((i+1)+". "+Book.bookList.get(i).getBookTitle());
				System.out.print(" (대여일: "+bookOutList.get(i).getCheckOutDate()+" | ");
				System.out.println("반납일: "+bookOutList.get(i).getReturnDate()+")");
			
			}
		}
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String date) {
		this.checkOutDate = date;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


}
