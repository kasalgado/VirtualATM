package de.kasalgado.virtualatm.helper;

public enum TransactionType {
	
	DEPOSIT(1), WITHDRAW(2), TRANSFER(3);
	
	private TransactionType(int type) {
		this.type = type;
	}
	
	private int type;
	
	public int getType() {
		return type;
	}

}
