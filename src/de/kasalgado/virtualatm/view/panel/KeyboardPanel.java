package de.kasalgado.virtualatm.view.panel;

import javax.swing.JPanel;

import de.kasalgado.virtualatm.entity.Transaction;
import de.kasalgado.virtualatm.entity.User;
import de.kasalgado.virtualatm.helper.TransactionType;
import de.kasalgado.virtualatm.lib.AccessManager;
import de.kasalgado.virtualatm.lib.TransactionManager;
import de.kasalgado.virtualatm.lib.UserManager;
import de.kasalgado.virtualatm.view.component.DisplayTextArea;

import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Dimension;

public class KeyboardPanel extends JPanel {
	
	private String amount = "";
	private User payee;
	private static boolean transferDataCompleted = false;

	public User getPayee() {
		return this.payee;
	}

	public void setPayee(User payee) {
		this.payee = payee;
	}

	public KeyboardPanel() {
		setBackground(UIManager.getColor("Button.background"));
		setBounds(new Rectangle(0, 0, 330, 220));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btn7 = new JButton("7");
		keyActionListener(btn7);
		btn7.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 1;
		gbc_btn7.gridy = 1;
		add(btn7, gbc_btn7);
		
		JButton btn8 = new JButton("8");
		keyActionListener(btn8);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 2;
		gbc_btn8.gridy = 1;
		add(btn8, gbc_btn8);
		
		JButton btn9 = new JButton("9");
		keyActionListener(btn9);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 3;
		gbc_btn9.gridy = 1;
		add(btn9, gbc_btn9);
		
		JButton btnClear = new JButton("Back");
		btnClear.setPreferredSize(new Dimension(90, 23));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
					String amountText = displayTextArea.getText();
					displayTextArea.setText(amountText.substring(0, amountText.length() - 1));
					amount = amount.substring(0, amount.length() - 1);
				}
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.fill = GridBagConstraints.VERTICAL;
		gbc_btnClear.gridheight = 2;
		gbc_btnClear.gridx = 4;
		gbc_btnClear.gridy = 1;
		add(btnClear, gbc_btnClear);
		
		JButton btn4 = new JButton("4");
		keyActionListener(btn4);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 1;
		gbc_btn4.gridy = 2;
		add(btn4, gbc_btn4);
		
		JButton btn5 = new JButton("5");
		keyActionListener(btn5);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 2;
		gbc_btn5.gridy = 2;
		add(btn5, gbc_btn5);
		
		JButton btn6 = new JButton("6");
		keyActionListener(btn6);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 3;
		gbc_btn6.gridy = 2;
		add(btn6, gbc_btn6);
		
		JButton btn1 = new JButton("1");
		keyActionListener(btn1);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 1;
		gbc_btn1.gridy = 3;
		add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton("2");
		keyActionListener(btn2);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 2;
		gbc_btn2.gridy = 3;
		add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton("3");
		keyActionListener(btn3);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 3;
		gbc_btn3.gridy = 3;
		add(btn3, gbc_btn3);
		
		JButton btnSend = new JButton("Send");
		btnSend.setVisible(true);
		btnSend.setPreferredSize(new Dimension(90, 30));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();					
					if (displayTextArea.getTransactionType() == TransactionType.TRANSFER) {
						if (transferDataCompleted) {
							String[] data = amount.split(",");
							UserManager userManager = new UserManager();
							userManager.findById(data[1]);
							payee = userManager.getUser();
							makeTransaction(data[0]);
						} else {
							displayTextArea.append("\nEnter Payee User ID: ");
							amount += ",";
							transferDataCompleted = true;
						}
					} else {
						makeTransaction(amount);
						amount = "";
					}					
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 5, 0);
		gbc_btnSend.gridx = 4;
		gbc_btnSend.gridy = 3;
		add(btnSend, gbc_btnSend);
		
		JButton btn0 = new JButton("0");
		keyActionListener(btn0);
		btn0.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 2;
		gbc_btn0.gridy = 4;
		add(btn0, gbc_btn0);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setVisible(false);
		btnTransfer.setPreferredSize(new Dimension(90, 30));
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnTransfer = new GridBagConstraints();
		gbc_btnTransfer.gridx = 4;
		gbc_btnTransfer.gridy = 3;
		add(btnTransfer, gbc_btnTransfer);

	}
	
	private void keyActionListener(JButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
					displayTextArea.append(btn.getText());
					amount += btn.getText();
				}
			}
		});
	}
	
	private void makeTransaction(String amount) {
		DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
		
		if (displayTextArea.getTransactionType() == TransactionType.TRANSFER) {
			TransactionManager managerDeposit = setTransaction(TransactionType.DEPOSIT, amount);
			managerDeposit.saveTransaction(this.payee);
			TransactionManager managerWithdraw = setTransaction(TransactionType.WITHDRAW, amount);
			managerWithdraw.saveTransaction();
		} else {
			TransactionManager manager = setTransaction(displayTextArea.getTransactionType(), amount);
			manager.saveTransaction();
		}
		
		displayTextArea.setText("Transaction successed.");
	}
	
	private TransactionManager setTransaction(TransactionType transactionType, String amount) {
		Transaction transaction = new Transaction(
				Integer.parseInt(amount),
				transactionType,
				LocalDateTime.now()
		);
		TransactionManager manager = new TransactionManager();
		manager.setTransaction(transaction);
		
		return manager;
	}

}
