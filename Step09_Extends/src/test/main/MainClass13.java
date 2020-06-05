package test.main;

import test.human.*;

public class MainClass13 {

	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적 : 아래의 useMen() 메소드를 호출하는것
		 * 아래의 useMen() 메소드를 호출해 보세요.
		 */
		
		Men CYH = new Men(new Blood("+","O"));
		MainClass13.useMen(CYH);
	}
	
	public static void useMen(Men m)
	{
		m.walk();
		m.study();
		m.seeMovie();
	}
}
