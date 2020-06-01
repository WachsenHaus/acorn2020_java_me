package Test.main;

import Test.mypac.*;

public class MainClass04 {
public static void main(String[] args) {
	MyObject obj1 = new MyObject();
	Car c1 = obj1.getCar();
	//useSome() 메소드를 호출해보세요.
	obj1.useSome("최영훈",c1);
	c1.drive();
	
	
//	Radio r1 = obj1.getRadio();
//	Speaker s1 = obj1.getSpeaker();
	
	
//	obj1.doSome(r1, s1);
}
}
