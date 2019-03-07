/*
요구사항
카트 (Cart)
카트에는 매장에 있는 모든 전자제품을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... 카트에 담는다

계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력
hint) 카트 물건을 담는 행위 (Buy())
hint) Buyer ..>> summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
*/

class Product2 { // 전자제품
	int price;
	int bonuspoint;

	// Product() { }
	Product2(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class KtTv2 extends Product2 {
	KtTv2() {
		super(5000);
	}

	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2 {
	Audio2() {
		super(100);
	}

	@Override
	public String toString() {
		return "Audio2";
	}
}

class NoteBook2 extends Product2 {
	NoteBook2() {
		super(100);
	}

	@Override
	public String toString() {
		return "Notebook2";
	}
}

class Buyer2 {
	int money = 10000;
	int bonuspoint = 0;

	// 장바구니 생성(장바구니는 모든 전자제품을 담을 수 있다)***
	Product2[] cart = new Product2[10];
	int index = 0;
	// ****************************************************

	Buyer2() {
		// this.money = 10000;
		// this.bonuspoint = 0;
		this(10000, 0);
	}

	Buyer2(int money, int bonuspoint) {
		this.money = money;
		this.bonuspoint = bonuspoint;
	}

	void Buy(Product2 product) { // 구매 (상품정보) //KtTv parameter 로 ...
		if (this.money < product.price) {
			System.out.println("고객님 잔액이 부족합니다 ^^");
			return; // 구매 행위에 대한 종료
		}

		// Cart 범위 제한
		if (this.index >= 10) {
			System.out.println("[고객님 넘 많이 사셨어요]");
			return; // 구매 행위에 대한 종료
		}

		// Cart 담기 ************************************
		// if 처리 .. null 값 비교
		cart[index++] = product; // 0번째 물건 .. //++index
		// **********************************************

		// 실 구매행위
		this.money -= product.price;
		this.bonuspoint += product.bonuspoint;
		System.out.println("구매한 물건은 : " + product.toString());
		System.out.println("현재 잔액 : " + this.money);
		System.out.println("현재 포인트 : " + this.bonuspoint);
	}

	// 계산대 (장바구니) 물건 꺼내서 계산 ...
	// 물건의 총액 (Product2)
	// 물건의 목록
	void Summary() {
		int totalprice = 0;
		int totalbonuspoint = 0;
		String productlist = "";

		// for(int i = 0 ; i < cart.length ; i++)
		// { if(cart[i] == null)break; }

		for (int i = 0; i < index; i++) {
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist += cart[i].toString() + " ";
		}
		System.out.println("***********************");
		System.out.printf("**구매물건 총액  :[%d]**\n", totalprice);
		System.out.printf("**포인트  총액   :[%d]**\n", totalbonuspoint);
		System.out.printf("**구매물건리스트 :[%s]**\n", productlist);

	}

}

public class Ex13_Inherit_KeyPoint_Override {
	public static void main(String[] args) {

		Buyer2 buyer = new Buyer2(100000, 0);
		KtTv2 tv = new KtTv2();
		Audio2 audio = new Audio2();
		NoteBook2 notebook = new NoteBook2();

		buyer.Buy(tv);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(notebook);

		buyer.Summary();

	}

}
