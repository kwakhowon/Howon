package practice;

public class Airconditioner {
	public int temperater;
	public double humidity;
	public boolean power;
	public boolean turbo;

	public void power() {
		if (power == true) {
			System.out.println("에어컨이 켜져있습니다.");
		} else {
			System.out.println("에어컨이 꺼져있습니다.");
		}

	}

	public int temper_up() {
		temperater++;
		return temperater;
	}

	public int temper_down() {
		temperater--;
		return temperater;
	}

	public String now_temper() {
		String print = "현재 온도 : " +temperater;
		return print;
	}

	public void turn_on_turbo() {
		if(power == false) {
			System.out.println("터보를 설정할 수 없습니다.");
			return;
		}
		turbo = true;
		temperater -= 5;
		System.out.println("터보 설정이 되었습니다.");
	}

	public void turn_off_turbo() {
		turbo = false;
		temperater += 5;
		System.out.println("터보 설정이 해재되었습니다.");
	}

}
