package com.polytech.bsm.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFlatCreation extends JPanel {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JLabel addressLabel;
	private JLabel descriptionLabel;
	private JTextField addressTextField;
	private JTextField descriptionTextField;
	
	public PanelFlatCreation () {

		// Initialization
		this.setLayout(null);
		
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
		addressTextField.setBounds(50, 90, 600, 30);
		addressTextField.setFont(new Font("Serif", Font.PLAIN, 14));
		addressTextField.setVisible(true);
		add(addressTextField);
		
		// Description setup
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(50, 125, 200, 50);
		descriptionLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		descriptionLabel.setVisible(true);
		add(descriptionLabel);
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(50, 165, 600, 30);
		descriptionTextField.setFont(new Font("Serif", Font.PLAIN, 14));
		descriptionTextField.setVisible(true);
		add(descriptionTextField);
	}
}
