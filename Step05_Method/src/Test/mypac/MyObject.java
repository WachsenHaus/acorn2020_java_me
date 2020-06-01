package Test.mypac;

/*
 * [ 메소드를 만들 때 고려 해야 하는 것 ]
 * 
 * 1. 접근 지정자
 * 2. 리턴 type
 * 3. 메소드명
 * 4. 메소드에 전달하는 인자의 갯수와 data type
 * 
 * 
 */
public class MyObject {
	
	/*
	 * public -> 이 메소드는 어디에서든 접근가능하다.
	 * void => 이 메소드는 어떤값도 리턴하지 않는다.
	 * walk => 메소드 명
	 * walk() => 이 메소드는 어떤값도 전달받지 않는다.
	 */
	public void walk()
	{
		System.out.println("걸음을 걸어요");
	}
	public int getNumber()
	{
		int myNum = 10;
		
		return myNum;
	}
	
	public String getString()
	{
		String greet = "안녕";
		return greet;
	}
	
	//Car type 을 리턴해주는 메소드
	public Car getCar()
	{
		return new Car();
	}
	
	// int type을 메소드의 인자로 전달 받는 메소드
	public void setNum(int num)
	{
	System.out.println("num:" + num);	
	}
	
	// String type을 메소드의 인자로 전달 받는 메소드
	public void setName(String name)
	{
		System.out.println("name:" + name);
	}
	
	public void useCar(Car car)
	{
		car.drive();
	}
	
	public void useSome(String name,Car car)
	{System.out.println("name : " + name);
	car.drive();
		
	}
	
//	public Radio getRadio()
//	{
////		return new Radio();
//	}
	public Speaker getSpeaker()
	{
		return new Speaker();
	}
	
	//라디오 타입과 스피커타입을 전달 받는 메소드.
	public void doSome(Radio r, Speaker s)
	{
		System.out.println("doSome() 메소드가 호출되었습니다.");
	}
}
