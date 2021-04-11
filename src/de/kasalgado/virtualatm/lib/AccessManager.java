package de.kasalgado.virtualatm.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.kasalgado.virtualatm.entity.User;
import de.kasalgado.virtualatm.helper.Messages;

public class AccessManager {
	
	public static User user;
	private String password;
	public static boolean isGranted = false;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User grantedUser) {
		user = grantedUser;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public AccessManager() {
		super();
	}

	public AccessManager(User grantedUser, String password) {
		user = grantedUser;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Loggin [user=" + user + ", password=" + password + "]";
	}
	
	public int check() {
		File file = new File("resources/credentials.csv");
		
		if (file.exists() && file.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while(br.ready()) {
					String line = br.readLine();
					String[] values = line.split(",");
					
					if (values[0].equals(this.user.getId())) {
						if (values[1].equals(this.password)) {
							return Messages.RESULT_BY_SUCCESS;
						}
					}
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return Messages.PASSWORD_IS_NOT_CORRECT;
	}
}
