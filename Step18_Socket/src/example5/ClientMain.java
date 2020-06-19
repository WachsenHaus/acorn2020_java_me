package example5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * json
 * 1.{}
 * 2.[]
 * 3. "xxx"
 * 4. 10 or 10.1
 * 5. true or false
 * 6. null
 */
/*
 * 1. 일반 대화 메세지 
 * {type : "msg"   "name" : "김구라","content" : 안녕하세요"}
 * 
 * 2. 누군가 입장 했다는 메세지
 * 	{type : "enter" : "name": "김구라", "member" : ["김구라","해골","원숭이"]}
 * 
 * 3. 누군가 퇴장 했다는 메세지
 * 	{type : "out" : "name" : "김구라" , "member" : ["김구라","해골","원숭이"]}
 * 
 * 4. 참여자 목록 메세지
 * 	{type : "members": ["김구라","해골","원숭이"]}
 */
public class ClientMain  extends JFrame implements ActionListener, KeyListener{
	JTextField tf_msg = null;
	//서버와 연결된 소켓 객채의 참조값을 담을 필드
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	JScrollPane scrollPanel;
	String chatName;
	
	JList<String> jList;
	JPanel leftPanel;
	Vector<String> list=new Vector<>();
	
	public ClientMain()
	{
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		
		chatName = JOptionPane.showInputDialog(this,"대화명을 입력하세요");
		setTitle("대화명:"+chatName);
		
		tf_msg = new JTextField(10);
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		sendBtn.addActionListener(this);
		
		panel.add(tf_msg);
		panel.add(sendBtn);
		
		area = new JTextArea();
		area.setBackground(Color.GREEN);
		area.setEditable(false);
		area.setVisible(true);
		scrollPanel = new JScrollPane(area);
		
		add(panel,BorderLayout.SOUTH);	
		add(scrollPanel,BorderLayout.CENTER);
		tf_msg.addKeyListener(this);
		
		//벡터는 어레이 리스트와 같다고 생각하고 사용하면된다.
		//추가기능 ( 스레드동기화)가 있어서 조금 더 무겁다.
		
		
		//String[] 에 JList 공간 확보를 위해 임시 문자열을 넣는다.
//		String[] title= {"참여자 목록"}; 
		jList=new JList<String>();
		jList.setBackground(Color.GREEN);
		
		leftPanel = new JPanel();
		leftPanel.add(jList);
		leftPanel.setBackground(Color.white);
		add(leftPanel,BorderLayout.EAST);
		
		try {
			//접속이 성공되면 socket 객체의 참조값이 반환된다.
			//반환되는 객체의 참조값을 필드에 저장해 놓는다.
			socket =  new Socket("192.168.0.27",5000);
		
			//문자열을 서버에 전송(출력 output하기!)
			OutputStream os =socket.getOutputStream();
			OutputStreamWriter osw= new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			

			
			
			new ClientThread().start();
			
			//내가 입장한다고 서버에 메세지를 보낸다.
			//"{"type:" : "enter","name":"대화명"}"
			//키값 , 밸류값
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg = jsonObj.toString();
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e) { //접속이 실패하면 예외가 발생한다.
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		ClientMain  f= new ClientMain();
//		f.setTitle("안녕 채팅창");
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void sendMessage()
	{
		String msg = tf_msg.getText();
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "msg");
			jsonObj.put("name", chatName);
			jsonObj.put("content", msg);
			//json 문자열을 얻어낸다.
			String jsonString = jsonObj.toString();
			
			
			//필드에있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
	
			bw.write(jsonString);
			bw.newLine();
			bw.flush();
			
		}catch(Exception e1) {
			System.out.println("에러임둥");
		}finally {
			try {
//				if(socket != null) socket.close();
				tf_msg.setText("");
			}catch(Exception e1) {};
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
	}

	//서버에서 불특정 시점에 도착하는 메세지를 받을 스레드
	public class ClientThread extends Thread{
		
		
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String msg = br.readLine();
					if(msg==null)break;
					updateTextArea(msg);
					System.out.println(msg);
//					area.append(msg + "\r\n");
					area.setCaretPosition(area.getDocument().getLength());
				}
				
			} catch (IOException e) {
			}
		}
		
		//JTextArea에 문자열을 출력하는 메소드
		public void updateTextArea(String msg)
		{
			try {
				JSONObject jsonObj = new JSONObject(msg);
				String type = jsonObj.getString("type");
				if(type.equals("enter")) {
					//입장 메세지라면 누가 입장했는지 읽어낸다.
					String name = jsonObj.getString("name");
					area.append("[" + name + "] 님이 입장했습니다.");
					area.append("\r\n");
				}
				if(type.equals("msg")) { //대화메세지라면
					String name = jsonObj.getString("name");
					String content = jsonObj.getString("content");
					area.append("[" + name + "] : " +content);
					area.append("\r\n");
				}
				if(type.equals("out")){
					String name = jsonObj.getString("name");
					area.append("[[ " +name+" ]] 님이퇴장했습니다." );
					area.append("\r\n");
				}
				if(type.equals("members"))
				{
					JSONArray arr = jsonObj.getJSONArray("list");
					//참여자 목록을 저장할 Vector
				
					list.clear();
					list.add("참여자");
					//반복문 돌면서 참여자 목록을 다시 넣어준다.
					for(int i=0; i<arr.length(); i++) {
						String tmp=arr.getString(i);
						list.add(tmp);
					}
					//JList 에 참여자 목록 연결하기 
					jList.setListData(list);
				}
			}catch(Exception je) {
				je.printStackTrace();
				System.out.println("여기에런가");
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			sendMessage();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
