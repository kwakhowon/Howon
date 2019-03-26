/*
에어컨 시나리오
에어컨은 제조회사 , 가격 , 바람의 세기를 가지고 있다. o
에어컨이 만들어지면 제조회사와 가격을 가지고 있어야한다. pass
특정 기능을 통해서만 볼 수 있고 , 만들어진 이후에는 수정이 불가하다. pass
에어컨의 바람의 세기는 사용자가 정할 수 있다.	pass
에어컨 각각의 제조회사와 가격정보를 읽을 수 있다. pass
*/

package practice;

public class Aircontroller {
	private String company;
	private int price;
	private int power;
	
	public Aircontroller(String company , int price) {
		this.company = company;
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPower(int power) {
		this.power = power;
	}

	public void AircontrollerInfo() {
		System.out.println("제조회사 : " +this.company);
		System.out.println("가격 : " +this.price);
	}
}
