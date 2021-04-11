package de.kasalgado.virtualatm.controller;

import de.kasalgado.virtualatm.view.frame.MainFrame;

/**
 * VirtualATM is an application developed in Java and Java Swing,
 * which tries to simulate normal operations doing through a real
 * ATM machine.
 * 
 * @author Kleber Salgado
 * @version 1.0.0
 * @since 2021-02-10
 *
 */
public class Main {
	
	public Main() {
		super();
		
		try {
			new MainFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
