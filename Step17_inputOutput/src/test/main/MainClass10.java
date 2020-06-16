package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass10 {
	public static void main(String[] args) {
		//이미 만들어 졌거나혹은 만들 예정인 파일을 access 할 수 있는 file 객체
		File f1 = new File("C:/acorn2020/myFolder/folder1");
		f1.mkdir();
		for(int i =0; i<10; i++)
		{
			File tmp = new File("c:/acorn2020/myFolder/new_folder" + i);
			tmp.mkdir();
//			tmp.delete();
		}
		System.out.println("디렉토리를 10개 삭제했습니다..");
		
	}
}
