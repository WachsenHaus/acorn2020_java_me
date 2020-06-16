package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		//한번에 여러글자를 읽어들여서 
		
		BufferedReader br = new BufferedReader(isr);
		
		try {
			System.out.println("입력 : ");
			String a = br.readLine();
			System.out.println(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
