/*
 * LoginFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package org.uml.hotelsystem.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.uml.hotelsystem.controler.LoginViewController;

import Utils.Constant;

/**
 *
 * @author  __USER__
 */
public class LoginFrame extends javax.swing.JFrame {

	private LoginViewController loginViewController;

	/** Creates new form LoginFrame */
	public LoginFrame() {
		initComponents();
		initFrame();
	}

	private void initFrame() {
		loginViewController = LoginViewController.getInstance();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		btn_login = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jf_username = new javax.swing.JTextField();
		pf_password = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		btn_login.setText("\u767b\u5f55");
		btn_login.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_loginActionPerformed(evt);
			}
		});

		jLabel1.setText("\u8d26\u53f7\uff1a");

		jLabel2.setText("\u5bc6\u7801\uff1a");

		jf_username.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jf_usernameActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(75, 75, 75)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jLabel2,
														javax.swing.GroupLayout.Alignment.TRAILING))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														pf_password,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														199, Short.MAX_VALUE)
												.addComponent(
														jf_username,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														199, Short.MAX_VALUE))
								.addGap(85, 85, 85))
				.addGroup(
						layout.createSequentialGroup().addGap(155, 155, 155)
								.addComponent(btn_login)
								.addContainerGap(188, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(96, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jf_username,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														pf_password,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(52, 52, 52).addComponent(btn_login)
								.addGap(65, 65, 65)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-END:initComponents

	private void jf_usernameActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here
		String username = jf_username.getText().toString();
		String password = pf_password.getText().toString();
		if (username.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空", null,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", null,
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int issuccess = loginViewController.login(username, password);
		if (issuccess == 10) {
			JOptionPane.showMessageDialog(null, "账号或密码错误", null,
					JOptionPane.ERROR_MESSAGE);
		} else if (issuccess == 11) {
			JOptionPane.showMessageDialog(null, "该账号已被注销", null,
					JOptionPane.ERROR_MESSAGE);
		} else if (issuccess == 0) {
			ManageFrame manageFrame = new ManageFrame();
			int windowWidth = manageFrame.frame.getWidth();
			int windowHeight = manageFrame.frame.getHeight();
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenWidth = screenSize.width;
			int screenHeight = screenSize.height;
			manageFrame.frame.setLocation(screenWidth / 2 - windowWidth / 2,
					screenHeight / 2 - windowHeight / 2);
			manageFrame.frame.setVisible(true);
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "超级管理员", null,
					JOptionPane.ERROR_MESSAGE);
		} else if (issuccess == 1) {
			ManageFrame manageFrame = new ManageFrame(1);
			int windowWidth = manageFrame.frame.getWidth();
			int windowHeight = manageFrame.frame.getHeight();
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			int screenWidth = screenSize.width;
			int screenHeight = screenSize.height;
			manageFrame.frame.setLocation(screenWidth / 2 - windowWidth / 2,
					screenHeight / 2 - windowHeight / 2);
			manageFrame.frame.setVisible(true);
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "普通管理员", null,
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				Frame frame = new LoginFrame();
				int windowWidth = frame.getWidth();
				int windowHeight = frame.getHeight();
				Toolkit kit = Toolkit.getDefaultToolkit();
				Dimension screenSize = kit.getScreenSize();
				int screenWidth = screenSize.width;
				int screenHeight = screenSize.height;
				frame.setLocation(screenWidth / 2 - windowWidth / 2,
						screenHeight / 2 - windowHeight / 2);
				frame.setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btn_login;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField jf_username;
	private javax.swing.JPasswordField pf_password;
	// End of variables declaration//GEN-END:variables

}