package test.mypac;

/*
 * 클래스를 정의할 때 generic type을 지정해서 특정 type을 동적으로 지정할 수 있다.
 */

//fruit나 처럼 generic type을 지정하지 않으면 Object로 디폴트로 지정된다.
public class FruitBox<fruit> {
	//필드
	private fruit item;
	//메소드
	public void push(fruit item)
	{
		this.item = item;
	}
	public fruit pull()
	{
		return item;
	}
	
}
