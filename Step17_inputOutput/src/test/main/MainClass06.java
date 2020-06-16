package test.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		OutputStream os = ps;
		OutputStreamWriter osw = new OutputStreamWriter(os);
//		BufferedWriter bw = new BufferedWriter(osw);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write("하나");
			bw.newLine();
			bw.write("두울");
			bw.newLine();
			bw.write("세엣");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
