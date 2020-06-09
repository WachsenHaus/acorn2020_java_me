package test.main;

public class MainClass04 {

	public static String aa = "당연";
	public String bb= "non static이지롱";
	
	public static void main(String[] args) {
		
		//헉! 메소드 안에서도 클래싀 정의 가능 ? 
		// 클래스 안에 만든 클래스 : inner class
		// 메소드 안에 만든 클래스 : local inner class
		
		class Gura{
			public void say()
			{
				System.out.println("안녕 나는 구라야");
			}
		}
		
		Gura g1 = new Gura();
		g1.say();
	}
	
}
