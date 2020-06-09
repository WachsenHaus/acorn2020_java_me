package test.main;
import test.mypac.*;

public class MainClass02 {
	public static void main(String[] args) {
		//객체를 생성할때 Generic 클래스는 생략이 가능하다
		FruitBox<Apple> a =  new FruitBox<>();
		FruitBox<Banana> b =  new FruitBox<>();
		FruitBox<Orange> o =  new FruitBox<>();
		
		
		new FruitBox<Apple>().pull();
		
		
	}
}
