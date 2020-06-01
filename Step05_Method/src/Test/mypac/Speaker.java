package Test.mypac;

public class Speaker {

	
	private int volume = 5;
	
	
	
	public void upVolume()
	{
		volume = (volume <=10) ? ++volume:volume;
	}
	public void downVolume()
	{
		volume = (volume <=0) ? --volume:volume;
	}
	public void getVolume()
	{
		System.out.println("현재 볼륨은 : " + volume);
	}
	
	
}
