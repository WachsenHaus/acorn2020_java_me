package test.main;

import java.util.Scanner;

public class MainClass02 {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("나눌수 입력 : ");
		String inputNum1 = scan.nextLine();
		System.out.println("나누어 지는 수 입력");
		String inputNum2 = scan.nextLine();
		
		try {
			double num1 = Double.parseDouble(inputNum1);
			double num2 = Double.parseDouble(inputNum2);
			double result  = num2/num1;
			
	
			if(Double.isInfinite(result)) {
				result = 0.0;
			}
			if(Double.isNaN(result)) {
				result = 0.0;
			}
			result = Double.isInfinite(result) ? 0.0 : Double.isNaN(result)? 0.0:result;
			//if문이 가독성이 더 좋은듯.
			
			System.out.println(num2 + "를"  + num1 + " 으로 나누면 : " + result);
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("숫자를 입력하세요");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			System.out.println("main 메소드를 종료합니다.");	
		}
	}
}
