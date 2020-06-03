package test.main;

import java.util.Random;

public class MainClass07 {
public static void main(String[] args) {
	/*
	 * random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내서 배열에 저장한다.
	 * 모두다 저장이 되면 for문을 이용해서 배열에 저장된 모든 로또 번호를
	 * 콘솔창에 순서대로 출력하는 코드를 작성하세요.
	 * 
	 */
	int[] myLuckNum = getLottoNumber();
	bubleSort(myLuckNum);
	printLottoNumber(myLuckNum);
//	for(int i =0; i<myLuckNum.length; i++)
//	{
//		System.out.println(i);
//	}

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

}
