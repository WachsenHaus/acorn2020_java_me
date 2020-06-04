package test.main;
import test.auto.*;
import test.myPac.*;
public class MainClass07 {
public static void main(String[] args) {
	SmartPhone p1 = new SmartPhone();
	Engine myCar_Engine = new Engine();
	Truck myCar = new Truck(myCar_Engine);
	myCar.drive();
	myCar.dump();
}
}
