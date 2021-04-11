package de.kasalgado.virtualatm.lib;

import java.util.List;

import de.kasalgado.virtualatm.entity.Transaction;

public class AccountManager {
	
	public int getSaldo() {
		TransactionManager manager = new TransactionManager();
		List<Transaction> transactions = manager.getTransactions();
		int saldo = 0;
		
		for (Transaction transaction : transactions) {
			switch (transaction.getType().getType()) {
				case 1:
					saldo += transaction.getAmount();
					break;
					
				case 2:
					saldo -= transaction.getAmount();
					break;
			}
		}
		
		return saldo;
	}
}
