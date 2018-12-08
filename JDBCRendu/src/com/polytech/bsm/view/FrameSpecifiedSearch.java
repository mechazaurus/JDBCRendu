package com.polytech.bsm.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

public class FrameSpecifiedSearch extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField txtSpecifiedSearch;
	private JTextField bathroomField;
	private JTextField kitchenField;
	private JTextField bedroomField;
	private JButton btnSearch;
	
	public FrameSpecifiedSearch() 
	{
		getContentPane().setLayout(null);
		
		txtSpecifiedSearch = new JTextField();
		txtSpecifiedSearch.setText("Appartement Specified Search");
		txtSpecifiedSearch.setBounds(192, 17, 198, 26);
		getContentPane().add(txtSpecifiedSearch);
		txtSpecifiedSearch.setColumns(10);
		
		JTextArea txtrHowManyBathrooms = new JTextArea();
		txtrHowManyBathrooms.setText("How many bathrooms ?");
		txtrHowManyBathrooms.setBounds(49, 90, 156, 16);
		getContentPane().add(txtrHowManyBathrooms);
		
		bathroomField = new JTextField();
		bathroomField.setBounds(373, 85, 130, 26);
		getContentPane().add(bathroomField);
		bathroomField.setColumns(10);
		
		JTextArea txtrHowManyKitchens = new JTextArea();
		txtrHowManyKitchens.setText("How many kitchens ?");
		txtrHowManyKitchens.setBounds(49, 139, 156, 16);
		getContentPane().add(txtrHowManyKitchens);
		
		kitchenField = new JTextField();
		kitchenField.setColumns(10);
		kitchenField.setBounds(373, 134, 130, 26);
		getContentPane().add(kitchenField);
		
		JTextArea txtrHowManyBedrooms = new JTextArea();
		txtrHowManyBedrooms.setText("How many bedrooms ?");
		txtrHowManyBedrooms.setBounds(49, 185, 156, 16);
		getContentPane().add(txtrHowManyBedrooms);
		
		bedroomField = new JTextField();
		bedroomField.setColumns(10);
		bedroomField.setBounds(373, 180, 130, 26);
		getContentPane().add(bedroomField);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(224, 247, 117, 29);
		getContentPane().add(btnSearch);
		setPreferredSize(new Dimension(739, 634));
		
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setTitle("Search Appartments");
         setLocationRelativeTo(null);
         setVisible(false);
         setSize(600, 500);
		
	}
	
	public void addSearchListener(ActionListener listenSearchButton)
	{
		btnSearch.addActionListener(listenSearchButton);
	}
	
	
}
