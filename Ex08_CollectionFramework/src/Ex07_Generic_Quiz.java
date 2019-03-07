import java.util.ArrayList;
import java.util.List;

class Product {
}

class Tv extends Product {
	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product {
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product {
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex07_Generic_Quiz {
	public static void main(String[] args) {
		// 1. Array(배열) 사용해서 cart를 만들고 제품을 담으세요
		Product[] cart = new Product[3]; // 다형성
		cart[0] = new Tv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();

		// 2. ArrayList를 사용해서 cart를 만들고 제품 3개를 담으세요
		List<Product> cart2 = new ArrayList<Product>(); // *********************
		cart2.add(new Tv());
		cart2.add(new Audio());
		cart2.add(new NoteBook());

		for (Product product : cart2) {
			System.out.println(product.toString());
		}
	}
}
