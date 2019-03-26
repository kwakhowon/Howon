package practice;

import java.util.Scanner;

public class Movie_theater {
	private static Scanner sc;
	private static String inputRows;
	private static int reservationSeats;
	private static int inputRowsInt;
	private static int inputNum2;
	private static String[][] seats;

	static {
		inputRows = "";
		inputRowsInt = 0;
		inputNum2 = 0;
		seats = new String[][] { { "1", "2", "3", "4", "5", "6" }, { "1", "2", "3", "4", "5", "6" },
				{ "1", "2", "3", "4", "5", "6" }, { "1", "2", "3", "4", "5", "6" }, { "1", "2", "3", "4", "5", "6" }, };
		reservationSeats = 0;
	}

	public Movie_theater() {
		sc = new Scanner(System.in);
	}

	private void seatsStatus(String[][] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i].length;
		}
		System.out.println("(전체 좌석 : " + sum + " 잔여 좌석 : " + (sum - reservationSeats) + ")");
	}

	public void showmenu() {
		System.out.println("****************");
		System.out.println("영화좌석 예매 프로그램");
		System.out.print("1. 좌석 확인 ");
		seatsStatus(seats);
		System.out.println("2. 좌석 예매");
		System.out.println("3. 좌석 취소");
		System.out.println("4. 좌석 전체 취소");
		System.out.println("5. 나가기");
		System.out.print("\n 당신의 선택 : ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			check_seats();
			break;
		case 2:
			reservation();
			break;
		case 3:
			cancel_seats();
			break;
		case 4:
			whole_cancel_seats();
			break;
		case 5:
			return;
		default:
			System.out.println("잘못된 선택입니다.");
		}
	}

	private void check_seats() {
		System.out.println("          SCREEN");
		System.out.println("-----------------------");
		System.out.println();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 65 + i; j < 66 + i; j++) {
				System.out.print((char) (j));
			}
			System.out.print(" | ");
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print(" ");
				System.out.print(seats[i][j]);

			}
			System.out.println();
		}
	}

	private void reservation() {
		try {
			check_seats();
			System.out.print("\n행을 선택하세요.(ABCDE)\n==> ");
			inputRows = sc.next();
			System.out.print("열을 선택하세요.(12345)\n==> ");
			inputNum2 = Integer.parseInt(sc.nextLine());
			switch (inputRows) {
			case "A":
			case "a":
				inputRowsInt = 0;
				changeSeats();
				break;
			case "B":
			case "b":
				inputRowsInt = 1;
				changeSeats();
				break;
			case "C":
			case "c":
				inputRowsInt = 2;
				changeSeats();
				break;
			case "D":
			case "d":
				changeSeats();
				break;
			case "E":
			case "e":
				inputRowsInt = 4;
				changeSeats();
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cancel_seats() {

	}

	private void whole_cancel_seats() {

	}

	private void changeSeats() {
		if (seats[inputRowsInt][inputNum2 - 1] != "X") {
			seats[inputRowsInt][inputNum2 - 1] = "X";
			System.out.println("좌석 " + (char) (inputRowsInt + 65) + inputNum2 + "가 예매 되었습니다.");
			reservationSeats++;
		} else {
			System.out.println("\n [다시 확인하세요!] 이미 예약된 좌석 입니다.");
		}
	}

}
