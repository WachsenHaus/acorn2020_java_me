package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.mypac.CountRunnable;
import test.mypac.CountThread;

public class Frame06 extends JFrame implements ActionListener{
	JLabel label_result;
	
	//내부 클래스
	//밖에서 내부에서 사용할 수 있다.
	class CountThread extends Thread{
		@Override
		public void run() {
			int count = 0;
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count++; //count를 1증가 시킨다.
				label_result.setText(Integer.toString(count));
				System.out.println("현재 카운트 : " + count);
				if(count==10) //카운트가 10이되면
				{
					break; //반복문 탈출.
				}
			}
		}
	}
	CountThread ct = new CountThread();
	public Frame06() {
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
		
		//Jlabel
		label_result = new JLabel();
		panel.add(label_result);		
	}
	
	public static void main(String[] args) {
		Frame06 frame = new Frame06();
		frame.setTitle("Frame06");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,500,500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Thread t = new Thread(ct);
		t.start();
		System.out.println("새로운 스레드를 시작했습니다.");
		
		//스레드시작. 
		
	}
	
}
