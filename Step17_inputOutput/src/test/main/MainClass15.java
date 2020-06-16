package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass15 {
	public static void main(String[] args) {
		//이미 만들어 졌거나혹은 만들 예정인 파일을 access 할 수 있는 file 객체
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);
			while(true)
			{
				String code = br.readLine();
				if(code== null) //더이상읽을코드가없으면
				{
					break;
				}
				System.out.println(code);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//마무리 작업을한다. 보통 열었던 스트림 객체를 닫는 작업을한다.	
			try {
				if(fr != null) fr.close();
				if(br != null) br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

