package test.main;

import java.io.IOException;
import java.io.InputStream;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * 키보드와 연결된 인풋스트림 타입의 참조값을 kbd라는 지역변수에 담기
		 * 인풋스트림 객체는 1바이트 단위 처리 스트림이다.
		 * 영문자 대소문자,숫자,특수문자만 처리할 수 있다.
		 * 한글 처리 불가.
		 */
		InputStream kbd = System.in;
		System.out.println("입력 : ");
		try {
			int a = kbd.read();
			char ch = (char)a;
			System.out.println("code: " + a);
			System.out.println("code: " + ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
