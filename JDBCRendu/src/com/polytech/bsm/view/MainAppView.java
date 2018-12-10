package com.polytech.bsm.view;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainAppView extends JFrame {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JButton addFlatButton;
	private JButton searchFlatButton;
	private JButton displayFlatsButton;
	

	public MainAppView() {

		getContentPane().setLayout(null);

		// Flat button setup
		addFlatButton = new JButton("Add appartement");
		addFlatButton.setBounds(25, 25, 200, 65);
		getContentPane().add(addFlatButton);

		// Search button setup
		searchFlatButton = new JButton("Search appartments");
		searchFlatButton.setBounds(25, 115, 200, 65);
		getContentPane().add(searchFlatButton);

		// Display button setup
		displayFlatsButton = new JButton("Appartments list");
		displayFlatsButton.setBounds(25, 205, 200, 65);
		getContentPane().add(displayFlatsButton);

		// Main window setup
		setResizable(false);
		setSize(250, 340);
		setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void addFlatListener(ActionListener listenAddButton) {
		addFlatButton.addActionListener(listenAddButton);
	}

	public void addSearchListener(ActionListener listenSearchButton) {
		searchFlatButton.addActionListener(listenSearchButton);
	}

	public void addDisplayFlatListener(ActionListener listenSearchButton) {
		displayFlatsButton.addActionListener(listenSearchButton);
	}
}
