package test.human;

public class Men extends Person {

	public Men(Blood blood) {
		super(blood);
		// TODO Auto-generated constructor stub
	}
	
	public void seeMovie()
	{
		System.out.println("영화를 봐요");
	}
	
	public void upgrade()
	{
		Brain.upgrade();
	}
	
	
}
