package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass14 {
	public static void main(String[] args) {
		//이미 만들어 졌거나혹은 만들 예정인 파일을 access 할 수 있는 file 객체
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");

		try {
			BufferedReader in = new BufferedReader(new FileReader(memoFile));
			while(true)
			{
				String code = in.readLine();
				if(code== null) //더이상읽을코드가없으면
				{
					break;
				}
				//코드값에 해당되는 문자.
				
				//콘솔창에 개행기호 없이 한글자 한글자 출력하기
				System.out.println(code);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

