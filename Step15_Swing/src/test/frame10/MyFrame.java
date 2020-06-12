package test.frame10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener,KeyListener {
	static final String SEND = "send";
	static final String REMOVE = "remove";
	static final int FALE = -1;
	
	JTextField inputMsg = new JTextField(20);
	JButton sendBtn = new JButton("전송");
	JButton removeBtn = new JButton("삭제");
	JLabel label1 = new JLabel("");
	JList<String> list = new JList<String>();
	DefaultListModel<String> model = new DefaultListModel<String>();
	
	//default  생성자
	public MyFrame() {
		setLayout(new BorderLayout());
	
		sendBtn.addActionListener(this);
		sendBtn.setActionCommand(MyFrame.SEND);
		removeBtn.addActionListener(this);
		removeBtn.setActionCommand(MyFrame.REMOVE);
		
		inputMsg.addKeyListener(this);
		JPanel panel = new JPanel();
		
		panel.add(inputMsg);
		panel.add(sendBtn);
		panel.add(label1);
		
		add(panel,BorderLayout.NORTH);
		add(removeBtn,BorderLayout.SOUTH);

		panel.setBackground(Color.yellow);
		
		//목록을 출력할 수 있는 JList
		//기본 모델 객체 ( 목록에 출력할 data를 가지고 있는 객체 )
		model.addElement("김구라");
		model.addElement("해골");
		model.addElement("원숭이");

		//목록에 모델(데이터) 추가
		list.setModel(model);
		
		JScrollPane sc = new JScrollPane(list,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		sc.setPreferredSize(new Dimension(500,300));
		
		//목록을 프레임의 가운데에 배치하기
		add(sc,BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String inputCommand = e.getActionCommand();
		switch(inputCommand)
		{
			case MyFrame.SEND:
				String inputString = inputMsg.getText();
				boolean isEmpty = inputString.equals("");
				if(!isEmpty)
				{	
					setLabelText(inputString);
					resetInputMsg();
					addModel(inputString);
				}
				break;
			case MyFrame.REMOVE:
				int index = list.getSelectedIndex();
				if(index != MyFrame.FALE)
				{
					int a = JOptionPane.showConfirmDialog(this, "지우시겠습니까?", "삭제확인", 0);
					if(a == JOptionPane.OK_OPTION)
					{
						model.remove(index);
					}
				}
				break;
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			String inputString = inputMsg.getText();
			boolean isEmpty = inputString.equals("");
			if(!isEmpty)
			{
				setLabelText(inputString);
				resetInputMsg();
				addModel(inputString);
				setListModel(model);
			}
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
	public void setLabelText(String str)
	{
		label1.setText(str);
	}
	public void resetInputMsg()
	{
		inputMsg.setText("");
	}
	public void addModel(String str)
	{
		model.addElement(str);
	}
	public void setListModel(DefaultListModel<String> model)
	{
		list.setModel(model);
	}
	
}





