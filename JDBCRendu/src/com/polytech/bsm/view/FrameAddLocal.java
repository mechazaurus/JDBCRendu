package com.polytech.bsm.view;

import com.polytech.bsm.model.LocalType;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.Vector;

public class FrameAddLocal extends JFrame {

	// Attributes
	private static final long serialVersionUID = 1L;
	private JComboBox<String> typeComboBox;
	private JButton btnAddLocal;
	private JLabel labelSize;
	private JLabel labelSpec;
	private JTextField sizeField;
	private JTextField specField;
	
	public FrameAddLocal() {

		getContentPane().setLayout(null);

		// Type setup
		JLabel labelLocalType = new JLabel();
		labelLocalType.setText("Type");
		labelLocalType.setBounds(59, 62, 81, 22);
		getContentPane().add(labelLocalType);
		
		Vector<String> localType = new Vector<String>();
		localType.addElement(LocalType.BATHROOM.toString());
		localType.addElement(LocalType.BEDROOM.toString());
		localType.addElement(LocalType.KITCHEN.toString());
		
		// Choose the flat type
		typeComboBox = new JComboBox<String>(localType);
		typeComboBox.setBounds(165, 53, 131, 36);
		getContentPane().add(typeComboBox);

		// Size setup
		labelSize = new JLabel();
		labelSize.setText("Size");
		labelSize.setBounds(59, 106, 81, 22);
		getContentPane().add(labelSize);

		sizeField = new JTextField();
		sizeField.setBounds(165, 101, 130, 26);
		getContentPane().add(sizeField);
		sizeField.setColumns(10);

		// Spec setup
		labelSpec = new JLabel();
		labelSpec.setText("Spec");
		labelSpec.setBounds(59, 148, 81, 22);
		getContentPane().add(labelSpec);

		specField = new JTextField();
		specField.setColumns(10);
		specField.setBounds(165, 143, 130, 26);
		getContentPane().add(specField);

		// Confirm button
		btnAddLocal = new JButton("Add Local");
		btnAddLocal.setBounds(59, 200, 117, 29);
		getContentPane().add(btnAddLocal);

		// Frame setup
		setTitle("Add Local");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// Controller
	public int getSizeField() {
		return Integer.parseInt(sizeField.getText());
	}

	public int getSpecField() {
		return Integer.parseInt(specField.getText());
	}

	public LocalType getLocalType() {

		int tmp = typeComboBox.getSelectedIndex();

		switch(tmp) {
			case 0:
				return LocalType.BATHROOM;
			case 1:
				return LocalType.BEDROOM;
			case 2:
				return LocalType.KITCHEN;
		}

		return null;
	}

	public void setListenerAddLocal(ActionListener listenerAddLocal) {
		btnAddLocal.addActionListener(listenerAddLocal);
	}
	

	
}
