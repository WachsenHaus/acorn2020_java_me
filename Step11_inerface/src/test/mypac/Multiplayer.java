package test.mypac;

public class Multiplayer implements Remocon, Drill{

	@Override
	public void hole() {
		// TODO Auto-generated method stub
		System.out.println("책상에 구멍을 뚫어요");
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		System.out.println("온도를 올려요");
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		System.out.println("온도를 내려요");
	}

}
