package test.main;
import test.mypac.*;


public class MainClass01 {
	public static void main(String[] args) {
		//추상클래스는 자식클래스를 필요로한다.
		
		MyWeapon w1 = null;

		w1 = new MyWeapon(); //인스턴스화 할 수 없네요 ?
		w1.prepare();
		w1.attack(); //문법 오류는 없내요 w1은 널인데
		w1.PowerAttack();
		
		
		
		
	}
}
