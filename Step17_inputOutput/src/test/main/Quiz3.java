package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Quiz3 extends JFrame implements ActionListener{
	File memoFile = null;
	FileReader fr = null;
	FileWriter fw = null;
	BufferedReader br = null;
	JTextField tf_msg = null;
	JMenuItem item_new = null;
	JMenuItem item_open = null; 
	JMenuItem item_save = null; 
	JMenu menu1 = null;
	JMenuBar mb  = null;
	JTextArea area = null;
	JScrollPane scrollPane = null;
	
	final int STATE_NOT_CHANGE = 0;
	final int STATE_CHANGE = 1;
	final int STATE_WAIT = 2;
	int isChange = STATE_NOT_CHANGE;
	
	final String COMMAND_NEW = "New";
	final String COMMAND_OPEN = "Open";
	final String COMMAND_SAVE = "Save";
	final String COMMAND_CHANGE = "Change";

	public Quiz3() {
		init();
	}	
	public static void main(String[] args) {
		Quiz3 f = new Quiz3();
		f.setBounds(100,100,500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);
		//창의 종료버튼
		f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				f.newText(); //프로그램 끌때 변경내용있으면 확인 한 번 함.
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputCommand = e.getActionCommand();
		switch (inputCommand) {
		case COMMAND_NEW:
			newText();
			break;
		case COMMAND_OPEN :
			openText();
			break;
		case COMMAND_SAVE : 
			saveText();
			break;
		default:
			break;
		}
	}
	
	public void reloadTitle(String title) {
		setTitle(title);
		isChange = STATE_NOT_CHANGE;
	}
	
	public void openText()
	{	
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("txt","txt"));
		fc.setCurrentDirectory(new File("c:/acorn2020/myFolder/"));
		String openPath = null;
		String title = "메모장";
		int state = fc.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION) {
			openPath = fc.getSelectedFile().getPath();
			title = fc.getSelectedFile().getName();
			txtClean();
		}
		else
		{
			return;
		}
		File memoFile = new File(openPath);
		try {
			fr = new FileReader(memoFile);
			br = new BufferedReader(fr);
			while(true)
			{
				String inputLine = br.readLine();
				if(inputLine== null)
				{
					break;
				}
				area.append(inputLine + "\n");	
			}
			area.setCaretPosition(area.getDocument().getLength());  // 맨아래로 스크롤한다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				if(fr != null)	fr.close();
				if(br != null) 	br.close();
				reloadTitle(title);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	public void newText()
	{
		String existText =area.getText();
		if(existText.length() > 0)
		{
			int getDialogYesOrNo = JOptionPane.showConfirmDialog(this, "변경된 내용이 존재합니다. 저장하시겠습니까 ? ", "저장", JOptionPane.YES_NO_OPTION);
			if(getDialogYesOrNo == JOptionPane.OK_OPTION)
			{
				saveText();
				txtClean();
				return;
			}
			txtClean();
			reloadTitle("메모장");
		}
	}
	public void txtClean()
	{
		area.setText("");	
	}
	public void saveText()
	{
		String mContents = area.getText();
		String outputPath = null;
		String title = "메모장";
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("txt","txt"));

		fc.setCurrentDirectory(new File("c:/acorn2020/myFolder/"));
		int state = fc.showSaveDialog(this);
		if(state == JFileChooser.APPROVE_OPTION) {
			outputPath = fc.getSelectedFile().getPath() + ".txt";
			title = fc.getSelectedFile().getName();
		}
		else
		{
			return;
		}
		File memoFile = new File(outputPath);
		try {
			fw = new FileWriter(memoFile,true);
			fw.append(mContents);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fw != null)fw.close();
				reloadTitle(title);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this,"저장되었습니다.");
	}
	
	
	public void init()
	{
		setTitle("메모장");
		setLayout(new BorderLayout());
		item_new = new JMenuItem(COMMAND_NEW);
		item_open = new JMenuItem(COMMAND_OPEN);
		item_save = new JMenuItem(COMMAND_SAVE);
		
		item_new.setActionCommand(COMMAND_NEW);
		item_open.setActionCommand(COMMAND_OPEN);
		item_save.setActionCommand(COMMAND_SAVE);

		item_new.addActionListener(this);
		item_open.addActionListener(this);
		item_save.addActionListener(this);
		
		menu1 = new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);

		mb = new JMenuBar();
		mb.add(menu1);
		setJMenuBar(mb);
		
		area = new JTextArea();		
		area.setBackground(Color.YELLOW);
		area.setVisible(true);
		
		area.getDocument().addDocumentListener(new DocumentListener() {	
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				//지울떄
				if(isChange == STATE_NOT_CHANGE)
				{
					isChange = STATE_CHANGE;
					setTitle("* " + getTitle());
					isChange = STATE_WAIT;
				}	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				//넣을떄
				if(isChange == STATE_NOT_CHANGE)
				{
					isChange = STATE_CHANGE;
					setTitle("* " + getTitle());
					isChange = STATE_WAIT;
				}	
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		scrollPane = new JScrollPane(area);
		add(scrollPane,BorderLayout.CENTER);
	}
	
}
