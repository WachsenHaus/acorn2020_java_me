package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemoDao;
import test.dto.MemoDto;



public class memoFrame extends JFrame implements ActionListener,PropertyChangeListener,MouseListener{
/*
 * create table memo
 * (num number primary key,
 * content varchar2(30),
 * regdate date);
 * 
 * create sequence memo_seq;
 * 위와 같이 테이블과 시퀀스를 만들고 해당 테이블에 데이터를
 * select,insert,update,delete기능을 수행할 수 있는 memoframe을 만들어 보세요
 * 
 * 조건
 * 1. num 칼럼은 시퀀스를 이용해서 넣으세요.
 * 2. regdate 칼람(등록일)의 값은 sysdate를 이용해서 넣으세요.
 * 3. 수정은 content 만 수정 가능하게 하세요.
 * 4. MemoDto, MemoDao를 만들어서 프로그래밍 하세요.
 */
	JTextField myContent = null;
	JButton AddButton = null;
	JButton ModifyButton = null;
	JButton deleteButton = null;
	JTable myTable = null;
	JScrollPane scroll = null;

	DefaultTableModel myModel = null;
	String[] contentColumns = {"번호","내용","작성일"};
	MemoDao myWork = MemoDao.getInstance();
	public memoFrame() {
		setTitle("메모");
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		myContent = new JTextField(30);
		myContent.setHorizontalAlignment(JTextField.CENTER);
		myContent.setFont(font1);
		myContent.setBackground(Color.GREEN);
		
		AddButton = new JButton("추가");
		AddButton.addActionListener(this);
		AddButton.setActionCommand("addClick");

		ModifyButton = new JButton("변경");
		ModifyButton.addActionListener(this);
		ModifyButton.setActionCommand("modifyClick");

		deleteButton = new JButton("삭제");
		deleteButton.addActionListener(this);
		deleteButton.setActionCommand("deleteClick");
		
		myTable = new JTable();
		myModel = new DefaultTableModel(contentColumns,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; //모든 셀 비활성화
			}
		};
		
		myTable.setModel(myModel);
		myTable.addMouseListener(this);
		myTable.addPropertyChangeListener(this);
		myTable.setBackground(Color.MAGENTA);
		myTable.setForeground(Color.white);
		scroll = new JScrollPane(myTable);
		

		
		JPanel panel = new JPanel();
		panel.add(AddButton);
		panel.add(ModifyButton);
		panel.add(deleteButton);
		
		add(scroll,BorderLayout.EAST);
		add(myContent,BorderLayout.WEST);
		add(panel,BorderLayout.SOUTH);			
		
		if(myWork.connectSQL() == STATE_SUCC) redrawTable(); 
		else JOptionPane.showMessageDialog(this, "SQL접속에 실패했습니다");
	}
	
	public static void main(String[] args) {
		memoFrame myframe = new memoFrame();
		myframe.setBounds(100, 100, 1200, 500);
		myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		myframe.setVisible(true);
		myframe.addWindowListener(new WindowListener() {
			
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
				//프로그램이 닫히기 직전에 수행
				MemoDao.getInstance().disconnectSQL();
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

	boolean isEditing = false;
	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getPropertyName());
//		if(e.getPropertyName().equals("tableCellEditor")) {
//			if(isEditing) { //수정이끝나면
//				//변화된 값을 읽어와서 Db에 반영한다.
//				int selectedIndex = myTable.getSelectedRow();
//				int selectedNum = (int) myModel.getValueAt(selectedIndex,0);
//				String selectedContent = (String) myModel.getValueAt(selectedIndex,1);
//				String selectedRegdate = (String) myModel.getValueAt(selectedIndex,2);
//				MemoDto dto = new MemoDto(selectedNum,selectedContent,selectedRegdate);
//				myWork.update(dto);
//				isEditing = false;//수정중이 아니라고 표시한다.
//			}
//			isEditing = true;
//		}
	}
	
	final boolean STATE_SUCC = true;
	@Override	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("addClick")) {
			if(myWork.insert(getSelectedRowDto()) == STATE_SUCC) redrawTable();
		}
		else if(cmd.equals("modifyClick"))
		{
			if(myWork.update(getSelectedRowDto()) == STATE_SUCC) redrawTable();
		}
		else if(cmd.equals("deleteClick"))
		{
			if(myWork.delete(getSelectedRowDto()) == STATE_SUCC) redrawTable();
		}
		
	}
	
	public MemoDto getSelectedRowDto() {
		int selectedIndex = myTable.getSelectedRow();
		int selectedNum = (int) myModel.getValueAt(selectedIndex,0);
		String selectedContent = (String) myContent.getText();
		String selectedRegdate = (String) myModel.getValueAt(selectedIndex,2);	
		MemoDto data = new MemoDto(selectedNum,selectedContent,selectedRegdate);
		
		return data;
	}
	
	public void redrawTable() {
		myModel.setRowCount(0);
		List<MemoDto> myList = myWork.getList();
		if(myList == null) {
			JOptionPane.showMessageDialog(this, "테이블 갱신에 실패했습니다.");
			return;
		}
		for(MemoDto data : myList) {
			Object[] rowData = {data.getNum(),data.getContent(),data.getRegdate()};
			myModel.addRow(rowData);
		}
		//테이블의 마지막 행으로 자동이동.
		myTable.scrollRectToVisible(myTable.getCellRect(myTable.getRowCount()-1, 0, true));
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectRow = myTable.getSelectedRow();
		myContent.setText((String) myModel.getValueAt(selectRow, 1));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
