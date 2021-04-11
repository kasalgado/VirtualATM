package de.kasalgado.virtualatm.view.panel;

import javax.swing.JPanel;

import de.kasalgado.virtualatm.helper.TransactionType;
import de.kasalgado.virtualatm.lib.AccessManager;
import de.kasalgado.virtualatm.view.component.DisplayTextArea;

import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class TransactionPanel extends JPanel {
	
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnTransfer;

	public JButton getBtnDeposit() {
		return this.btnDeposit;
	}

	public void setBtnDeposit(JButton btnDeposit) {
		this.btnDeposit = btnDeposit;
	}

	public JButton getBtnWithdraw() {
		return this.btnWithdraw;
	}

	public void setBtnWithdraw(JButton btnWithdraw) {
		this.btnWithdraw = btnWithdraw;
	}

	public JButton getBtnTransfer() {
		return this.btnTransfer;
	}

	public void setBtnTransfer(JButton btnTransfer) {
		this.btnTransfer = btnTransfer;
	}

	public TransactionPanel() {
		setBounds(new Rectangle(0, 0, 153, 220));
		
		btnDeposit = new JButton("Deposit");
		btnDeposit.setPreferredSize(new Dimension(120, 40));
		btnActionListener(btnDeposit, TransactionType.DEPOSIT);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setPreferredSize(new Dimension(120, 40));
		btnActionListener(btnWithdraw, TransactionType.WITHDRAW);
		
		btnTransfer = new JButton("Tranfer");
		btnTransfer.setPreferredSize(new Dimension(120, 40));
		btnActionListener(btnTransfer, TransactionType.TRANSFER);
		
		add(btnDeposit);
		add(btnWithdraw);
		add(btnTransfer);
	}
	
	private void btnActionListener(JButton btn, TransactionType transactionType) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AccessManager.isGranted) {
					DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
					displayTextArea.setTransactionType(transactionType);
					displayTextArea.setText(btn.getText() + ":\nPlease use the keyboard\nAmount: ");
				}
			}
		});
	}

}
