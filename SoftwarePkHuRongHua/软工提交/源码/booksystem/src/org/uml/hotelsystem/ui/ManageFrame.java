package org.uml.hotelsystem.ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.uml.hotelsystem.controler.ManageViewController;
import org.uml.hotelsystem.dao.TbAccount;
import org.uml.hotelsystem.dao.TbGood;

import Utils.Constant;

public class ManageFrame extends JFrame {
	
	JFrame frame;
	private JTabbedPane tab;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private ManageViewController manageViewController;
	private ArrayList<TbGood> tbGoodList;
	private ArrayList<TbAccount> tbAccountList;
	int rowIndex;
	int rowIndex_1;
	int rowIndex_2;
	
	private int identify;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				try {
					ManageFrame window = new ManageFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	protected void processWindowEvent(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
			return;
		}
		super.processWindowEvent(e);
	}
	

	/**
	 * Create the application.
	 */
	public ManageFrame() {
		manageViewController = ManageViewController.getInstance();
		initialize();
		refreshGoodTable();
	}
	
	public ManageFrame(int i) {
		identify = i;
		manageViewController = ManageViewController.getInstance();
		initialize();
		refreshGoodTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel combop = new JPanel();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		tab = new JTabbedPane(JTabbedPane.TOP); 
		
		JPanel p2 = new JPanel();
		tab.add(p2, "物品列表");
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					rowIndex_1 = table_1.getSelectedRow();
			}

		});
		JScrollPane scrollPane_1 = new JScrollPane(table_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(22, 44, 391, 157);
		p2.add(scrollPane_1);
		
		
		JPanel p3 = new JPanel();
		tab.add(p3, "用户列表");
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					rowIndex_2 = table_2.getSelectedRow();
			}

		});
		JScrollPane scrollPane_2 = new JScrollPane(table_2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setBounds(22, 44, 391, 157);
		p3.add(scrollPane_2);
		
		frame.getContentPane().add(tab, BorderLayout.CENTER);
		frame.getContentPane().add(combop, BorderLayout.EAST);
		combop.setLayout(new GridLayout(0, 1, 5, 5));
		btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(tab.getSelectedIndex() == 0){
					new ManageNewGoodFrame(ManageFrame.this).setVisible(true);
				}else if(tab.getSelectedIndex() == 1){
					if(identify == 1){
						JOptionPane.showMessageDialog(null, "没有该权限", null,
								JOptionPane.ERROR_MESSAGE);
					}else{
						new ManageNewAccountFrame(ManageFrame.this).setVisible(true);
					}
				}
			}
		});
		combop.add(btnNewButton);
		
		btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(tab.getSelectedIndex() == 0){
					TbGood room = new TbGood();
					room.setGoodId((Integer)table_1.getModel().getValueAt(rowIndex_1, 0));
					manageViewController.removeGood(room);
					refreshGoodTable();
				}else if(tab.getSelectedIndex() == 1){
					if(identify == 1){
						JOptionPane.showMessageDialog(null, "没有该权限", null,
								JOptionPane.ERROR_MESSAGE);
					}else{
						TbAccount account = new TbAccount();
						account.setAccountId((Integer)table_2.getModel().getValueAt(rowIndex_2, 0));
						manageViewController.removeAccount(account);
						refreshAccountTable();
					}
				}
			}
		});
		tab.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub]
				btnNewButton_1.setEnabled(false);
				btnNewButton_2.setEnabled(false);
				if(tab.getSelectedIndex() == 0){
					refreshGoodTable();
				}else if(tab.getSelectedIndex() == 1){
					refreshAccountTable();
				}
			}
		});
		btnNewButton_1.setEnabled(false);
		combop.add(btnNewButton_1);
		btnNewButton_2 = new JButton("编辑");
		btnNewButton_2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(tab.getSelectedIndex() == 0){
					new ManageGoodEditFrame((Integer)table_1.getModel().getValueAt(rowIndex_1, 0)).setVisible(true);
				}else if(tab.getSelectedIndex() == 1){
					
					if(identify == 1){
						JOptionPane.showMessageDialog(null, "没有该权限", null,
								JOptionPane.ERROR_MESSAGE);
					}else{
						new ManageAccountEditFrame((Integer)table_2.getModel().getValueAt(rowIndex_2, 0)).setVisible(true);
					}
				}
				
			}
		});
		btnNewButton_2.setEnabled(false);
		combop.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("退出");
		btnNewButton_3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				frame.dispose();
			}
		});
		combop.add(btnNewButton_3);
		
	}
	
	public void refreshGoodTable() {
		tbGoodList = manageViewController.getAllGood();
		table_1.setModel(new DefaultTableModel(
				manageViewController.arrToListGoodModel(tbGoodList),
				new String[] {
					"图书编号", "图书名称", "租借价格", "是否可借"
				}) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Double.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int row, int column) 
                { 
                    return false;
                }
			});
	}
	
	public void refreshAccountTable() {
		tbAccountList = manageViewController.getAllAccount();
		table_2.setModel(new DefaultTableModel(
				manageViewController.arrToListAccountModel(tbAccountList),
				new String[] {
					"用户编号", "用户账号", "用户姓名", "用户密码", "用户权限", "是否可用"
				}) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, Integer.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int row, int column) 
                { 
                    return false;
                }
			});
	}
	
}

