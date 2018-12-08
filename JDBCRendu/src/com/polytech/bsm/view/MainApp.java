package com.polytech.bsm.view;

import javax.swing.JFrame;

import Views.PanelSpecifiedSearch;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MainApp extends JFrame {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JButton addAppartmentButton;
	private JButton searchAppartmentButton;
	

	public MainApp() {
		
		// Main window setup
		setResizable(false);
		setSize(600, 500);
		setLocationRelativeTo(null);
		
		addAppartmentButton = new JButton("Add Appartement");
		addAppartmentButton.setBounds(28, 33, 203, 65);
		getContentPane().add(addAppartmentButton);

		searchAppartmentButton = new JButton("Search Appartment");
		searchAppartmentButton.setBounds(373, 33, 203, 65);
		getContentPane().add(searchAppartmentButton);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		setVisible(true);
	}

	
}
