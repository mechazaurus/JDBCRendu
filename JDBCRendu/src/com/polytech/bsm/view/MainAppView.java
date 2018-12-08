package com.polytech.bsm.view;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MainAppView extends JFrame {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JButton addAppartmentButton;
	private JButton searchAppartmentButton;
	private JButton displayFlatsAppartment;
	

	public MainAppView() {
		
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
		
		displayFlatsAppartment = new JButton("Display All Flats");
		displayFlatsAppartment.setBounds(186, 181, 203, 65);
		getContentPane().add(displayFlatsAppartment);

	}
	
	public void addAppartmentnListener(ActionListener listenAddButton)
	{
		addAppartmentButton.addActionListener(listenAddButton);
	}
	public void addSearchListener(ActionListener listenSearchButton)
	{
		searchAppartmentButton.addActionListener(listenSearchButton);
	}
	public void addDisplayFlatListener(ActionListener listenSearchButton)
	{
		displayFlatsAppartment.addActionListener(listenSearchButton);
	}
}
