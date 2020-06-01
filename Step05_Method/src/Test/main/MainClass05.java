package Test.main;

import Test.mypac.Radio;
import Test.mypac.Speaker;

public class MainClass05 {
	/*
	 * test.mypac 패키지에 다양한 모양의 메소드를 가지는
	 * 클래스를 정의하고
	 * 그 클래스를 이용해서 객체도 생성하고 여러가지 메소드를 호출
	 * 
	 */
	public static void main(String[] args) {
		Radio r1 = new Radio(91.9f,"태연의 친한친구");
		Speaker s1 = new Speaker();
		
		r1.broadCast();
		s1.getVolume();
		s1.upVolume();
		s1.upVolume();
		s1.upVolume();
		s1.getVolume();
	}

	
	
	

	
	
	
	
}
