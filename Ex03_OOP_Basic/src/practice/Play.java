package practice;

public class Play {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.power();
		computer.power_on();
		computer.power();
		computer.show_cpu_temperature();
		computer.power = false;
		computer.power();
		computer.show_cpu_temperature();
		computer.show_network_State();
	}
}
