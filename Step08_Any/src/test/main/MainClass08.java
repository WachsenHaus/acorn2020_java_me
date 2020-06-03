package test.main;

import java.util.Random;

public class MainClass08 {

	/*
	 * cheery, apple, banana, melon, 7
	 * 
	 * 5개의 문자열중에서 하나가 랜덤하게 출력되게 해 보세요.
	 * 
	 * 
	 * 5개의 문자열 중에서 3개가 한줄에 한 번에 랜덤하게 출력되게 해 보세요.
	 * 
	 * 예) cheery | apple | cherry
	 *     7  	  | aplle | mellon
	 *     7      | 7     |  7
	 */
	
	static Random r = new Random();
	public static void main(String[] args) {
		String[] myStrData = {"cherry","apple","banana","melon","7"};
		
		PrintString(GetRandom_Word(myStrData,1));
		
		PrintString(GetRandom_Word(myStrData,3));
	}
	
	public static String[] GetRandom_Word(String[] mArrayString, int Cnt)
	{
		String[] dummy = new String[Cnt];
		for(int i =0; i< dummy.length; i++)
		{
			int getNum = r.nextInt(mArrayString.length);
			dummy[i] = mArrayString[getNum];
		}
		return dummy;
	}
	public static void PrintString(String[] a) {
		String outputStr = "";
		for(int i =0; i< a.length; i ++)
		{
			if(i<a.length-1) {
				outputStr += a[i] + " | ";	
			}
			else
			{
				outputStr += a[i];
			}
		}
		System.out.println(outputStr);
	}
}
