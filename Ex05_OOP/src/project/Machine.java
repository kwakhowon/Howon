package project;

public class Machine {
	Login login = new Login();
	static int ink = 50;
	boolean machine_power = false;
	Certificate ctf = new Certificate();

	public void machine_power() {
		this.machine_power = !this.machine_power;
		System.out.println("자판기 On.");
		login.LoginMethod();
		ctf.Menu();
		login.LoginMethod();
	}

}
