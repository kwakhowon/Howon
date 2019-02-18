package practice;

public class Clock {
	private String brand;
	private int price;
	private int hour_hand;
	private int minute_hand;
	private int second_hand;
	
	public String getBrand() {
		return brand;
	}
	public int getPrice() {
		return price;
	}
	public int getHour_hand() {
		if(hour_hand<0 && hour_hand>12)
			return 0;
		else
		return hour_hand;
	}
	public int getMinute_hand() {
		if(minute_hand<0 && minute_hand>59)
			return 0;
		else
		return minute_hand;
	}
	public int getSecond_hand() {
		if(second_hand <0 && second_hand>59)
			return 0;
		else
		return second_hand;
	}
	
	public void print_clock() {
		System.out.println(hour_hand+"시"+ minute_hand + "분" +second_hand+"초");
	}
	public void set_clock() {
		
	}
}
