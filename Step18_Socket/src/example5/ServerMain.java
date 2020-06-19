	package example5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServerMain {
	static List<ServerThread> threadArray = new ArrayList<>();
	
	public static void main(String[] args) {
		//필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket= null;
		
		
		try {
			//5000번 통신 port를 열고 클라이언트의 접속을 기다린다.
			serverSocket = new ServerSocket(5000);
			/*
			 * accept() 메소드는 클라이언트가 실제 접속을 할 때 까지 리턴하지 않고
			 * 블로킹 되는 메소드이다.
			 * 클라이언트가 접속을 해오면 socket 객체의 참조값을 반환하면서 리턴된다.
			 */
			while(true) {
				System.out.println("클라이언트의 소켓 연결 요청을 대기합니다.");
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트가 접속했습니다.");
				
				//방금 접속한 클라이언트를 응대할 스레드를 시작한다.
				ServerThread thread = new ServerThread(socket);
				thread.start();
				//생성하고 스레드리스트에 넣어준다.
				threadArray.add(thread);
			}

		}catch(Exception e) {
			System.out.println("종료임둥");
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
	
	//내부클래스로 스레드 객체를 생성할 클래스를 정의한다.
	//내부클래스를 스태틱인 main()메소드 안에서 클래스를 사용하기 위해 static 예약어를
	//붙여서 정의한다. 외부는 상관없슴메!
	
	public static class ServerThread extends Thread{
		Socket socket;

		//클라이언트에게 출력할 문자열을 이어주는 개체
		BufferedWriter bw;
		String chatName;
		
		
		
		//생성자의 인자로 Socket객체를 전달받도록 한다.
		 public ServerThread(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}
		//새로운 작업단위가 시작되는 run()메소드
		 
		//인자로 전달된 문자열을 Socket을 통해서 출력하는 메소드
		public void sendMessage(String msg) throws IOException
		{
			//반복문 돌면서 모든 스레드의 bufferedwriter 객체를 이용해서
			//문
			for(ServerThread tmp : threadArray) {
				tmp.bw.write(msg);
				tmp.bw.newLine();
				tmp.bw.flush();
			}
		}
		//참여자 목록을 얻어내서 Client 에게 출력해주는 메소드
		public void sendChatNameList(){
			JSONObject jsonObj = new JSONObject();
			JSONArray jsonArr = new JSONArray();
			
			for(int i =0; i<threadArray.size(); i++) {
				ServerThread tmp = threadArray.get(i);
				jsonArr.put(i,tmp.chatName);
				System.out.println(tmp.chatName);
			}
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonArr);
			
			try {
				sendMessage(jsonObj.toString());	
			}catch(Exception ex)
			{
				System.out.println("Error Code : 199x");
			}
				
		}
		@Override
		public void run() {
			try {
				System.out.println("클라이언트가 접속을 했습니다.");
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println(clientIp);
				//클라이언트로 부터 읽어들일 (input) 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				bw = new BufferedWriter(osw);
				
				while(true) {
					/*
					 * 클라이언트가 문자열을 한줄(개행기호와 함께) 보내면
					 * readline()메소드가 리턴하면서 보낸 문자열을 가지고온다.
					 * 보내지않으면 계속 블로킹되어서 대기하고있다가
					 * 접속이 끊기면 exception이 발생하거나 혹은 null이 리턴된다. 따라서 null이 리턴되면 반복문을 빠져 나가게
					 * break문을 만나도록한다.
					 * 실행순서가 try 블럭을 벗어나면 run()메소드가 리턴하게 되고 run()메소드가 리턴되면
					 * 해당 스레드는 종료가 된다.
					 */
					String msg = br.readLine();
					if(msg == null) //클라이언트의 접속이 끊겼기 때문에 반복문(while)을 빠져나오도록한다.
					{
						break;
					}
					//전송된 문자열을 json으로 보낼준비를한다.
					JSONObject jsonObj = new JSONObject(msg);
					
					//type을 읽어낸다.
					String type = jsonObj.getString("type");
					if(type.equals("enter")) {
						//현재 스레드가 대응하는 클라이언트의 대화명을 필드에 저장한다.
						String chatName = jsonObj.getString("name");
						this.chatName = chatName;
						sendChatNameList();
					}else if(type.equals("msg")) {
						sendMessage(msg);
					}
					//클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다.
					
					System.out.println("메세지: " + msg);
				}
			}catch(Exception e)
			{
				System.out.println("종료임둥");
			}
			finally {
				try {
					//접속이 끊겨서 종료되는 스레드는 listarray에서 제거된다.
					//리스트어레이에는 접속된 스레드들이 존재한다.
					threadArray.remove(this);
					//this가 퇴장한다고 메세지를 보낸다.
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", this.chatName);
					//json 문자열을 얻어낸다.
					String jsonString = jsonObj.toString();
					//필드에있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
					sendMessage(jsonString);
					sendChatNameList();
					if(socket != null)socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
