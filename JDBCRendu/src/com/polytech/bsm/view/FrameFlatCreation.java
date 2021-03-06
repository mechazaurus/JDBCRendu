package com.polytech.bsm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.polytech.bsm.model.FlatState;
import com.polytech.bsm.model.Local;

public class FrameFlatCreation extends JFrame {

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
	private JButton createFlatBtn;
	private JButton editLinkButton;
	
	public FrameFlatCreation() {

		getContentPane().setLayout(null);

		// Title setup
		titleLabel = new JLabel("Flat creation");
		titleLabel.setBounds(50, 25, 200, 20);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		titleLabel.setVisible(true);
		getContentPane().add(titleLabel);
		
		// Address setup
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(50, 50, 200, 50);
		addressLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		addressLabel.setVisible(true);
		getContentPane().add(addressLabel);
		addressTextField = new JTextField();
		addressTextField.setBounds(50, 90, 450, 30);
		addressTextField.setFont(new Font("Serif", Font.PLAIN, 14));
		addressTextField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		addressTextField.setVisible(true);
		getContentPane().add(addressTextField);
		
		// Description setup
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(50, 125, 200, 50);
		descriptionLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		descriptionLabel.setVisible(true);
		getContentPane().add(descriptionLabel);
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(50, 165, 450, 60);
		descriptionTextField.setFont(new Font("Serif", Font.PLAIN, 14));
		descriptionTextField.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		descriptionTextField.setVisible(true);
		getContentPane().add(descriptionTextField);
		
		// Flat state setup
		flatStateLabel = new JLabel("State");
		flatStateLabel.setBounds(50, 225, 200, 50);
		flatStateLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		flatStateLabel.setVisible(true);
		getContentPane().add(flatStateLabel);
		flatStateComboBox = new JComboBox<String>();
		flatStateComboBox.addItem(FlatState.UNDER_CONSTRUCTION.toString());
		flatStateComboBox.addItem(FlatState.READY.toString());
		flatStateComboBox.setBounds(50, 265, 175, 30);
		flatStateComboBox.setFont(new Font("Serif", Font.BOLD, 14));
		flatStateComboBox.setVisible(true);
		getContentPane().add(flatStateComboBox);
		
		// Add local
		localLabel = new JLabel("Local");
		localLabel.setBounds(50, 300, 200, 30);
		localLabel.setFont(new Font("Serif", Font.ITALIC, 18));
		localLabel.setVisible(true);
		getContentPane().add(localLabel);
		addLocalButton = new JButton("Add local");
		addLocalButton.setBounds(830, 300, 120, 30);
		addLocalButton.setFont(new Font("Serif", Font.BOLD, 14));
		addLocalButton.setVisible(true);
		getContentPane().add(addLocalButton);

		// Edit links button
		editLinkButton = new JButton("Edit Links");
		editLinkButton.setBounds(695, 300, 120, 30);
		getContentPane().add(editLinkButton);

		// Display added locals
		localTable = new JTable();
		localTable.setBounds(50, 335, 900, 350);
		localTable.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		localTable.setVisible(true);
		getContentPane().add(localTable);

		// Create button
		createFlatBtn = new JButton("Create Flat");
		createFlatBtn.setBounds(830, 700, 120, 30);
		getContentPane().add(createFlatBtn);


		// Frame setup
		setBackground(Color.WHITE);
		setSize(1100, 800);
		setLocationRelativeTo(null);
		setVisible(false);

	}

	// Controller
	public void addLocalListener(ActionListener listenForAddLocal) {
		addLocalButton.addActionListener(listenForAddLocal);
	}
	
	public void addCreateFlatListener(ActionListener listenForCreateFlat) {
		createFlatBtn.addActionListener(listenForCreateFlat);
	}
	
	public void addEditLinkListener(ActionListener listenForEditLinkButton) {
		editLinkButton.addActionListener(listenForEditLinkButton);
	}

	public void updateTable(ArrayList<Local>locals) {
        Vector<String> columnNames = new Vector<String>();
        String [] col = new String[]{"idLocal","LocalType", "Size", "Description"};

        //Set columns name
        for (int i = 0; i<col.length; i++) {
            columnNames.add(col[i]);
        }


        Vector<Vector<Object>> data;
        data = new Vector<Vector<Object>>();

        for(int i =0; i<locals.size(); i++) {
            Vector<Object> vector = new Vector<Object>();
            vector.add(locals.get(i).getLocalID());
            vector.add(locals.get(i).getLocalType());
            vector.add(locals.get(i).getLocalSize());
            vector.add(locals.get(i).getLocalSpec());
            data.add(vector);
        }

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

        localTable.setModel(model);
        localTable.repaint();
    }

    public String getAddress() {
		return addressTextField.getText();
	}

	public String getDescription() {
		return descriptionTextField.getText();
	}

	public FlatState getFlatState() {

		int tmp = flatStateComboBox.getSelectedIndex();

		switch(tmp) {
			case 0:
				return FlatState.UNDER_CONSTRUCTION;
			case 1:
				return FlatState.READY;
		}

		return null;
	}

}
