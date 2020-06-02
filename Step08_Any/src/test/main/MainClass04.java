package test.main;
import test.mypac.*;
public class MainClass04 {

	/*
	 * 1. Bike 객체를 담을 수 있는 방 3개짜리 배열객체를 생성해서 참조값을
	 * bikes라는 지역 변수에 담아 보세요.
	 * 2. 배열의 각각의 방 (0,1,2)에 Bike 객채를 생성해서 담아보세요.
	 * 3. 반복문 for문을 이용해서 배열의 각각의 방에 있는 Bike객체의
	 * ride() 메소드를 호출해보세요.
	 * 
	 */
	public static void main(String[] args) {
		Bike[] bikes = new Bike[3];
		bikes[0] = new Bike();
		bikes[1] = new Bike();
		bikes[2] = new Bike();
		for(int i = 0 ; i< bikes.length; i++)
		{
			bikes[i].ride();
		}
	}
}
