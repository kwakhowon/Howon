package homework;

public class CheezeBurger extends Hamburger {

	@Override
	public void cook() {
		System.out.println("치즈버거 만들기");
		System.out.println("재료를 준비한다. (빵 , 치즈 2장 , 패티 1장 , 양상추 , 토마토 , 피클 등등)");
		bread();
		toping();
		System.out.println("3. 패티를 올리고 치즈 2장을 그 위에 올린다.");
		toping();
		bread();
		System.out.println("6. ★완성★");
	}

	private void toping() {
		System.out.println("양상추와 토마토 , 피클 등등의 토핑을 올린다.");

	}

	private void bread() {
		System.out.println("빵을 올린다.");

	}

}
