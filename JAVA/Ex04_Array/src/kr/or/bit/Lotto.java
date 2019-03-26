package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

//설계도
//Lotto lotto = new Lotto();
//lotto.SelectLottoNumber();
//1.입력 : > selectBasicNumber() 함수 호출 (번호 추출)
//2.입력 : > 화면 출력
//3.입력 : > 종료
public class Lotto {
	private static Scanner scanner; // 부품정보 상태정보 , 부품정보 , 고유정보
	private Random random; // r.nextInt(45)+1 (1~45)
	private int[] numbers;

	// static{} , {} 초기자
	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public Lotto() { // 특수한 목적 : member field 초기화 (생성자 함수) , constructor
		scanner = new Scanner(System.in); // 초기화 (참조 변수 주소값을 갖는것)
		random = new Random();
		numbers = new int[6];
	}

	public void show_menu() { // 첫 메뉴 출력

		do {
			try {
				System.out.println("****************");
				System.out.println("***로또 프로그램***");
				System.out.println("1. 로또 룰렛 돌리기");
				System.out.println("2. 화면에 로또 번호 출력 ");
				System.out.println("3. 시스템 종료");
				System.out.print("메뉴 선택 : ");

				int menu = Integer.parseInt(scanner.nextLine());
				switch (menu) {
				case 1:
					do {
						selectBasicLottoNumber(); //일단 한번 로또번호 출력

					}while(!checkAverage(numbers)); // sum이 150 이하가 아니거나 sum % 5 != 0일때 다시 뽑기
					showLottoNumber();
					break;
				case 2:
					showLottoNumber();
					break;
				case 3 :
					return;
				}
			} catch (Exception e) {
				e.getMessage();
				System.out.println("1~3만 입력하세요");
			}
		} while (true);

	}

	private void selectBasicLottoNumber() { // 중복값 제거하는 함수
		// 실로또 번호 추출하고 중복값 배제 처리 하는 함수
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}

			}
		}
		for (int i = 0; i < numbers.length; i++) { //오름차순 정렬
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

	}

	private void showLottoNumber() { //뽑은 Lotto 번호 출력하는 함수
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("[" + numbers[i] + "]");
		}
		System.out.println();
	}
	
	//검증(기능 함수) 총합을 5로 나눴을때 떨어지지 않는 것 and 총 합이 150 이하
	private boolean checkAverage(int numbers[]) {
		int sum = 0;
		for(int i = 0; i<numbers.length; i++) {
			sum+=numbers[i];
			
			}
		if(sum % 5 ==0 && sum<150)
			selectBasicLottoNumber();
		
	 return (sum % 5 != 0&& sum<150); // sum % 5가 0이 아니거나 sum<150 일때 return
	}
	
}
