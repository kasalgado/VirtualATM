package de.kasalgado.virtualatm.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Messages {
	
	public static int RESULT_BY_SUCCESS = -1;
	public static int USER_WAS_NOT_FOUND = 1;
	public static int PASSWORD_IS_NOT_CORRECT = 2;
	public static int ACCESS_GRANTED = 3;
	public static int ENTER_PASSWORD = 4;
	
	private String id;
	private String message;
	
	public String getId() {
		return this.id;
	}
	
	public String getMessage() {
		return this.message;
	}

	public Messages() {
		super();
	}

	public Messages(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Messages [id=" + id + ", message=" + message + "]";
	}
	
	public String findById() {
		File file = new File("resources/messages.csv");
		
		if (file.exists() && file.isFile()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while(br.ready()) {
					String line = br.readLine();
					String[] values = line.split(",");
					
					if (values[0].equals(this.getId())) {
						return values[1];
					}
				}
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return "Message not found";
	}

}
