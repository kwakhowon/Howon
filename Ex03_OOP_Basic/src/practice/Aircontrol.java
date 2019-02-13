package practice;

public class Aircontrol {
	public static void main(String[] args) {
		Airconditioner ac = new Airconditioner();
		ac.power();
		ac.power = true;
		ac.power();
		ac.now_temper();
		System.out.println(ac.temperater);
		ac.temper_up();
		System.out.println(ac.temperater);
		ac.temper_down();
		ac.turn_on_turbo();
		System.out.println(ac.temperater);
		ac.now_temper();
		System.out.println(ac.now_temper());
		ac.power = false;
		ac.turn_on_turbo();
	}
}
