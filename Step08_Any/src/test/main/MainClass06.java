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
	
		
		/*
		 * random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내서 배열에 저장한다.
		 * 모두다 저장이 되면 for문을 이용해서 배열에 저장된 모든 로또 번호를
		 * 콘솔창에 순서대로 출력하는 코드를 작성하세요.
		 * 
		 */
		int[] myLuckNum = getLottoNumber();
		bubleSort(myLuckNum);
		printLottoNumber(myLuckNum);
		
		
	}
	
	public static int[] getLottoNumber()
	{
		int[] newNum = new int[6];
		Random r = new Random();
	   for (int i = 0; i < newNum.length; i++) {
		   int num = r.nextInt(45)+1;
		   newNum[i] = num;
	        for (int j = 0; j < i; j++) {
	            if (newNum[i] == newNum[j]) {
	                i--;
	            }
	        }
	    }

		return newNum;
	}
	public static void bubleSort(int[] arr) {
	    for(int i = 0; i < arr.length; i++) {
	        for(int j = 0 ; j < arr.length - i - 1 ; j++) {
	            if(arr[j] > arr[j+1]) {
	                int temp = arr[j+1];
	                arr[j+1] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	}

	public static void printLottoNumber(int[] ltNum)
	{
		for(int i =0; i< ltNum.length; i++)
		{
			System.out.print(ltNum[i] + " ");
		}
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
