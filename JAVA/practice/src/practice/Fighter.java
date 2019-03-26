//웅은 다음과 같은 속성을 갖는다. 
//이름 , 체력
//영웅은 펀치를 통해 상대 영웅에게 피해를 입힐 수 있다.
package practice;

public class Fighter {
	private String name;
	private int hp = 100;
	
	public Fighter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public void hit(Fighter energy) {
		energy.hp -= 10;
		System.out.printf("[%s]의 펀치 \n", this.name);
		System.out.printf("%s의 남은 체력 : %d/100", this.name, energy.hp);
	}
	
	
}
