package test.main;
import java.util.Random;
import java.util.Scanner;

import test.mypac.*;
public class MainClass06 {



	public static void main(String[] args) {
		/*
		 * scanner 객체를 이용해서 문자열을 5번 입력 받는다.
		 * 입력 받은 문자열은 차례대로 배열에 저장되어야 한다.
		 * 모두다 입력 받은후 for문을 이용해서 배열에 저장된 
		 * 모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해보세요.
		 */
		Scanner inputKeyboard = new Scanner(System.in);
		String[] myString = new String[5];
		inputStirngData(myString,inputKeyboard);
		printStringData(myString);
	
		
	
		
		
	}
	

	
	public static void inputStirngData(String[] mStringArray, Scanner scan)
	{		
		for(int i = 0; i < mStringArray.length; i++)
		{
			System.out.println(i + "번째 문자열을 입력중입니다. " + (i+1)+"/5");
			mStringArray[i] = scan.nextLine();
		}
 	}
	public static void printStringData(String[] mStringArray)
	{
		for(int i = 0; i<mStringArray.length; i++ )
		{
			System.out.print(mStringArray[i] + " ");
			if(i == mStringArray.length - 1)
			{
				System.out.println();
			}
		}
	}
	

}
