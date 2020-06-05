package test.main;
import test.human.*;
public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * 독서프로그래밍 해보세요
		 */
		
		new Women(new Blood("+", "O")).reading();
		
		Women w1 = new Women(new Blood("+", "A"));
		w1.reading();
		
		Blood b1 = new Blood("-","AB");
		
		Women w2 = new Women(b1);
		w2.reading();
		
		Women wonderWomen;
		wonderWomen = w2;
		wonderWomen.reading();
		
		
		
		
	}

}
