package kr.or.bit;

import java.util.Scanner;

// 2차원 배열(5행 5열)
// 좌선 선택, 선택한 좌석은 바꾸기, 메뉴표
// 동일한 좌석 선택시 거절 
// 예매 지연시 어플리케이션 종료

public class Movie_theater {
	private Scanner sc;
	private static String[][] seats;
	private static int inputRowsInt;
	private static int inputNum2;
	private static String inputRows;
	private static int reservationSeats;

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
	} // 생성자 종료

	private void seatsStatus(String[][] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i].length;
		}
		System.out.print("(전체좌석: " + sum + " / 예약가능 좌석: " + (sum - reservationSeats) + ")\n");
	}

	public void show_menu() {
		do {
			try {
				String texth1 = "\n\n--------- 영화관 예매 프로그램 ---------\n\n";
				System.out.println(texth1);
				System.out.println("1. 좌석 확인");
				System.out.print("2. 좌석 예매");
				seatsStatus(seats);
				System.out.println("3. 예매 취소하기");
				System.out.println("4. 전체 예매 취소");
				System.out.println("5. 프로그램 종료");
				System.out.print("\n당신의 선택 : ");
				int menu = Integer.parseInt(sc.nextLine());
				System.out.println();
				for (int i = 0; i < texth1.length(); i++) {
					System.out.print("-");
				}
				System.out.println();

				switch (menu) {
				case 1:
					show_seats();
					break;
				case 2:
					inputSeat(menu);
					break;
				case 3:
					inputSeat(menu);
					break;
				case 4:
					WholeCancel();
					break;
				case 5 : 
					return;
				default:
					System.out.println("\n\n @@@ 올바른 메뉴를 선택하세요. @@@\n\n");
				}
			} catch (Exception e) {
				System.out.println("\n\n @@@ 올바른 메뉴를 선택하세요. @@@\n\n");
			}

		} while (true);
	}

	private void WholeCancel() {
		if(reservationSeats == 0) {
			System.out.println("예매된 좌석이 없습니다.");
			return;
		}
		System.out.println("예약된 좌석을 전부 취소하시겠습니까?(y/n)");
		
			
		String ques = sc.nextLine();
		switch (ques) {
		case "y" :
		case "Y" :
			 reservationSeats = 0;
			 for(int i = 0; i <seats.length; i++) {
				 for(int j = 0; j<seats[i].length; j++) {
					 seats[i][j] = String.valueOf(j+1);
				 }
			 }
			 break;
		case "n" :
		case "N" :
				show_menu();
			break;
		default:
			System.out.println("잘못 입력했습니다.");
			show_menu();
			break;
		}
	}

	private void show_seats() {
		System.out.println("\n      SCREEN");
		System.out.println();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 65 + i; j < 66 + i; j++) {
				System.out.print((char) j);
			}
			System.out.print("|");
			System.out.print(" ");
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print(" ");
				System.out.print(seats[i][j]);
			}
			System.out.println();
			for (int k = 0; k < seats[i].length + 8; k++) {
				System.out.print("-");
			}
			System.out.println();
		}

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

	private void cancelSeats() {
		if (seats[inputRowsInt][inputNum2 - 1] == "X") {
			seats[inputRowsInt][inputNum2 - 1] = String.valueOf(inputNum2);
			System.out.println("\n@@@@@@@@ 좌석예약을 취소했습니다 @@@@@@@@\n");
			reservationSeats--;
		} else if (reservationSeats == 0) {
			System.out.println("예약된 좌석이 없습니다.");
		} else {
			System.out.println("\n [다시 확인하세요!] 예약된 좌석이 아닙니다.");
		}

	}

	private void displayMenu() throws InterruptedException {
		System.out.println("\n    SCREEN");
		System.out.println();
		for (int i = 0; i < seats.length; i++) {
			for (int j = 65 + i; j < 66 + i; j++) {
				System.out.print((char) j);
			}
			System.out.print("|");
			System.out.print(" ");
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print(" ");
				System.out.print(seats[i][j]);
			}
			System.out.println();
			for (int k = 0; k < seats[i].length + 8; k++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
//		System.out.println("--------- SweetBox 좌석 배치도 ---------\n");
		System.out.println("(\"X\"는 이미 예약된 좌석입니다.)");
		System.out.print("\n행을 선택하세요.(ABCDE)\n==> ");
		inputRows = sc.nextLine();
		System.out.print("열을 선택하세요.(12345)\n==> ");
		inputNum2 = Integer.parseInt(sc.nextLine());
	}

	private void inputSeat(int menu) {
		try {
			if(menu == 3 && reservationSeats==0) {
				System.out.println("예매된 좌석이 없습니다");
				return;
			}
			displayMenu();
			switch (inputRows) {
			case "A":
			case "a":
				inputRowsInt = 0;
				if (menu == 2) {
					changeSeats();
					break;
				} else if (menu == 3) {
					cancelSeats();
					break;
				}
			case "B":
			case "b":
				inputRowsInt = 1;
				if (menu == 2) {
					changeSeats();
					break;
				} else if (menu == 3) {
					cancelSeats();
					break;
				}
			case "C":
			case "c":
				inputRowsInt = 2;
				if (menu == 2) {
					changeSeats();
					break;
				} else if (menu == 3) {
					cancelSeats();
					break;
				}
			case "D":
			case "d":
				inputRowsInt = 3;
				if (menu == 2) {
					changeSeats();
					break;
				} else if (menu == 3) {
					cancelSeats();
					break;
				}
			case "E":
			case "e":
				inputRowsInt = 4;
				if (menu == 2) {
					changeSeats();
					break;
				} else if (menu == 3) {
					cancelSeats();
					break;
				}
			default:
				System.out.println("\n@@@@@ 입력값좀 확인하세요. @@@@@\n");
			}
		} catch (Exception e) {
			System.out.println("\n@@@@@ 에러 @@@@@\n");
		}
	}
}