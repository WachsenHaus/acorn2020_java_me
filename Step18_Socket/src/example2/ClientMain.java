package example2;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("서버에 전송할 문자열 입력:");
		String msg = scan.nextLine();
		try {
			socket = new Socket("192.168.0.30",5000);
			System.out.println("Socket 연결 성공!");
			//문자열을 서버에 전송(출력 output하기!)
			OutputStream os =socket.getOutputStream();
			OutputStreamWriter osw= new OutputStreamWriter(os);
			osw.write(msg);
			osw.write("\n");
			osw.flush();
			osw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null) socket.close();
			}catch(Exception e) {};
		}
		System.out.println("메인메소드가 종료됩니다.");
	}
	
}
