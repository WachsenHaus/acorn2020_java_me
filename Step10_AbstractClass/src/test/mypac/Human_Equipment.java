package test.mypac;

public class Human_Equipment {

	Knife myKnife = null;
	public Human_Equipment(Knife knife)
	{
		this.myKnife = knife;
	}
	
	public void getEquip()
	{
		myKnife.getStatus();
	}
	public void useEquip()
	{
		myKnife.use();
	}
}
