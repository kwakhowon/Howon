import kr.or.bit.Card;

public class Ex05_Static_CardMake {
	public static void main(String[] args) {
		//53카드 생성 ...
		Card c = new Card();
		c.number = 1;
		c.kind = "heart";
		//변경사항
		c.h = 500;
		c.w = 200;
		c.cardInfo();
		
		Card c2 = new Card();
		c2.number = 10;
		c2.kind = "heart";
		c2.cardInfo();
		//........
		//이때 고객이 카드가 .....
		//카드 크기를 늘려 주세요 h= 500 , w=200
		//53 번의 각각의 카드를 수정하는 작업......
		//static
		//카드 한장의 변경을 통해서 53장 모든 카드 반영
	}

}
