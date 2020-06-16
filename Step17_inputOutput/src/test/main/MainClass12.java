package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass12 {
	public static void main(String[] args) {
		//이미 만들어 졌거나혹은 만들 예정인 파일을 access 할 수 있는 file 객체
		File memoFile = new File("c:/acorn2020/myFolder/memo.txt");
		
		boolean isExist = memoFile.exists();
		if(!isExist) {
			try {
				memoFile.createNewFile();
				FileWriter fw	=new FileWriter(memoFile);
				fw.write("하나");
				fw.write("\r\n"); //개행기호
				fw.write("두울");
				fw.write("\r\n"); //개행기호
				fw.write("세엣");
				fw.flush();
				fw.close(); //.close 시점에 파일이 만들어진다. 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		}
	
	}
}

