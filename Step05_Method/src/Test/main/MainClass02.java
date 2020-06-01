package Test.main;

import Test.mypac.*;


public class MainClass02 {

	
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		Car c1 = obj1.getCar();
		Car c2 = obj1.getCar();
		Car c3 = obj1.getCar();
		
		c1.drive();
		c2.drive();
		c3.drive();
	}
}
