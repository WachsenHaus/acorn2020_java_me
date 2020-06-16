package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		File myFile = new File("c:/");
		String[] a = myFile.list();
		
		for(String tmp:a)
		{
			System.out.println(tmp);
		}
	}
}
