package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz1 {
	public static Scanner sc = new Scanner(System.in);
	public static File memoFile = new File("c:/acorn2020/myFolder/quiz.txt");
	public static FileWriter fw;
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 문자열 한줄을 입력 받은 다음
		 * c:/acorn2020/myFolder/quiz.txt 파일을 만들어서 
		 * 해당 파일에 문자열저장해 보세요
		 */
		System.out.println("기록할 문자열을 입력해주세요. 종료를 원하시면 q를 눌러주세요");
		
		List<String> inputStringArray = new ArrayList<>();
		while(true) {
			String inputTxt = sc.nextLine();
			
			if(inputTxt.equals("q"))
			{
				boolean isExist = memoFile.exists();
				try {
					if(!isExist)
					{
						memoFile.createNewFile();
					}
					//어펜드 모드는 true 인자를 전달해줘야한다. 어펜드 모드는 텍스트를 뒤에 이어붙힘.
					fw = new FileWriter(memoFile,true);
					for(String txt : inputStringArray)
					{
						fw.append(txt);
						fw.append("\r\n");
					}
					fw.flush();
					fw.close(); //.close 시점에 파일이 만들어진다. 
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("문자열을 출력하고 프로그램이 종료되었습니다.");
				return;
			}
			else
			{
				inputStringArray.add(inputTxt);
			}
		}
	}
}
