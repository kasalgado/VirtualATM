package de.kasalgado.virtualatm.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import de.kasalgado.virtualatm.entity.Transaction;
import de.kasalgado.virtualatm.entity.User;
import de.kasalgado.virtualatm.helper.TransactionType;

public class TransactionManager {
	
	private List<Transaction> transactions;
	private Transaction transaction;

	public List<Transaction> getTransactions() {
		User user = AccessManager.user;
		File file = new File("resources/account_" + user.getId() + ".csv");
		
		if (file.exists() && file.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				transactions = new ArrayList<>();
				
				while(br.ready()) {
					String line = br.readLine();
					String[] values = line.split(",");
					TransactionType[] transactionTypes = TransactionType.values();
					Transaction transaction = new Transaction(
							Integer.parseInt(values[0]),
							transactionTypes[Integer.parseInt(values[1])],
							LocalDateTime.parse(values[2])
					);
					transactions.add(transaction);
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return this.transactions;
	}
	
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public Transaction getTransaction() {
		return this.transaction;
	}

	public TransactionManager() {
		super();
	}
	
	public void saveTransaction() {
		User user = AccessManager.user;
		writeFile(user.getId());
	}
	
	public void saveTransaction(User payeeUser) {
		writeFile(payeeUser.getId());
	}
	
	private void writeFile(String userId) {
		try {
		    File file = new File("resources/account_" + userId + ".csv");
		    FileWriter fw = new FileWriter(file, true);
		    PrintWriter pw = new PrintWriter(fw);
		    pw.println(this.transaction.getAmount() + "," + this.transaction.getType().ordinal() + "," + this.transaction.getDateTime());
		    pw.flush();
		    pw.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
