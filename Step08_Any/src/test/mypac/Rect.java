package test.mypac;

public class Rect {

	public int width;
	public int height;
	
	public Rect(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	
	public int getArea() {
		return width* height;
	}
}
