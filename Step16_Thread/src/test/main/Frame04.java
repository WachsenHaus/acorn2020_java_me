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

public class Frame04 extends JFrame implements ActionListener{
	
	public Frame04() {
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
		Frame04 frame = new Frame04();
		frame.setTitle("Frame04");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//인터페이스 형태를 사용한다
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					count++; //count를 1증가 시킨다.
					System.out.println("현재 카운트 : " + count);
					if(count==10) //카운트가 10이되면
					{
						break; //반복문 탈출.
					}
				}
			}
		};
		Thread t = new Thread(r2);
		t.start();
		System.out.println("새로운 스레드를 시작했습니다." + t.getState());
		
		//스레드시작. 
		
	}
	
}
