package test.auto;

public class Truck extends Car{
	protected int dd = 22;
	//엔진 객체를 생성자의 인자로 전달받은 메소드
	public Truck(Engine engine) {
		//자식생성자로 받은 객체를 부모 생성자에 전달해 주는 
		super(engine);
		// TODO Auto-generated constructor stub
	}
	
	public void dump()
	{
		a = 20; //프로텍티드
		c = 20; //퍼블릭
		d = 20; // 디폴트
		
		System.out.println("짐을 쏟아내요");
	}

}
