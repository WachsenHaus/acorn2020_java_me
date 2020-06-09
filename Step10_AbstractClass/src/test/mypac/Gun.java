package test.mypac;

public class Gun extends Weapon {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("총을 쏩니다.");
	}
	
	public void reload()
	{
		System.out.println("장전합니다");
	}

}
