package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File myFile = new File("c:/");
		File[] myfiles = myFile.listFiles();
		for(File a : myfiles)
		{
			if(a.isDirectory())
			{
				System.out.println("[ " + a.getName() + " ]");				
			}
			else
			{
				System.out.println(a.getName());
			}
			
		}
		
	}
}
