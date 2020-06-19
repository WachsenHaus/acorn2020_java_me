package test.study;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AcornFrame extends JFrame implements ActionListener {
	
	public AcornFrame() {
		setLayout(new BorderLayout());
		JButton jBtn = new JButton("전송");
		jBtn.addActionListener(this);
		add(jBtn,BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		AcornFrame a = new AcornFrame();
		a.setTitle("acorn");
		a.setBounds(100, 100, 400, 400);
		a.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "전송합니다");
	}
}
