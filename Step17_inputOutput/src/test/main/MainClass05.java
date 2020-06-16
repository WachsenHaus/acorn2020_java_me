package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		OutputStream os = ps;
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		try {
			osw.write("나야나");
			osw.write("나야나");
			osw.write("나야나");
			osw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
