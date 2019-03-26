package kr.or.bit;
/*
  책은 책 이름 , 가격을 가지고 있다.
  책이 출판되면 반드시 책은 책의 이름과 가격을 가지고 있어야한다. // 메모리에 올린다.
  책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고 , 출판된 이후에는 수정 불가 ( bookInfo())
  책 이름과 가격 정보는 각각 정보를 읽을 수 있다. (getter)
 
 
 
 */
public class Book {
	private String bookName;
	private int price;
	
	public String getBookName() {
		return bookName;
	}

	public int getPrice() {
		return price;
	}
	
	//public Book() {} // 문법적으로는 써도 상관없지만 요구사항에 위배된다.
	public Book(String bookName, int price) {
		this.bookName = bookName;
		this.price = price;
	}
	
	public void bookInfo() {
		System.out.println("책 이름 : " +this.bookName);
		System.out.println("책 가격 : " +this.price);
	}
	
}
