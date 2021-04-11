package de.kasalgado.virtualatm.entity;

import java.time.LocalDateTime;

import de.kasalgado.virtualatm.helper.TransactionType;

public class Transaction {
	
	private LocalDateTime dateTime;
	private int amount;
	private TransactionType type;
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public TransactionType getType() {
		return this.type;
	}
	
	public void setType(TransactionType type) {
		this.type = type;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Transaction() {
		super();
	}

	public Transaction(int amount, TransactionType type, LocalDateTime dateTime) {
		super();
		this.amount = amount;
		this.type = type;
		this.dateTime = dateTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return amount + "," + type + "," + dateTime;
	}

}
