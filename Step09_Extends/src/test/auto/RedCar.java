package test.auto;

public class RedCar  extends Car{

	public RedCar(Engine engine) {
		super(engine);
		// TODO Auto-generated constructor stub
		System.out.println("세계 최고의 자동차가 만들어졌습니다.");
	}
	
	public void boost()
	{
		System.out.println("지구에서 가장빠른속도로 달립니다.");
	}

}
