package test.main;

import java.util.Scanner;

public class MainClass05 {
public static void main(String[] args) {
	
	/*
	 * 프로그래밍의 목적 키보드로 부터 문자열을 입력 받고 싶다.
	 * 입력 받아서 무얼하나 ? 콘솔창에 출력한다.
	 */
	Scanner scan = new Scanner(System.in);

    System.out.println("메시지를 입력하세요:");
    
   String message = scan.nextLine();            // 키보드 문자 입력
    
    System.out.println("입력 메시지: \""+ message + "\"" + "길이 : " + message.length());


}
}
