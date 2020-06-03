package test.main;

import java.util.Random;
import java.util.Scanner;

/*
 * 컴퓨터와 가위 바위 보 하기
 * 
 * 가위 (s) 바위(r) 보(p) : s
 * 나 가위 vs 컴 : 보
 * win (draw or lose)~
 *가위는 0 바위는 1 보 는 2
 * 
 */
public class MainClass13 {
	
	public static Random r = new Random();
	public static Scanner s = new Scanner(System.in);
	
	public static int ComputerNum = 0;
	public static int MyNum = 0;
	public static String[] RSP = {"가위","바위","보"};
	public final static int SCISSORS = 0;
	public final static int ROCK = 1;
	public final static int PAPER = 2;
	
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다.");
		System.out.println("가위 : s, 바위 : r, 보 : p, 종료는 q를 누르세요");
		for(int i =3; i>0; i--)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		while(true)
		{
			System.out.println("안내면 진거 가위 바위 보~~~");
			String mInputStr = s.nextLine();
			ComputerNum = r.nextInt(3);
			boolean succInput = true;
			switch(mInputStr)
			{
				case "s":
					MyNum = SCISSORS;
					break;
				case "r":
					MyNum = ROCK;
					break;
				case "p" :
					MyNum = PAPER;
					break;
				default :
					System.out.println("잘못입력하셨어요");
					succInput = false;
					break;
			}
			if(succInput)
			{
				System.out.println("나 : " + RSP[MyNum] + " vs 컴 : " +RSP[ComputerNum]);
				if((ComputerNum == SCISSORS && MyNum == ROCK) || (ComputerNum == ROCK && MyNum == PAPER) || (ComputerNum == PAPER && MyNum == SCISSORS) )
				{
					System.out.println("내가 이겼다~");
				}
				else if(MyNum == ComputerNum)
				{
					System.out.println("비겼다~");
				}
				else
				{
					System.out.println("패배");
				}
				if(mInputStr.equals("q"))
				{
					System.out.println("종료되었습니다");
					return;
				}
			}
		}
	}
}
