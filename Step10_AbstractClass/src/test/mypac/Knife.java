package test.mypac;

public abstract class Knife {

	public Knife() {
		System.out.println("칼을 손에 쥐었습니다.");
	}
	public void getStatus() {
		System.out.println("이 제품은 조선시대때 만들어졌습니다.");
	}
	public abstract void use();
	
}
