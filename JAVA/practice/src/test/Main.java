package test;

import practice.Fighter;

public class Main {
	public static void main(String[] args) {
		Fighter hero = new Fighter("Hero");
		Fighter hero2 = new Fighter("hero2");
		while(hero.getHp()>0 && hero2.getHp() > 0) {
			try {
			hero.hit(hero2);
			hero2.hit(hero);
			Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println(hero.getHp());
		System.out.println(hero2.getHp());
	}
}
