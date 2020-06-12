package test.frame1;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//프레임의 레이아웃 매니저를 사용하지 않기 때문에 ui를 절대 좌표에 직접 배치해야 한다.
		setLayout(new GridLayout(4,4));
		
		JButton btn1 = new JButton("버튼1");
		btn1.setSize(100,30);
		add(btn1);
		

		JButton btn2 = new JButton("버튼2");
		btn2.setLocation(120, 10);
		btn2.setSize(100,30);
		add(btn2);
		
		JButton btn3 = new JButton("버튼3");
		btn3.setLocation(230, 10);
		btn3.setSize(100,30);
		add(btn3);
		
		JButton btn4 = new JButton("버튼4");
		btn4.setLocation(340, 10);
		btn4.setSize(100,30);
		add(btn4);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
		
		
	}
}
