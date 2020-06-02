package test.main;
import java.util.Random;

import test.mypac.*;
public class MainClass05 {

	public static void main(String[] args) {
		// 1. rec색체를 담을 수 있는 방 3개짜리 배열객체를 생성해서 참조값을 rects라는 이름의
		// 지역 변수에 담아보세요
		Rect[] rects = new Rect[3];
		Random r = new Random();
		
			
		//2. 배열에 rect객체 3개를 순서대로 담아보세요.
		rects[0] = new Rect(20,5);
		rects[1] = new Rect(10,3);
		rects[2] = new Rect(30,10);
		//3. 반복문 for문을 이용해서 각각 4각형의 면적을 콘솔창에 출력해보세요.
		for(int i =0; i<rects.length; i++)
		{
//			rects[i] = new Rect(r.nextInt(7
			)+1,r.nextInt(10)+1);	
			System.out.println(rects[i].getArea());
		}
		
	}
}
