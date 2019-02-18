

import practice.Car;

public class Main {
	public static void main(String[] args) {
		Car car = new Car(10000, 100, 1000, 10);
		car.setMax_power(100);
		car.setMileage(10);
		car.music_usb();
		car.carInfo();
	}
}
