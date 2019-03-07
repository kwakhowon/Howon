package kr.or.bit;

import java.util.Arrays;

//Stack 자료구조를 직접 설계
//MyStack my = new MyStack(5);
public class MyStack {
	private int top; // 값이 변한다.(이동 : 마우스 커서)
	private Object[] stackarr; // 데이터를 담을 공간
	private int maxsize;
	// 추가적으로 ㅍ리요한 변수는 추가 가능

	public MyStack(int maxsize) {
		stackarr = new Object[maxsize];
		this.maxsize = maxsize;
		top = -1;
	}

	// 기능 (함수)
	// 스택 empty 되어 있니

	// 스택 full 되어 있니

	// 스택 push 데이터 넣는거

	// 스택 pop 꺼내는거

	public boolean isEmpty() {
		return (top == -1);
	}
	public boolean isFull() {
		return (top== maxsize-1);
	}
	
	public void push(int item) {
		if(isFull()) {
			System.out.println("더이상 넣을 공간이 없다.");
		}else {
			stackarr[++top] = item;
			System.out.println("Insert data : " +item);
		}
	}
	public Object pop() {
		Object output = null;
		if(isEmpty()) {
			System.out.println("꺼낼 것이 없다");
			return null;
		}else {
			output = stackarr[top];
			top--;
		}
	return output;
	}

	@Override
	public String toString() {
		return "MyStack [top=" + top + ", stackarr=" + Arrays.toString(stackarr) + ", maxsize=" + maxsize
				+ ", toString()=" + super.toString() + "]";
	}
	
}
