package de.kasalgado.virtualatm.view.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.kasalgado.virtualatm.entity.Transaction;
import de.kasalgado.virtualatm.lib.AccessManager;
import de.kasalgado.virtualatm.lib.AccountManager;
import de.kasalgado.virtualatm.lib.TransactionManager;
import de.kasalgado.virtualatm.view.component.DisplayTextArea;
import de.kasalgado.virtualatm.view.frame.MainFrame;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class UserPanel extends JPanel {

	public UserPanel() {
		setBounds(new Rectangle(0, 0, 153, 220));
		
		JButton btnShowTransactions = new JButton("Transactions");
		btnShowTransactions.setPreferredSize(new Dimension(120, 40));
		btnShowTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					TransactionManager manager = new TransactionManager();
					List<Transaction> transactions = manager.getTransactions();
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
					displayTextArea.setText("");
					
					for (Transaction transaction : transactions) {
						displayTextArea.append(transaction.toString() + "\n");
					}
				}
			}
		});
		
		JButton btnShowSaldo = new JButton("Show Saldo");
		btnShowSaldo.setPreferredSize(new Dimension(120, 40));
		btnShowSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					AccountManager manager = new AccountManager();
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
					displayTextArea.setText("Your saldo: " + Integer.toString(manager.getSaldo()));
				}
			}
		});
		
		add(btnShowSaldo);
		add(btnShowTransactions);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
					displayTextArea.setText("Welcome to your Virtual ATM\nVersion 1.0\nCopyright KASalgado 2021\n\r\nPlease enter your user ID:");
					AccessManager.isGranted = false;
					JTextField accessTextField = AccessPanel.getAccessTextField();
					accessTextField.setEnabled(true);
					JButton btnVerifyAccess = AccessPanel.getBtnVerifyAccess();
					btnVerifyAccess.setEnabled(true);
				}
			}
		});
		btnExit.setPreferredSize(new Dimension(120, 40));
		add(btnExit);
	}

}
