package test.main;
import test.mypac.*;

public class MainClass02 {
	public static void main(String[] args) {
		
//		Remocon r3 = null;/
		Remocon r3= new Remocon() {

			@Override
			public void up() {
				// TODO Auto-generated method stub
				System.out.println("나에게 왜그러시오");
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				System.out.println("가만히 두시오 제발..");
			}
			
		};

		/*
		 * remocon 인터페이스를 구현한 익명의 local inner 클래스의 생성자를 호출해서 참조값을 얻어내, remocon type의 지역변수 r1에 대입하기
		 * 자동으로 extends처럼 인터페이스라면 implement처리를한다. 신기하군. 
		 */
		
		Remocon r1 = new Remocon() {

			@Override
			public void up() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				
			}};
		
		useRemocon(r1);
		useRemocon(new Remocon() {

			@Override
			public void up() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void down() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public static void useRemocon(Remocon r1)
	{
		r1.up();
		r1.down();
	}
}
