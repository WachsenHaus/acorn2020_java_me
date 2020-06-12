package test.frame7;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{
	JButton sendBtn =new JButton("전송");
	JButton removeBtn = new JButton("삭제");
	
	//default  생성자
	public MyFrame() {
		//MyFrame 의 레이아웃 메니저 지정하기
		setLayout(new FlowLayout());

		//프레임에 버튼 추가하기 ( FlowLayout 의 영향을 받는다 )
	
		add(sendBtn);
		add(removeBtn);
		
		
		//ActionListener 인터페이스 type  의 참조값 
		ActionListener listener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다~");
			}
		};
		ActionListener sendmsg=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다~");
			}
		};
		ActionListener l2 = (e)->{
				JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다~");
		};
		
		
//		removeBtn.addActionListener(l2);
//		removeBtn.addActionListener((e)->{
//			JOptionPane.showMessageDialog(this, "삭제합니다~");
//		});
		sendBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		
		//버튼에 커맨드 등록하기 (어떤 기능을 하는 버튼인지)
		sendBtn.setActionCommand("send");
		removeBtn.setActionCommand("remove");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object what = e.getSource();
		if (what == sendBtn) {
			JOptionPane.showMessageDialog(this, "전송~");
		}
		else if(what == removeBtn) {
			JOptionPane.showMessageDialog(this, "삭제~");
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





