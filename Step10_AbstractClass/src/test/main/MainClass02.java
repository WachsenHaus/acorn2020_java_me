package test.main;

import test.mypac.*;
import test.mypac.Weapon;

public class MainClass02 {
	
	public static void main(String[] args) {
		/*
		 * 여러분이 직접 클래스를 만들고 객체 생성을 해서 아래의 useWeapon()메소드를 호출해 보세요.
		 * 
		 */
		Gun myGun = new Gun();
		MainClass02.useWeapon(myGun);
		Weapon w1 = new Gun();

		
		Cook_Knife cookKnife = new Cook_Knife();
		Murder_Knife murderKnife = new Murder_Knife();
		
		Human_Equipment CYH = new Human_Equipment(cookKnife);
		Human_Equipment KIM = new Human_Equipment(murderKnife);
		
		CYH.getEquip();
		KIM.getEquip();
		
		CYH.useEquip();
		KIM.useEquip();
		byte aa = 10; //훨씬작음
		
		double dd = 20; //훨씬큼
		
		
//		www(aa);
////		www(dd);
//		Object o1 = new Gun(); 
//		
//		useWeapon(o1);
		
	}
	public static void www(int i)
	{
		System.out.println(i);
	}
	
	public static void useWeapon(Weapon w)
	{
		System.out.println("asd");
//		w.prepare();
//		w.attack();
	}
}
