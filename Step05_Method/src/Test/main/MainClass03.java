package Test.main;

import Test.mypac.*;

public class MainClass03 {

	public static void main(String[] args) {
		
		MyObject obj1 = new MyObject();
		Car c1 = obj1.getCar();
		Car c2 = obj1.getCar();
		Car c3 = obj1.getCar();
		Car c4 = obj1.getCar();
		//.setNum(), setName(), .useCar() 메소드를 호출해보세요.
		obj1.setNum(10);
		obj1.setName("최영훈");
		obj1.useCar(c1);
	}
}
