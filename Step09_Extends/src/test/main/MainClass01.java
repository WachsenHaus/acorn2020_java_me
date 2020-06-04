package test.main;

import test.myPac.*;

public class MainClass01 {
	public static void main(String[] args) {
		Phone p1 = new Phone();
		Object p2 = new Phone();
		HandPhone p3 = new HandPhone();
		Phone p4 = new HandPhone();
		Object p5 = new HandPhone();
		p1.call();
		p3.call();
		p3.mobileCall();
		p4.call();
		p5.toString();
		
		Object qq = new Object();
		Phone p6 = p3;
		HandPhone p7 = p3;
		Object ss = p5;
		HandPhone zz = (HandPhone)p5;
		zz = (HandPhone)qq;
		qq = zz;
		
		
		
		zz.mobileCall();
		
		
		p7.mobileCall();
	}
}
