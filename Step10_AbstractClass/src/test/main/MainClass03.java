package test.main;

import test.mypac.*;
import test.mypac.Zoo.*;


public class MainClass03 {
	public static void main(String[] args) {
		
		//주 클래스에 있는 getmonkey()메소드 호ㅊㄹ해서
		//리턴되는 값을 m1이라는 지역 변수에 담아보세요
		
		Zoo zoo = new Zoo();
		
		Monkey m1 = zoo.getMonkey();
		m1.say();
		// zoo클래스에 있는 getTiger() 메소드를 호출해서
		//리턴되는 값을 t1이라는 지역 변수에 담아 보세요.
		
		Tiger t1 = zoo.getTiger();
		
		t1.say();
	}
}
