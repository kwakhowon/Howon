package practice;

public class Computer {
	public String company;
	public String modelName;
	public String cpu;
	public String memory;
	public String vga;
	public String os;
	public boolean power;
	public boolean screen_power;
	public int cpu_temperature;
	public int max_temperature = 90;
	public boolean network_state;

	public void power_on() {
		power = true;
	}

	public void power_off() {
		power = false;
	}

	public void power() {
		if (power == true) {
			cpu_temperature = 40;
			System.out.println("전원이 켜졌습니다.");
		} else {
			cpu_temperature = 20;
			System.out.println("전원이 꺼졌습니다.");
		}

	}

	public void screen_power() {
		if (screen_power == true) {
			System.out.println("모니터가 켜져있습니다.");
		} else
			System.out.println("'모니터가 꺼졌습니다.");
	}

	public void show_cpu_temperature() {
		if (power == true) {
			System.out.println("cpu 온도 : " + cpu_temperature);
		} else {
			System.out.println("cpu 온도 : " + cpu_temperature);
		}
	}

	public void show_network_State() {
		if (network_state == true) {
			System.out.println("네트워크가 연결되어있습니다.");
		} else {
			System.out.println("네트워크가 연결되어 있지 않습니다.");
		}
	}

	public void connect_network() {
		if(power == false) {
			network_state = false;
		}
		network_state = true;
	}

	public void disconnect_network() {
		network_state = false;
	}
	
	public void showComputerInfo() {
		System.out.println("컴퓨터 제작회사 : " +company);
		System.out.println("컴퓨터 모델명 : " +modelName);
		System.out.println("운영체제 : " +os);
	}

}