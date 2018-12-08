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
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		addAppartmentButton = new JButton("Add Appartement");
		addAppartmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addAppartmentButton.setBounds(28, 33, 203, 65);
		getContentPane().add(addAppartmentButton);

		searchAppartmentButton = new JButton("Search Appartment");
		searchAppartmentButton.setBounds(373, 33, 203, 65);
		getContentPane().add(searchAppartmentButton);
		
		mainAppPanel = new JPanel();
		mainAppPanel.setBounds(28, 117, 541, 351);
		this.getContentPane().add(mainAppPanel);
		mainAppPanel.setLayout(null);
		setSpecifiedSearchPanelON();
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
