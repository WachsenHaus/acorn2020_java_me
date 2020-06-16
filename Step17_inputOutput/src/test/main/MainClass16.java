package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass16 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] dummy2 = new byte[1024];
		try {
			fis = new FileInputStream("c:/acorn2020/myFolder/1.jpg");
			fos = new FileOutputStream("c:/acorn2020/myFolder/copied2.jpg");
			long start = System.currentTimeMillis();

			while(true)
			{
				int readedByte = fis.read(dummy2);
				if( readedByte == -1) {
					break;
				}
//				fos.write(dummy2, 0, readedByte);	
				fos.write(dummy2);	
			}
			long end = System.currentTimeMillis();
			System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
//			while(fis.available()>0) {
//				fos.write(fis.read(dummy2));
//			}
			System.out.println("정상적으로 완료되었습니다.!");
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}
			catch(IOException ie) {
				
			}
		}
	}
}

