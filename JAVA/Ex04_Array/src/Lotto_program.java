
public class Lotto_program {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		// 번호 추출 (중복값 제거)
		for (int i = 0; i < 6; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1); // 난수 추출
			for (int j = 0; j < i; j++)
				if (lotto[i] == lotto[j]) {
					i--; // point
					break;
				}
		}
		// 정렬하기
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		// 출력하기
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + "\t");
		}
	}
}
