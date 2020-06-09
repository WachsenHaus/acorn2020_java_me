package test.main;

import test.mypac.Weapon;

public class MainClass07 {
	//run 했을 때 실행순서가 시작되는 특별한 main 메소드
	//어나니머스 로컬 이너 클래스. 
	//이너클래스는 = 메소드안에 클래스가 생성된것.
	//weapon 추상 클래스를 상속받은 익명의 local inner class
	//의 생성자를 호출해서 weapon type의 참조값 얻어내서 지역변수 w1에 담기
	
	public static void main(String[] args) {
		Weapon w1 = new Weapon() {

			//익명의 지역클래스를 이용해서 생성함.
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("아무나공격해요!");
			}};
		Weapon w2 = new Weapon() {

			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("공중공격을합니다.");
			}
		
		};
		useWeapon(w1);
		useWeapon(w2);
		useWeapon(new Weapon() {

			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("지상 공격을해요 ");
			}
		});
	}
	
	public static void useWeapon(Weapon w)
	{
		w.prepare();
		w.attack();
	}
}
