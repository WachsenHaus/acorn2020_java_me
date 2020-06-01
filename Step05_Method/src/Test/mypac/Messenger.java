package Test.mypac;

public class Messenger {
	public static void sendMessage(String msg)
	{
		System.out.println(msg + " 를 전송합니다.");
	}
	public static String getMessage() {
		return "hello";
	}
	public static void useCar(Car c)
	{
		c.drive();
	}
	
}
