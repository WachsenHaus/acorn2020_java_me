package test.auto;

public class Engine {

	private int life = 100;
	public void disLife()
	{
		life--;
		System.out.println("수명이줄었습니다." + life);
	}
}
