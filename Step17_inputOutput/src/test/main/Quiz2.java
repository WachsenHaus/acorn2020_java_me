package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quiz2 extends JFrame implements ActionListener{
	public static File memoFile = new File("c:/acorn2020/myFolder/quiz2.txt");
	FileReader fr = null;
	FileWriter fw = null;
	BufferedReader br = null;
	JTextField tf_msg = null;
	
	public Quiz2() {
		setTitle("나의 프레임");
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		tf_msg = new JTextField(10);
		JButton appedBtn = new JButton("추가하기");
		appedBtn.setActionCommand("append");
		appedBtn.addActionListener(this);
		topPanel.add(tf_msg);
		topPanel.add(appedBtn);
		add(topPanel,BorderLayout.NORTH);
		topPanel.setBackground(Color.YELLOW);		
	}	
	public static void main(String[] args) {
		Quiz2 f = new Quiz2();
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isSucc = false;
		String inputCmd = e.getActionCommand();
		if(inputCmd.equals("append"))
		{
			try {
				boolean isExist = memoFile.exists();
				if(!isExist) {
					memoFile.createNewFile();
				}
				fw = new FileWriter(memoFile,true);
				fw.append(tf_msg.getText() + "\r\n");
				isSucc = true;
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			finally {
				try {
					if(fw!= null) {
						fw.close();
					}
					if(isSucc)
					{
						tf_msg.setText("");
						JOptionPane.showMessageDialog(this,"추가했습니다.");
						return ;
					}
						JOptionPane.showMessageDialog(this,"실패했습니다.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
}
