import kr.or.bit.Car;

public class Ex03_Modifier {
	public static void main(String[] args) {
		Car car = new Car();
		car.setWindow(10);
		System.out.println(car.getWindow());
		
		System.out.println("현재 시스템 속도 : " +car.getSpeed());
		car.speedUp();
		System.out.println("현재 시스템 속도 : " +car.getSpeed());
		car.speedUp();
		System.out.println("현재 시스템 속도 : " +car.getSpeed());
		
		car.speedDown();
		System.out.println("현재  시스텀 속도 : " +car.getSpeed());
	}
}
