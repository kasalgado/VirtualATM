package de.kasalgado.virtualatm.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.kasalgado.virtualatm.entity.User;
import de.kasalgado.virtualatm.helper.Messages;

public class UserManager {
	
	private User user;
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int findById(String id) {
		return search(id);
	}
	
	private int search(String id) {
		File file = new File("resources/users.csv");
		
		if (file.exists() && file.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while(br.ready()) {
					String line = br.readLine();
					String[] values = line.split(",");
					
					if (values[0].equals(id)) {
						user = new User();
						user.setId(values[0]);
						user.setFirstname(values[1]);
						user.setLastname(values[2]);
						
						return Messages.ACCESS_GRANTED;
					}	
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return Messages.USER_WAS_NOT_FOUND;
	}

}
