package de.kasalgado.virtualatm.view.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.kasalgado.virtualatm.entity.User;
import de.kasalgado.virtualatm.helper.Messages;
import de.kasalgado.virtualatm.lib.AccessManager;
import de.kasalgado.virtualatm.lib.UserManager;
import de.kasalgado.virtualatm.view.component.DisplayTextArea;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JLabel;

public class AccessPanel extends JPanel {
	
	private static final int LOWEST_LEVEL_SEARCHING = 0;
	
	private static JTextField accessTextField;
	private static JButton btnVerifyAccess;
	private User user;
	private int userLevelAccess;
	private static boolean userGranted = false;

	public AccessPanel() {
		setPreferredSize(new Dimension(153, 220));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTitle = new JLabel("ID:");
		lblTitle.setPreferredSize(new Dimension(125, 14));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblTitle);
		
		accessTextField = new JTextField();
		accessTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		accessTextField.setSize(new Dimension(120, 25));
		accessTextField.setBounds(new Rectangle(0, 0, 120, 25));
		accessTextField.setPreferredSize(new Dimension(120, 25));
		accessTextField.setColumns(11);
		add(accessTextField);
		
		btnVerifyAccess = new JButton("Enter");
		btnVerifyAccess.setPreferredSize(new Dimension(125, 30));
		btnVerifyAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!userGranted) {
					boolean isGranted = getUserAccess();
					if (isGranted) {
						lblTitle.setText("PASSWORD:");
					}
				} else {
					getPasswordAccess();
				}
			}
		});
		add(btnVerifyAccess);
	}
	
	public static JTextField getAccessTextField() {
		return accessTextField;
	}
	
	public static JButton getBtnVerifyAccess() {
		return btnVerifyAccess;
	}

	private String displayMessage(int id) {
		Messages messages = new Messages(Integer.toString(id));
		
		return messages.findById();
	}
	
	private boolean getUserAccess() {
		UserManager userManager = new UserManager();
		userLevelAccess = userManager.findById(accessTextField.getText());
		DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
		
		if (userLevelAccess == Messages.ACCESS_GRANTED) {
			userGranted = true;
			user = userManager.getUser();
			displayTextArea.setText(displayMessage(Messages.ENTER_PASSWORD));
			accessTextField.setText("");			
			return true;
		}
		
		displayTextArea.setText(displayMessage(userLevelAccess));
		return false;
	}
	
	private void getPasswordAccess() {
		AccessManager login = new AccessManager(user, accessTextField.getText());
		int checkPassword = login.check();
		DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
		
		if (checkPassword < LOWEST_LEVEL_SEARCHING) {
			displayTextArea.setText(displayMessage(userLevelAccess));
			accessTextField.setText("");
			accessTextField.setEnabled(false);
			btnVerifyAccess.setEnabled(false);
			AccessManager.isGranted = true;
		} else {
			displayTextArea.setText(displayMessage(checkPassword));
		}
	}

}
