package com.polytech.bsm.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Dimension;

import javax.swing.JButton;

public class PanelSpecifiedSearch extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTextField txtSpecifiedSearch;
	private JTextField bathroomField;
	private JTextField kitchenField;
	private JTextField textField_2;
	public PanelSpecifiedSearch() 
	{
		setLayout(null);
		
		txtSpecifiedSearch = new JTextField();
		txtSpecifiedSearch.setText("Appartement Specified Search");
		txtSpecifiedSearch.setBounds(192, 17, 198, 26);
		add(txtSpecifiedSearch);
		txtSpecifiedSearch.setColumns(10);
		
		JTextArea txtrHowManyBathrooms = new JTextArea();
		txtrHowManyBathrooms.setText("How many bathrooms ?");
		txtrHowManyBathrooms.setBounds(49, 90, 156, 16);
		add(txtrHowManyBathrooms);
		
		bathroomField = new JTextField();
		bathroomField.setBounds(373, 85, 130, 26);
		add(bathroomField);
		bathroomField.setColumns(10);
		
		JTextArea txtrHowManyKitchens = new JTextArea();
		txtrHowManyKitchens.setText("How many kitchens ?");
		txtrHowManyKitchens.setBounds(49, 139, 156, 16);
		add(txtrHowManyKitchens);
		
		kitchenField = new JTextField();
		kitchenField.setColumns(10);
		kitchenField.setBounds(373, 134, 130, 26);
		add(kitchenField);
		
		JTextArea txtrHowManyBedrooms = new JTextArea();
		txtrHowManyBedrooms.setText("How many bedrooms ?");
		txtrHowManyBedrooms.setBounds(49, 185, 156, 16);
		add(txtrHowManyBedrooms);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(373, 180, 130, 26);
		add(textField_2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(224, 247, 117, 29);
		add(btnSearch);
		setPreferredSize(new Dimension(739, 634));
		
		
		setVisible(true);
		
	}
}
