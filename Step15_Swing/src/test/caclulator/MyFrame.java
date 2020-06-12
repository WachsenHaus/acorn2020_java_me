package test.caclulator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JTextField inputNum1 = new JTextField(10);
	JTextField inputNum2 = new JTextField(10);
	final String COMMAND_PLUS = "+";
	final String COMMAND_MINUS = "-";
	final String COMMAND_DIVIDE = "/";
	final String COMMAND_MULTIPLY = "*";
	
			
	JButton plusBtn = new JButton(COMMAND_PLUS);
	JButton minusBtn = new JButton(COMMAND_MINUS);
	JButton divideBtn = new JButton(COMMAND_DIVIDE);
	JButton multiplyBtn = new JButton(COMMAND_MULTIPLY);
	JLabel equalLabel = new JLabel("=");
	JLabel resultLabel = new JLabel("");
	

	public MyFrame()
	{
		setLayout(new FlowLayout());
		
		add(inputNum1);
		add(plusBtn);
		add(minusBtn);
		add(divideBtn);
		add(multiplyBtn);
		add(inputNum2);
		add(equalLabel);
		add(resultLabel);
		
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		multiplyBtn.addActionListener(this);
		
		plusBtn.setActionCommand(COMMAND_PLUS);
		minusBtn.setActionCommand(COMMAND_MINUS);
		divideBtn.setActionCommand(COMMAND_DIVIDE);
		multiplyBtn.setActionCommand(COMMAND_MULTIPLY);
		
		
	}

	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		
		frame.setTitle("계산기");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,1000,100);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String inputCommand = e.getActionCommand();
		double getNum1 =0.d;
		double getNum2 =0.d;
		
		try {
			 getNum1 = Double.parseDouble(inputNum1.getText());
			 getNum2 = Double.parseDouble(inputNum2.getText());
		}
		catch (Exception e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(this, "숫자만입력하세요");
		}
		double result = 0.d;
		String checkResultType ="";
		switch (inputCommand) {
		case COMMAND_PLUS:
			result = getNum1 + getNum2;
			break;
		case COMMAND_MINUS : 
			result = getNum1 - getNum2;
			break;
		case COMMAND_DIVIDE:
			result = getNum1 / getNum2;
			break;
		case COMMAND_MULTIPLY:
			result = getNum1 * getNum2;
			break;
		}
		result = Double.parseDouble(String.format("%.4f",result));
		checkInfiniteAndNaN(result);
		checkResultType = isDouble(result) ? Double.toString(result) : Integer.toString((int)result); 
		resultLabel.setText(checkResultType);
	}
	public Double checkInfiniteAndNaN(double checkValue)
	{
		if(Double.isInfinite(checkValue)) {
			checkValue = 0.0;
		}
		if(Double.isNaN(checkValue)) {
			checkValue = 0.0;
		}
		return checkValue;
	}
	public boolean isDouble(double checkValue)
	{
		return checkValue - (int)checkValue != 0 ? true : false; 
	}
}
