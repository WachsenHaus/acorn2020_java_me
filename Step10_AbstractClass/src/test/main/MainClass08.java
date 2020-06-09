package test.main;

import test.mypac.Weapon;

public class MainClass08 {
	
	//클래스의 필드에 weapon type의 참조값 넣어두기
	static Weapon w1 = new Weapon() {

		@Override
		public void attack() {
			// TODO Auto-generated method stub
			System.out.println("이건 반칙이야");
		}};
	
	//스태틱 메소드 안에서는 스태틱 자원만 사용이 가능하다.
	
	
	public static void main(String[] args) {
		//필드에 저장된 weapon type의 참조값을 이용해서 useWeapon()메소드 호출하기
		useWeapon(w1);
		
	}
	public static void useWeapon(Weapon w)
	{
		w.prepare();
		w.attack();
	}
}
