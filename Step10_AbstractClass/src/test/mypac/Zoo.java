package test.mypac;

public class Zoo {

	public Monkey getMonkey() //내부 클래스로 객체를 생성해서 리턴해주는 메소드
	{
		return new Monkey();	
	}
	public Tiger getTiger()
	{
		return new Tiger();
	}
	
	public class Monkey //내부클래
	{
		public void say()
		{
			System.out.println("안녕 나는 원숭이야");
		}
	}
	
	public class Tiger
	{
		public void say()
		{
			System.out.println("안녕 나는 호랭이야");
		}
	}
}


