package test.main;

import java.util.Random;

public class MainClass10 {

	/*
	 * 체리 | 체리 | 체리
	 * 10점입니다.
	 * 
	 * 사과 | 사과 | 사과
	 * 20점입니다.
	 * 
	 * 7 | 7 | 7
	 * 1000점입니다.
	 * 
	 * 사과 | 체리 | 애플
	 * 0점입니다.
	 */
	
	
	static Random r = new Random();
	static String[] myStrData = {"cherry","apple","banana","melon","7"};
	static int[] point = {10,20,30,40,1000};
	static int[] nums = new int[3];
	public static void main(String[] args) {
		
		//PrintString(GetRandom_Word(myStrData,1));
//		String[] myString = GetRandom_Word(myStrData,3);
		lottoGame();
	}
	
	public static void lottoGame()
	{
		nums = GetRandom_Word(myStrData,3);
		PrintString(nums);
		PrintString(GetPoint(nums));
	}
	
	public static int[] GetRandom_Word(String[] mArrayString, int Cnt)
	{
		int a[] = new int[Cnt];
		for(int i =0; i< Cnt; i++)
		{
			int getNum = r.nextInt(mArrayString.length);
			a[i] = getNum;
		}
		return  a;
	}
	public static String GetPoint(int[] arrayString) {
		String outputStr = "";
		String endStr ="점입니다.";
		if(arrayString[0] == arrayString[1] && arrayString[1] == arrayString[2]) {
			int pt = point[arrayString[0]];
			outputStr = pt + endStr;
		}
		else
		{
			outputStr = "0"+ endStr;
		}
		return outputStr;
	}
	public static void PrintString(int[] a) {
//		String outputStr = "";
		for(int i =0; i< a.length; i ++)
		{
			try {
				//실행의 흐름을 1초 잡아놓기
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i<a.length-1) {
				System.out.print(myStrData[a[i]] + " | ");
			}
			else
			{
				System.out.println(myStrData[a[i]]);
			}
		}
	}
	public static void PrintString(String a) {
		System.out.println(a);
	}
}

