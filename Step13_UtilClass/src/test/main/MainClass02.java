package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		
		//
		int size = a.size();
		
		//10을가져와 변수에 할당한다.
		int num1 = a.get(0);
		
		//주소값을 할당한다.
		Integer num2 = a.get(1);
		
		
		//값을 할당한다.30
		int num3 = a.get(2);
		
		//1번인덱스를 40으로 변경한다.
		a.set(1,40);
		
		//1번 인덱스를지운다.
		a.remove(1);
		
		//전부지운다
		a.clear();
	}
		
}
