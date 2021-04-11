package de.kasalgado.virtualatm.entity;

import java.util.List;

public class Account {
	
	private User user;
	private String password;
	private List<Transaction> transacations;
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Transaction> getTransacations() {
		return this.transacations;
	}
	
	public void setTransacations(List<Transaction> transacations) {
		this.transacations = transacations;
	}

	public Account() {
		super();
	}

	public Account(User user, String password, List<Transaction> transacations) {
		super();
		this.user = user;
		this.password = password;
		this.transacations = transacations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((transacations == null) ? 0 : transacations.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (transacations == null) {
			if (other.transacations != null)
				return false;
		} else if (!transacations.equals(other.transacations))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [user=" + user + ", password=" + password + ", transacations=" + transacations + "]";
	}

}
