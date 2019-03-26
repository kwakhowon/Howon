/*
시나리오(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다
A라는 전자제품 매장이 오픈되면 
[클라이언트 요구사항]
가전제품은  제품의 가격 , 제품의 포인트 정보를 공통적으로 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름을 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다(ex: Tv , Audio , Computer)
각각의 전자제품은 다른 가격을 가지고 있다(Tv:5000, Audio:6000 ....)
제품의 포인트는 가격의 10% 적용한다
 
시뮬레이션 시나리오
구매자 : 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다 
예를 들면 : 10만원  , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게되면 가지고 있는 돈은  감소하고 
포인트는 올라간다
구매자는 처음 초기 금액을 가질 수 있다
*/

class Product { // 전자제품
	int price;
	int bonuspoint;

	public Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}

}

class KtTv extends Product {
	KtTv() {
		super(5000);
	}

	@Override
	public String toString() {
		return "KtTv";
	}

}

class Audio extends Product {
	Audio() {
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}

}

class Notebook extends Product {
	Notebook() {
		super(10000);
	}

	@Override
	public String toString() {
		return "Notebook";
	}

}

class Buyer{
	int money = 10000;
	int bonuspoint = 0;
	/*
	 구매행위
	 구매(잔액 - 제품가격 , 포인트 정보 갱신)
	 구매자는 매장에 매장에 있는 모든 제품 구매할 수 있다.
	KtTv , Notebook , Audio 구매가능
	 */
	public int buy_product(Product product) {
		if(this.money < product.price) {
			System.out.println("잔액이 부족합니다.");
		}else {
		money -= product.price;
		}
		bonuspoint += product.bonuspoint;
		return money;
	}
}

	/*
	구매행위
	구매행위(잔액 - 제품의 가격 , 포인트 정보 갱신)
	구매자는 매장에 있는 모든 제품을 구매할 수 있다
	구매행위하는 함수 구현
	KtTv , Audio , NoteBook 구매 가능
	
	1차 오픈 문제가 없다면 하와이 휴가 ^^
	*/

public class Ex12_Inherit_KeyPoint {
	public static void main(String[] args) {
		KtTv tv = new KtTv();
		System.out.println(tv.toString());
		System.out.println(tv.price);
		System.out.println(tv.bonuspoint);
		Audio audio = new Audio();
		Notebook notebook = new Notebook();
		
		Buyer buyer = new Buyer();
		buyer.buy_product(tv);
		buyer.buy_product(audio);
		System.out.println(buyer.money);
		System.out.println(buyer.bonuspoint);
		buyer.buy_product(notebook);
	}
}
