package test.mypac;

public class Computer {
//필드
	public Cpu cpu;
	public Computer (Cpu cpu) {
		this.cpu = cpu;
	}
	
	public void doGame() {
		if(this.cpu == null)
		{
			System.out.println("cpu가 없어서 컴퓨터가 동작을안해요");
			return;
		}
			System.out.println("컴퓨터로 게임을 해요!");
	}
}
