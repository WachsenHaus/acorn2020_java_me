package test.main;

import java.util.Scanner;

public class MainClass12 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("종료 (q) 계속(Enter)");
			String str = scan.nextLine();
			if(str.equals("q"))
			{
				break;
			}
			MainClass10.lottoGame();
			System.out.println("무언가 작업합니다.");
		}
		System.out.println("메인메소드가 동작중입니다.");
		scan.close();
	}
}
