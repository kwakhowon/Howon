package practice;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> solution(int[] arr) {
		final List<Integer> answer = new ArrayList<>();
		int value = arr[0];
		answer.add(value);
		for (int i = 1; i < arr.length; i++) {
			if (value != arr[i]) {
				answer.add(arr[i]);
				value = arr[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
	}
}
