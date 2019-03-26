import java.util.Stack;

import kr.or.bit.Coin;
import kr.or.bit.MyStack;

public class Ex05_Stack_Collection {
	public static void main(String[] args) {
		//LIFO Last In First Out
		//Stack : Collection Framework 제공하는 클래스
		
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//System.out.println(stack.pop());
		//java.util.EmptyStackException
		System.out.println(stack.isEmpty()); //true : 비어있다 false : 무언가 있다.
		
		//동전 케이스
		//stack 자료구조 원하는 형태 ....
		Stack<Coin> coinbox = new Stack<Coin>();
		coinbox.push(new Coin(100));
		coinbox.push(new Coin(50));
		coinbox.push(new Coin(500));
		
		//System.out.println(coinbox.pop().getValue());
		while(!coinbox.isEmpty()) {
			Coin coin = coinbox.pop();
			System.out.println("꺼낸 동전 : " +coin.getValue());
		}
		
		
		MyStack my = new MyStack(3);
		my.push(10);
		my.push(50);
		my.push(70);
		my.push(70);
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		System.out.println(my.pop());
		
		//좋은 회사일수록 자료구조를 많이 물어본다
		//최소한 stack 하고 queue 정도의 코드는 구현해보자.
	}
}
