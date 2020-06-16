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

import test.mypac.CountRunnable;
import test.mypac.CountThread;

public class Frame03 extends JFrame implements ActionListener{
	CountRunnable r = new CountRunnable();
	Thread t = new Thread(r);
	
	public Frame03() {
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
		Frame03 frame = new Frame03();
		frame.setTitle("Frame03");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,500);
		frame.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//인터페이스 형태를 사용한다
	
			t.start();			
		
		System.out.println("새로운 스레드를 시작했습니다." + t.getState());
		
		//스레드시작. 
		
	}
	
}
