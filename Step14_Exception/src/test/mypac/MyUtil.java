package test.mypac;

public class MyUtil {
	
	//메소드안에서 exception을 처리하는 경우
	public static void draw()
	{
		System.out.println("5초동안그림을그려요");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("그림완성!");
	}
	
	//메소드 안에서 발생하는 exception을 던져버리는 경우
	public static void send() throws InterruptedException
	{
		System.out.println("5초 동안 전송을 해요");
		System.out.println("전송 완료");
	}
}
