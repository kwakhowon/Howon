/*
 *1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요 (처음....)
 *2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안되요 (기초 학습 ...)
 *3. 배열에 있는 6개의 값은 낮은 순으로 정렬 시키세요 (자료구죠....)
 *4. 위 결과를 담고 있는 배열을 출력하세요
 
 조별과제 .....
 */
public class Ex02_Lotto_Main {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int temp;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
//			for (int j = 0; j < i; j++) {
//				while (lotto[i] == lotto[j]) {
//					lotto[i] = (int) (Math.random() * 45 + 1);
//					j = 0;
//				}
//
//			}
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto.length - 1; j++) {
				if (lotto[j] > lotto[j + 1]) {
					temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;

				}
			}
		}
		for (int i = 0; i < lotto.length; i++) {

			System.out.print(lotto[i] + "\t");
		}
	}
}
