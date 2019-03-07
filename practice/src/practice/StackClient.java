package practice;
//public int[] itemArray;  -->   public ArrayList<Integer> items;
import java.util.*;

class ArrayStack {
	public ArrayList<Integer> items;
	public int stackSize;

	public ArrayStack(int stackSize) {
		items = new ArrayList<Integer>(stackSize);
		this.stackSize = stackSize;
	}

	public boolean isEmpty() { // 스택이 비어 있는지 검사
		return (items.isEmpty());
	}

	public boolean isFull() { // 스택이 꽉 차있는지 검사
		return (items.size() == this.stackSize);
	}

	public void push(int item) { //넣는거
		if (isFull()) {
			System.out.println("Inserting fail! Array Stack is full!!");
		} else {
			items.add(item);
			System.out.println("Inserted Item : " + item);
		}
	}

	public int pop() { //빼는거
		if (isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!");
			return -1;
		} else {
			return items.remove(items.size()-1);
		}
	}

	public int peek() { //값 보여주는거
		if (isEmpty()) {
			System.out.println("Peeking fail! Array Stack is empty!");
			return -1;
		} else {
			return items.get(items.size()-1);
		}
	}


}

public class StackClient {
	public static void main(String[] args) {
		ArrayStack st = new ArrayStack(5);
		st.push(10);
		st.push(10);
		st.push(21);
		st.push(25);
		st.push(34);
		for(Integer arr : st.items) {
			System.out.println(arr);
		}
	}

}