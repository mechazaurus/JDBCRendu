package com.polytech.bsm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.polytech.bsm.model.FlatState;

public class PanelFlatCreation extends JPanel {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JLabel descriptionLabel;
	private JTextField descriptionTextField;
	private JLabel flatStateLabel;
	private JComboBox<String> flatStateComboBox;
	private JLabel localLabel;
	private JButton addLocalButton;
	private JTable localTable;
	
	public PanelFlatCreation () {

		// Initialization
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		// Title setup
		titleLabel = new JLabel("Flat creation");
		titleLabel.setBounds(50, 25, 200, 20);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		titleLabel.setVisible(true);
		add(titleLabel);
		
		// Address setup
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(50, 50, 200, 50);
		addressLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		addressLabel.setVisible(true);
		add(addressLabel);
		addressTextField = new JTextField();
		addressTextField.setBounds(50, 90, 450, 30);
		addressTextField.setFont(new Font("Serif", Font.PLAIN, 14));
		addressTextField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		addressTextField.setVisible(true);
		add(addressTextField);
		
		// Description setup
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(50, 125, 200, 50);
		descriptionLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		descriptionLabel.setVisible(true);
		add(descriptionLabel);
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(50, 165, 450, 60);
		descriptionTextField.setFont(new Font("Serif", Font.PLAIN, 14));
		descriptionTextField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		descriptionTextField.setVisible(true);
		add(descriptionTextField);
		
		// Flat state setup
		flatStateLabel = new JLabel("State");
		flatStateLabel.setBounds(50, 225, 200, 50);
		flatStateLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		flatStateLabel.setVisible(true);
		add(flatStateLabel);
		flatStateComboBox = new JComboBox<String>();
		flatStateComboBox.addItem(FlatState.UNDER_CONSTRUCTION.toString());
		flatStateComboBox.addItem(FlatState.READY.toString());
		flatStateComboBox.setBounds(50, 265, 175, 30);
		flatStateComboBox.setFont(new Font("Serif", Font.BOLD, 14));
		flatStateComboBox.setVisible(true);
		add(flatStateComboBox);
		
		// Add local
		localLabel = new JLabel("Local");
		localLabel.setBounds(50, 300, 200, 30);
		localLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		localLabel.setVisible(true);
		add(localLabel);
		addLocalButton = new JButton("Add local");
		addLocalButton.setBounds(830, 300, 120, 30);
		addLocalButton.setFont(new Font("Serif", Font.BOLD, 14));
		addLocalButton.setVisible(true);
		add(addLocalButton);
		localTable = new JTable();
		localTable.setBounds(50, 335, 900, 400);
		localTable.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		localTable.setVisible(true);
		add(localTable);
	}
}
