package test;

import practice.Aircontroller;

public class AirMain {
	public static void main(String[] args) {
		Aircontroller aircon = new Aircontroller("samsung", 1200000);
		aircon.setPower(10);
		aircon.AircontrollerInfo();
	}
}
