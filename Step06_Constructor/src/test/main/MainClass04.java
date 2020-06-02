package test.main;

import java.util.Random;

public class MainClass04 {
public static void main(String[] args) {
	Random ran = new Random();
	
	
	System.out.println(Math.abs(ran.nextInt(50))); //0~49 출력임.
	
	//1에서 45까지 랜덤수를 구하는것은
	System.out.println(Math.abs(ran.nextInt(45)+1));
}
}
