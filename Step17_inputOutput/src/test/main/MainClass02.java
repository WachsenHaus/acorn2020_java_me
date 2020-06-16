package test.main;

import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		
		try {
			System.out.println("입력 : ");
			//한글의 코드값도 읽어 들일 수 있다. (2바이트 처리)
			int a = isr.read();
			System.out.println("code : " + a);
			char ch = (char)a;
			System.out.println("char : " + ch);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
