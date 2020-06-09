package test.main;

import test.mypac.*;
import test.mypac.FruitBox;

public class MainClass01 {
	public static void main(String[] args) {
		//제네릭 클래스를 다양하게 지정을 해서 객체 생성하고 참조값을 담을 수 있다.
		FruitBox<Apple> a = new FruitBox<Apple>();
		FruitBox<Banana> b = new FruitBox<Banana>();
		FruitBox<Orange> o = new FruitBox<Orange>();

		//generic 클래스로 지정한 타입 객체를 넣어 주어야 한다.
		a.push(new Apple());
		b.push(new Banana());
		o.push(new Orange());
		
		//제네릭 클래스로 지정한 type 객체가 리턴된다.
		Apple result1 = a.pull();
		Banana result2 = b.pull();
		Orange result3 = o.pull();
		
		


		

		
		
		
		
	}
}
