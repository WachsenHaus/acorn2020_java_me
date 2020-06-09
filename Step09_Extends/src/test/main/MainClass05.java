package test.main;

import test.myPac.*;

public class MainClass05 {
	public static void main(String[] args) {
		// 스마트폰 객체를 생성해서 폰타입 지역변수 p1이라는 지역 변수에 담기
		Phone p1  = new SmartPhone();
		
		
		//p1에 들어있는 참조값을 이용해서 전화를 걸고 싶다면 ? 
		p1.call();
		//p1에 들어있는 참조값을 이용해서 이동중에 전화를 걸고 싶다면 ? 
		
		//p1에 들어 있는 참조값을 핸드폰 타입 지역변수에 캐스팅 해서 담는다.
		HandPhone p2 = (HandPhone)p1;
		p2.mobileCall();
		SmartPhone p3 = (SmartPhone)p1;
		p3.doInternet();
		
	}
}
