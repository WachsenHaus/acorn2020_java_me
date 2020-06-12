package test.main;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass01 {
	public static void main(String[] args) {
		
		//jframe 객체 생성하고
		JFrame f = new JFrame("Hello Frame");
		
		//초기 위치와 크기지정
		f.setBounds(0,0,500,500);
		//프레임을 닫았을때 자동으로 프로세스 종료 되도록
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임이 보이도록 한다.
		f.setVisible(true);
		JButton btn = new JButton("눌러보셈");
		btn.setBounds(10,10,100,40);
		f.add(btn);
		new MyFrame("나만의 프레임");

	}
	
	public static class MyFrame extends JFrame{
		public MyFrame(String title) {
			// TODO Auto-generated constructor stub
			super(title);
			setBounds(200,200,500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			setLayout(null);
			JButton btn = new JButton("눌러보셈");
			btn.setBounds(10,10,100,40);
			add(btn);
		}
	}
}
