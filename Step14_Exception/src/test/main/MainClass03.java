package test.main;

import java.io.File;
import java.io.IOException;

/*
 * RuntimeExceptioon을 상속받지 않는 Exception은 
 * 반드시 try catch블럭으로 묶어서 예외 처리를 해야한다.
 */
public class MainClass03 {
	public static void main(String[] args) {
		
		System.out.println("메소드 시작");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		File f1 = new File("c:/myFolder/test.txt");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메소드가 종료됩니다.");
	}
}