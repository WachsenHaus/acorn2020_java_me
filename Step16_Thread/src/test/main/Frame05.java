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

public class Frame05 extends JFrame implements ActionListener{
	
	public Frame05() {
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
		Frame05 frame = new Frame05();
		frame.setTitle("Frame05");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new Thread(new Runnable() {
			
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
		}).start();
		
		//thread name을 전달하면 오버라이딩이 알아서 인식해서
		//thread를 실행하지만 람다식, 함수를 전달하면
		//알아서 Runnable로 동작된다. 똑똑하구만.
		new Thread( ()->{	int count = 0;
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
		}}).start();
	
		
		System.out.println("새로운 스레드를 시작했습니다.");
		
		//스레드시작. 
		
	}
	
}
