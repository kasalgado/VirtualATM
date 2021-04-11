package de.kasalgado.virtualatm.view.frame;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import de.kasalgado.virtualatm.view.panel.AccessPanel;
import de.kasalgado.virtualatm.view.panel.DisplayPanel;
import de.kasalgado.virtualatm.view.panel.KeyboardPanel;
import de.kasalgado.virtualatm.view.panel.TransactionPanel;
import de.kasalgado.virtualatm.view.panel.UserPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MainFrame {

	private JFrame MainFrame;

	public JFrame getMainFrame() {
		return this.MainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		MainFrame = mainFrame;
	}

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		MainFrame = new JFrame();
		MainFrame.setTitle("Virtual ATM");
		MainFrame.setBounds(new Rectangle(100, 100, 640, 480));
		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainTopPanel = new JPanel();
		mainTopPanel.setPreferredSize(new Dimension(640, 220));
		MainFrame.getContentPane().add(mainTopPanel, BorderLayout.NORTH);
		mainTopPanel.setLayout(null);
		
		JPanel rightTopPanel = new TransactionPanel();
		rightTopPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		rightTopPanel.setBackground(SystemColor.inactiveCaptionBorder);
		rightTopPanel.setBounds(0, 0, 153, 220);
		mainTopPanel.add(rightTopPanel);
		
		JPanel leftTopPanel = new UserPanel();
		leftTopPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		leftTopPanel.setBackground(SystemColor.inactiveCaptionBorder);
		leftTopPanel.setBounds(481, 0, 153, 220);
		mainTopPanel.add(leftTopPanel);
		
		JPanel centerTopPanel = new DisplayPanel();
		centerTopPanel.setBounds(152, 0, 328, 220);
		mainTopPanel.add(centerTopPanel);
		
		JPanel mainBottomPanel = new JPanel();
		mainBottomPanel.setPreferredSize(new Dimension(640, 220));
		MainFrame.getContentPane().add(mainBottomPanel, BorderLayout.SOUTH);
		mainBottomPanel.setLayout(null);
		
		JPanel rightBottomPanel = new AccessPanel();
		rightBottomPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		rightBottomPanel.setBounds(481, 0, 153, 220);
		mainBottomPanel.add(rightBottomPanel);
		
		JPanel leftBottomPanel = new JPanel();
		leftBottomPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		leftBottomPanel.setBounds(0, 0, 153, 220);
		mainBottomPanel.add(leftBottomPanel);
		
		JPanel centerBottomPanel = new KeyboardPanel();
		centerBottomPanel.setBounds(202, 11, 258, 177);
		mainBottomPanel.add(centerBottomPanel);
		
		MainFrame.setVisible(true);
	}
}
