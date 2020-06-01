package Test.mypac;

public class Radio {

	public float hz = 0;
	public String name = "";
	
	public void broadCast()
	{
		System.out.println(name + "방송을 시작합니다~");	
	}
	
	public Radio(float mHz, String mName)
	{
		this.hz = mHz;
		this.name = mName;
	}
}
