package test.auto;

public class SportsCar extends Car{

	public SportsCar(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
	}
	
	//메소드
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		/*
		 * 오버라이드 한 부모 메서드를 호출해야 할지 말지는 
		 * 상황에 따라 다르다.
		 * 어떤 경우에는 부모의 메소드를 호출해 주지 않으면 객체가 제대로 동작을 안하는 경우가있다.
		 * 그런 경우에는 부모의 메소드를 반드시 호출해 주어야 한다.
		 * 
		 */
		super.drive();
	}
}
