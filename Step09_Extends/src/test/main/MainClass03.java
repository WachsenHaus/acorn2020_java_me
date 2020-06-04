package test.main;
import test.myPac.*;
public class MainClass03 {
public static void main(String[] args) {
	//핸드폰 객체를 생성해서 핸드폰 타입 지역변수 p1에 담기
	SmartPhone p1 = new SmartPhone();
	//인터넷을 해야 한다 즉 스마트폰 타입 객체가 필요하다
	//p1 안에 있는 값을 이용해서 인터넷을 할 수 있을까?
	HandPhone p2 = p1;
//	p2.doInternet();
	
}
}
