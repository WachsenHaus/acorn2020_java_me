package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력");
		String inputNum = scan.nextLine();
		
		try {
			double num = Double.parseDouble(inputNum);
			double result = num+100;
			System.out.println("입력한 숫자 + 100 :" + result);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			//예외정보를 출력하기
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
