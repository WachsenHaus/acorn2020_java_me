package example3;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMain  extends JFrame implements ActionListener, KeyListener{
	JTextField tf_msg = null;
	//서버와 연결된 소켓 객채의 참조값을 담을 필드
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	JScrollPane scrollPanel;
	
	public ClientMain()
	{
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		
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
		
		try {
			//접속이 성공되면 socket 객체의 참조값이 반환된다.
			//반환되는 객체의 참조값을 필드에 저장해 놓는다.
			socket =  new Socket("192.168.0.30",5000);
			System.out.println("연결");
			
			//문자열을 서버에 전송(출력 output하기!)
			OutputStream os =socket.getOutputStream();
			OutputStreamWriter osw= new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			new ClientThread().start(); 
			
		} catch (IOException e) { //접속이 실패하면 예외가 발생한다.
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ClientMain  f= new ClientMain();
		f.setTitle("안녕 채팅창");
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void sendMessage()
	{
		String msg = tf_msg.getText();
		try {
			//필드에있는 BufferedWriter 객체의 참조값을 이용해서 서버에 문자열 출력하기
	
				bw.write(msg);
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
					System.out.println(msg);
					area.append(msg + "\r\n");
					area.setCaretPosition(area.getDocument().getLength());
				}
				
			} catch (IOException e) {
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
