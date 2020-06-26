package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener, MouseListener, PropertyChangeListener{
	MemberDao myDao = null;
	MemberDto myData = null;
	JTextField inputName = null;
	JTextField inputAddr = null;
	DefaultTableModel model = null;
	JTable table = null;
	String[] colNames = {"번호","이름","주소"};
	
	public MemberFrame() {
		myDao = MemberDao.getInstance();
		
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(10);
		
		JLabel label2 = new JLabel("주소");
		inputAddr= new JTextField(10);
	
		JButton saveBtn = new JButton("저장");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("click");
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.addActionListener(this);
		deleteBtn.setActionCommand("delete");
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		add(panel,BorderLayout.NORTH);
		
		//표 형식으로 정보를 출력하기 위한 jtable
		table = new JTable();
		
		model = new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column == 0) return false;
				return true;
			}
		};
		table.setModel(model);
		table.addMouseListener(this);
		table.addPropertyChangeListener(this);
		
		//칼럼명을 String[]에 순서대로 준비
		//스크롤이 가능 하도록 테이블을 jscrollpane에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		//jscrollpane을 프레임의 가운대에 배치하기
		add(scroll,BorderLayout.CENTER);
		
		//jtable에 sample 데이터 출력해보기
		
		List<MemberDto> dataList = myDao.getList();
		getGUITable(dataList);		
	}
	
	
	public static void main(String[] args) {
		MemberFrame f = new MemberFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100,100,800,500);
		f.setVisible(true);
	}
	public void getGUITable(List<MemberDto> mListData) {
		model.setRowCount(0);//초기화하는 기능
		
		List<MemberDto> dataList = mListData;
		if(dataList == null) {
			System.out.println("데이터가 없습니다.");
		}
		else {
			for(MemberDto data : dataList)
			{
				Object[] rowData = {data.getNum(),data.getName(),data.getAddr()};
				model.addRow(rowData);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String getCmd = e.getActionCommand();
		if(getCmd.equals("click"))
		{
			System.out.println("오키");
			myData = new MemberDto();
			myData.setName(inputName.getText());
			myData.setAddr(inputAddr.getText());
			if(myDao.insert(myData) == false) {
				JOptionPane.showMessageDialog(this, "실패했습니다.");
			}
			else {
				List<MemberDto> dataList = myDao.getList();
				getGUITable(dataList);	
				JOptionPane.showMessageDialog(this, "정보를 추가했습니다.");
			}
		}
		else if(getCmd.equals("delete")) {
			int isState = JOptionPane.showConfirmDialog(this, "삭제하겠습니까?");
			if(isState == 0)
			{
				int[] mDeleteCount = table.getSelectedRows();
				System.out.println(mDeleteCount);
				if(mDeleteCount.length==0) {
					JOptionPane.showMessageDialog(this, "선택된 데이터가 없습니다");
					return;
				}
				for(int index : mDeleteCount)
				{
					int mNum = (int)model.getValueAt(index,0);
					myDao.delete(mNum);
				}
				List<MemberDto> dataList = myDao.getList();
				getGUITable(dataList);	

			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectRow = table.getSelectedRow();
		System.out.println(selectRow);
		int selectedNum = (int) model.getValueAt(selectRow,0);
		String selectedName = (String) model.getValueAt(selectRow,1);
		String selectedAddr = (String) model.getValueAt(selectRow,2);
		
		MemberDto myData = new MemberDto();
		myData.setNum(selectedNum);
		myData.setAddr(selectedAddr);
		myData.setName(selectedName);
		MemberDao.getInstance().update(myData);
		System.out.println(myData.getNum() + " | " + myData.getName() + " | " + myData.getAddr());
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

	boolean isEditing = false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
//		System.out.println("쩌좐");

//		System.out.println(evt.getPropertyName());
//		if(evt.getPropertyName().equals("tableCellEditor")) {
//			if(isEditing) { //수정이끝나면
//				//변화된 값을 읽어와서 Db에 반영한다.
//				int selectedIndex = table.getSelectedRow();
//				int selectedNum = (int) model.getValueAt(selectedIndex,0);
//				String selectedName = (String) model.getValueAt(selectedIndex,1);
//				String selectedAddr = (String) model.getValueAt(selectedIndex,2);
//				MemberDto dto = new MemberDto(selectedNum,selectedName,selectedAddr);
//				MemberDao.getInstance().update(dto);
//				isEditing = false;//수정중이 아니라고 표시한다.
//			}
//			isEditing = true;
//		}
	}
}
