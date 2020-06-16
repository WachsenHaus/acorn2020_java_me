package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountThread;

public class Frame02 extends JFrame implements ActionListener{
	
	public Frame02() {
		setLayout(new BorderLayout());
		
		//패널을 프레임의 상단에 배치
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel,BorderLayout.NORTH);
		//버튼을 패널에 추가하고
		JButton alertBtn = new JButton("카운트");
		panel.add(alertBtn);
		//버튼에 리스너 등록하기
		alertBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		Frame02 frame = new Frame02();
		frame.setTitle("Frame02");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CountThread ct = new CountThread();
		//thread에 새로운 스레드의 이름을 전달하는 방법.
		//이름은 참조값이다. 
		Thread t = new Thread(ct);
		t.start();
		System.out.println("새로운 스레드를 시작했습니다.");
		//스레드시작. 
		
	}
	
}
