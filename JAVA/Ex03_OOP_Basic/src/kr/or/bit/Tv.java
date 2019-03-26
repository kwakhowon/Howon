package kr.or.bit;
/*
요구사항 정의
Tv는 채널정보를 가지고 있다(예를 들면 1~250채널을 가질 수 있다)
Tv는 브랜드 이름을 가지고있다.(예를 들면 삼성 , LG)
Tv는 채널 전환 기능을 가지고 있다.(채널을 변경할 수 있다 한단계씩)
기능 2개(++ , --)
Tv는 전원정보를 가지고 있다.
Tv의 전원은 On or Off
*/
public class Tv {
	public int ch; //public int ch = 1;
	public String brandname;
	public boolean power;
	public void ch_up() {
		//member field 상태 값
		ch++;
	}
	public void ch_down() {
		ch--;
	}
	public void power_on() {
			power = true;
			System.out.println("전원이 켜졌습니다.");
	}
	public void power_off() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}
}
