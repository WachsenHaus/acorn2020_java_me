package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	//inner class로 weapon 추상 클래스 상속 받기
	public  class Knife extends Weapon{

		@Override
		public void attack() {
			// TODO Auto-generated method stub
		 System.out.println("쓲싺");	
		}
		
	}
	public static class YourWeapon extends Weapon{

		@Override
		public void attack() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		/*
		 * useWeapon() 메소드를 호출하는게 목적
		 * 호출하려고보니 weapon 추상 클래스 type 객체의 참조값이 필요하다.
		 * 따라서 Weapon 추상클래스를 상속받은 클래스를 파일로 만들어야 된다.
		 * 근데 불금이다 만사가 귀찮다. 클래스를 파일로 만들기 싫다
		 * 내부 클래스로 만들고싶다.
		 */
		
	
		Weapon w1 = new YourWeapon();
		useWeapon(w1);
		
		//local inner class도 이용해 보자
		class OurWeapon extends Weapon
		{
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("이제 그만 공격하자");
			}
		}
		OurWeapon o1 = new OurWeapon();
		useWeapon(o1);
	
	}
	
	public static void useWeapon(Weapon w)
	{
		w.prepare();
		w.attack();
	}
}
