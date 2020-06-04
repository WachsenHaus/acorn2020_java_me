package test.auto;

public class Car {
	//필드
	private Engine engine;
	protected int a = 10;
	private int b = 10;
	public int c = 10;
	int d = 10;
	
	//protected int aaaa; //상속자들끼리
	//private //오로지 그 클래스안에서만
	//public 어디서든 
	//default 해당 패키지안에서 공유
	
	//engine 객체를 인자로 전달 받은 생성자
	public Car(Engine engine) {
		//필드에 저장하기
		this.engine = engine;	
	}
	
	public void drive()
	{
		if(engine == null)
		{
			System.out.println("엔진 객체가 없어서 달릴 수 없어요");
			return; //메소드 끝내기.
		}
		System.out.println("달려요");
		engine.disLife();
	}
}
