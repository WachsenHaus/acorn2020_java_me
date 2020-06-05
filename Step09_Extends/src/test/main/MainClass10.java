package test.main;

import test.human.*;

public class MainClass10 {
	
	public static void main(String[] args) {
		//Blood 객체를 생성해서 참조값을 b1이라는 지역 변수에 담아 보세요.
		Blood b1 = new Blood("+","O");
		
		String myRh = b1.getRh();
		System.out.println(myRh);
		b1.setRh("-");
		
		//자바 스크립트라면
		// let b1 = { rh:"+", type:"O"};
		// let b2 = { rh:"-", type:"A"};
		System.out.println(b1.getRh());
				
		
	}
}
