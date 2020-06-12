package test.frame8;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	JTextField inputMsg = new JTextField(20);
	JButton sendBtn = new JButton("전송");
	
	//default  생성자
	public MyFrame() {
		setLayout(new FlowLayout());
	
		sendBtn.addActionListener(this);
		sendBtn.setActionCommand("send");
		
		add(inputMsg);
		add(sendBtn);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String inputCommand = e.getActionCommand();
		if (inputCommand.equals("send")) {
			String inputString = inputMsg.getText();
			JOptionPane.showMessageDialog(this,inputString);
		}
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame 에 담기 
		MyFrame frame=new MyFrame();
		//프레임의 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
}





