package test.main;
import test.auto.*;
import test.myPac.*;

public class MainClass08 {
	public static void main(String[] args) {
		//Truck 객체를 생성해서. dirve() .dump()메서드를 호출해보세요
		Truck benz = new Truck(new Engine());
		benz.drive();
		benz.dump();
		//benz.a = 20; //프로텍티드 // 상속자 가아니라서 안됌
//		benz.c = 20; //퍼블릭
		//benz.d = 20; // 디폴트 패키지가 달라서안됨
		SportsCar astonMartin = new SportsCar(new Engine());
		astonMartin.drive();
		astonMartin.drive();
		astonMartin.drive();

	}
	
	
}
