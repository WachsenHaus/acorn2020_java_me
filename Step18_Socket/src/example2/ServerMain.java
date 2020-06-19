package example2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		//필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket= null;
		Socket socket = null;
		try {
			//5000번 통신 port를 열고 클라이언트의 접속을 기다린다.
			serverSocket = new ServerSocket(5005);
			/*
			 * accept() 메소드는 클라이언트가 실제 접속을 할 때 까지 리턴하지 않고
			 * 블로킹 되는 메소드이다.
			 * 클라이언트가 접속을 해오면 socket 객체의 참조값을 반환하면서 리턴된다.
			 */
			while(true) {
				socket = serverSocket.accept();
				System.out.println("클라이언트가 접속을 했습니다.");
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println(clientIp);
				//클라이언트로 부터 읽어들일 (input) 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String msg = br.readLine();
				System.out.println("메세지: " + msg);
				socket.close();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(serverSocket != null) serverSocket.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}
}
