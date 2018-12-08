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
	private PanelFlatCreation panelFlatCreation;
	private PanelSpecifiedSearch panelSpecifiedSearch;
	private JButton addAppartmentButton;
	private JButton searchAppartmentButton;
	private JPanel mainAppPanel;
	

	public MainApp() {
		
		// Initialization
		panelFlatCreation = new PanelFlatCreation();
		panelSpecifiedSearch = new PanelSpecifiedSearch();
		
		// Main window setup
		setResizable(false);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		addAppartmentButton = new JButton("Add Appartement");
		addAppartmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addAppartmentButton.setBounds(82, 33, 203, 65);
		getContentPane().add(addAppartmentButton);

		searchAppartmentButton = new JButton("Search Appartment");
		searchAppartmentButton.setBounds(492, 33, 203, 65);
		getContentPane().add(searchAppartmentButton);
		
		mainAppPanel = new JPanel();
		mainAppPanel.setBounds(28, 117, 739, 634);
		getContentPane().add(mainAppPanel);
		mainAppPanel = panelSpecifiedSearch;
		mainAppPanel.setVisible(true);
		
	}
	
	public void setInvisibleAllPanels()
	{
		panelFlatCreation.setVisible(false);
		panelSpecifiedSearch.setVisible(false);
	}
	
	public void setPanelFlatCreationON()
	{
		setInvisibleAllPanels();
		mainAppPanel = panelFlatCreation;
		panelFlatCreation.setVisible(true);
	}
	public void setSpecifiedSearchPanelON()
	{
		setInvisibleAllPanels();
		mainAppPanel = panelSpecifiedSearch;
		panelSpecifiedSearch.setVisible(true);
	}
	
	
	
}
