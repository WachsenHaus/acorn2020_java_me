package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<String, String>();
		
		dic.put("house","집");
		dic.put("phone","전화기");
		dic.put("car","자동차");
		dic.put("pencil","연필");
		dic.put("eraser","지우개");
		
		
		/*
		 * 검색할 단어를 입력하세요  : house
		 * 
		 * house의 뜻은 집입니다.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 단어를 입력하세요");
		
		String inputTxt = scan.next();
		boolean isExist = dic.containsKey(inputTxt);
		if(isExist) {
			String getMean = dic.get(inputTxt);
			System.out.println(inputTxt + "의 뜻은 " + getMean + " 입니다." );
			System.out.println("프로그램을 종료합니다.");
			return ;
		}
		System.out.println("단어가 없습니다. 프로그램을 종료합니다.");
	}
}
