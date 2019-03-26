package com.bit.three;

import java.util.Scanner;

public class Master {
	private String password;
	Login login;
	int useNetPaperSum;
	int repairChargeSum;
	
	Master(){
		this.useNetPaperSum = 0;
		this.repairChargeSum =0;
		this.password = "1234";
	}
	
	public void MasterPassword() {
		System.out.print("관리자 암호를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String inputPassword = sc.nextLine();
		System.out.println();
		if(this.password.equals(inputPassword)) {
			
			showStatus();
			showMasterMenu();
			
		}else {
			System.out.println("올바르지 못한 입력값입니다.");
			backLogin();
		}
	}
	
	private void showStatus() { 
		Machine.time = new Time();
		Machine.currentTime = Machine.time.currentDateTime();
		System.out.println("------------------------------\n");
		System.out.println("자판기 전원 : On");
		System.out.println("자판기 On 시간 : " + Machine.startTime);
		System.out.println("현재 시간 : " + Machine.currentTime);
		System.out.println("자판기 작동 시간(초) : " + Machine.time.diffDateTime(Machine.startTime, Machine.currentTime)+"초");
		if(Machine.certificate.paperStatus()>(int)(Machine.certificate.getPaperDefault()*0.2)) {
			System.out.println("용지매수 상태 : 충분("+Machine.certificate.paperStatus() + "장)");
		} else if(Machine.certificate.paperStatus()>0) {
			System.out.println("용지매수 상태 : 부족("+Machine.certificate.paperStatus() + "장)");
		} else {
			System.out.println("용지매수 상태 : 없음(0장)");
		}
		System.out.println("현재 고장확률 : " + failureRate() +"%");
		System.out.println("현재 회원 수 : " + Login.index +"/100" );
	}
	
	private void showMasterMenu() {
		do {
//			showStatus();
			System.out.println("\n------------------------------\n");
			System.out.println("    [관리자 전용메뉴]\n");
			System.out.println("1. 용지업체 부르기(용지 리셋)");
			System.out.println("2. 수리업체 부르기(고장률 리셋)");
			System.out.println("3. 로그인 화면으로 돌아가기\n");
			System.out.print("메뉴를 선택하세요 : ");
			Scanner sc = new Scanner(System.in);
			String inputMenu = sc.nextLine();
			System.out.println();
		
			switch(inputMenu) {
			case "1" : callPaperCompany();showStatus();showMasterMenu(); break; // 용지 업체에 용지 추가 요청(최대 용지로 다시 넣어줌)
			case "2" : callRepairMan();backLogin(); break; // 수리기사 부르기
			case "3" : backLogin(); break; // 로그인 화면으로 돌아가기
			//case "4" : break; //매출확인하기(증명서별 판매 수, 및 총 금액 / 손익분기점 확인)
			default: System.out.println("입력값을 확인하세요."); showMasterMenu();
			}
		}while(false);
	}
	
	private void callPaperCompany(){
		int useNetPaper = Machine.certificate.getPaperDefault() - Machine.certificate.paperStatus();
		this.useNetPaperSum += useNetPaper*100;
		Machine.certificate.setPaperUse(-Machine.certificate.getPaperUse());
		System.out.println("\n------------------------------\n");
		System.out.println("용지 기사님을 불렀습니다.\n");
		Login.progressBar("용지 기사님이 오는 중");
		Login.progressBar("용지 기사님이 용지 충전중");
		System.out.println("\n- 용지가 모두 충전되었습니다.");
		System.out.println("- 충전후 용지매수 : " + Machine.certificate.paperStatus()+"장");
		System.out.println("- 충전된 용지는 " + useNetPaper + "장이며, 총 " + useNetPaper*100 + "원이 다음 결제일에 청구됩니다.");
		System.out.println("- 현재 청구 예정금액 총합계는 " + this.useNetPaperSum +"원 입니다.\n");
	}
	private void callRepairMan() {
		System.out.println("\n------------------------------\n");
		System.out.println("수리 기사님을 불렀습니다.\n");
		Login.progressBar("수리 기사님이 오는 중");
		Login.progressBar("수리 기사님이 재부팅 버튼을 찾는중");
		int repairCharge = failureRate();
		this.repairChargeSum += failureRate() * 100;
		Machine.startTime = Machine.time.currentDateTime();
		System.out.println("\n- 수리 기사님이 재부팅 버튼을 눌렀습니다.");
		System.out.println("- 수리후 고장률 : " + failureRate() +"%");
		System.out.println("- 수리된 고장률은 " + repairCharge + "%이며, 총 " + repairCharge*100 + "원이 다음 결제일에 청구됩니다.");
		System.out.println("- 현재 청구 예정금액 총합계는 " + this.repairChargeSum+"원 입니다.\n");
		Login.progressBar("\n \t시스템 초기화 중,\n \t전원을 끄지 마세요");
	}
	private void backLogin() {
		Login.loginDisplay();
	}
	
	private int failureRate() {
		Machine.currentTime = Machine.time.currentDateTime();
		int failureRate =((int) Machine.time.diffDateTime(Machine.startTime, Machine.currentTime)/30);
		if(failureRate<100) {
			return failureRate;
		}
		return 100;
	}
}