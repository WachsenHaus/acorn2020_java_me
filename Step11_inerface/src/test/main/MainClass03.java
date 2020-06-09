package test.main;

import test.mypac.*;

public class MainClass03 {
	public static void main(String[] args) {
		
		Remocon r1 = new MyRemocon();
		MainClass03.useRemocon(r1);
		Remocon r2 = new Remocon() {

			@Override
			public void up() {
				// TODO Auto-generated method stub
				System.out.println("올린다");
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				System.out.println("내린다");
			}
		};
		useRemocon(r2);
		useDrill(new Multiplayer());
		useMultiPlayer(new Multiplayer());
	}
	public static void useRemocon(Remocon r1)
	{
		r1.up();
		r1.down();
	}
	
	public static void useDrill(Drill d1) {
		d1.hole();
	}
	
	public static void useMultiPlayer(Multiplayer mp)
	{
		mp.up();
		mp.down();
		mp.hole();
	}
}
