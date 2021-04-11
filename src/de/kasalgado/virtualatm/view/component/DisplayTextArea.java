package de.kasalgado.virtualatm.view.component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextArea;

import de.kasalgado.virtualatm.helper.TransactionType;

import java.awt.Color;
import java.awt.Rectangle;

public class DisplayTextArea extends JTextArea {
	
	private static DisplayTextArea instance;
	private TransactionType transactionType;
	
	public static DisplayTextArea getInstance() {
		synchronized (DisplayTextArea.class) {
			if (instance == null) {
				instance = new DisplayTextArea();
			}
		}
		
		return instance;
	}
	
	public DisplayTextArea() {
		super();
		setBounds(new Rectangle(0, 0, 310, 215));
		setFocusable(false);
		setEditable(false);
		setCaretColor(Color.GREEN);
		setBackground(Color.BLACK);
		setForeground(Color.GREEN);
		setFocusTraversalKeysEnabled(false);
		setFont(new Font("Monospaced", Font.PLAIN, 15));
		setPreferredSize(new Dimension(310, 215));
		setText("Welcome to your Virtual ATM\nVersion 1.0\nCopyright KASalgado 2021\n\r\nPlease enter your user ID:");
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}
