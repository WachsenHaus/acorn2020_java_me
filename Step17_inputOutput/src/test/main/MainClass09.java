package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass09 {
	public static void main(String[] args) {
		//이미 만들어 졌거나혹은 만들 예정인 파일을 access 할 수 있는 file 객체
		File f1 = new File("C:/acorn2020/myFolder/gura.txt");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
