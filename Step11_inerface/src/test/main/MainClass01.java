package test.main;

import test.mypac.*;
public class MainClass01 {
	public static void main(String[] args) {
		//	Remocon r1 = null; //인터페이스는 생성가 필요없다.
//		Remocon r1 = new Remocon(); //오류가 나온다
		Remocon r1 = new MyRemocon(); //오류가 나온다
		MyRemocon r2 = new MyRemocon();
			
		r1.down();
		useRemocon(r1);
		useRemocon(r2);
	}

	public static void useRemocon(Remocon r1)
	{
		r1.up();
		r1.down();
	}
}
