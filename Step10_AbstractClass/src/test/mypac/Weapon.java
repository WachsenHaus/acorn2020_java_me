package test.mypac;

public abstract class Weapon {
	/*
	 * 미완성된 추상 메소드를 멤버로 가지고 있는 클래스는 
	 * abstract 예약어를 붙여서 정의해야 한다.
	 * 
	 */
		public void prepare() {
			System.out.println("무기 작동을 준비 합ㄴ디ㅏ.");
		}
		// abstract 예약어를 붙여야한다.
		
		public abstract void attack();
}
