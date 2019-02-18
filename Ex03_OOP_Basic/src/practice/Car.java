package practice;

public class Car {
	private String name;
	private int price;
	private int max_power;
	private int max_speed;
	private int mileage;
	
	public void setMax_power(int max_power) {
		this.max_power = max_power;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Car(int price, int max_power, int max_speed, int mileage) {
		this.price = price;
		this.max_power = max_power;
		this.max_speed = max_speed;
		this.mileage = mileage;
	}
	
	public void carInfo() {
		System.out.println("차량의 금액 : " +this.price +" 연비 : " +this.mileage+" 최고속도 " +this.max_speed+" 최고출력 : " +this.max_speed);
	}
	public void music_usb() {
		System.out.println("usb를 통한 음악 출력");
	}
	public void music_bluetooth() {
		System.out.println("블루투스를 통한 음악 출력");
	}
	public void music_wifi() {
		System.out.println("와이파이를 통한 음악 출력");
	}
	
}
