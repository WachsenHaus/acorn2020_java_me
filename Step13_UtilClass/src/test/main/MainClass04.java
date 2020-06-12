package test.main;
import java.util.ArrayList;
import java.util.List;

import test.mypac.*;

public class MainClass04 {

	public static void main(String[] args) {
		//1.카 타입을 저장할 수 있는 arraylist 객체를 생성해서
		//참조값을 리스트 인터페이스 타입 지역변수 cars에 담아보세요
		List<Car> cars = new ArrayList<>();
		
		// 2.car객체3개를 생성해서 list 객체에 저장해보세요
		cars.add(new Car("황금마티즈"));
		cars.add(new Car("보급관마티즈"));
		cars.add(new Car("모닝"));
		Car c1 = new Car("마티즈");
		cars.add(c1);
		//3. 반복문 for 문을 이용해서 List 객체에 저장된 모든 Car 객체의 drive() 메소드를 순서대로 호출해보세요.
		for(Car i : cars)
		{
			i.drive();
		}
	}
}
