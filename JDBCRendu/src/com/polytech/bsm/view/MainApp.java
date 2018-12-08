package com.polytech.bsm.view;

import javax.swing.JFrame;

public class MainApp extends JFrame {

	// Attributes
	private static final long serialVersionUID = 1L;
	private PanelFlatCreation panelFlatCreation;
	

	public MainApp() {
		
		// Initialization
		panelFlatCreation = new PanelFlatCreation();
		
		// Main window setup
		setResizable(false);
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(panelFlatCreation);
		setContentPane(panelFlatCreation);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
