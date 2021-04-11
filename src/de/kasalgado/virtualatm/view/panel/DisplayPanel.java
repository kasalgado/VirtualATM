package de.kasalgado.virtualatm.view.panel;

import javax.swing.JPanel;
import java.awt.Dimension;
import de.kasalgado.virtualatm.view.component.DisplayTextArea;
import java.awt.Color;

public class DisplayPanel extends JPanel {
	
	public DisplayPanel() {
		setBackground(Color.BLACK);
		DisplayTextArea displayTextArea = DisplayTextArea.getInstance();
		setPreferredSize(new Dimension(328, 220));		
		add(displayTextArea);
	}

}
