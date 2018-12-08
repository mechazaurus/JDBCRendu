package com.polytech.bsm.view;

import com.polytech.bsm.model.LocalType;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FrameAddLocal extends JFrame {
	
	
	private JComboBox typeComboBox;
	private JButton btnAddLocal;
	private JTextArea txtrSize;
	private JTextArea txtrSpec;
	private JTextField sizeField;
	private JTextField specField;
	
	public FrameAddLocal() 
	{
		getContentPane().setLayout(null);
		
		JTextArea txtrLocalType = new JTextArea();
		txtrLocalType.setText("Type");
		txtrLocalType.setBounds(59, 62, 81, 22);
		getContentPane().add(txtrLocalType);
		
		Vector<String> languages = new Vector<String>();
		languages.addElement(LocalType.BATHROOM.toString());
		languages.addElement(LocalType.BEDROOM.toString());
		languages.addElement(LocalType.KITCHEN.toString());
		
		
		typeComboBox= new JComboBox<String>(languages);
		typeComboBox.setBounds(202, 53, 131, 36);
		getContentPane().add(typeComboBox);
		
		btnAddLocal = new JButton("Add Local");
		btnAddLocal.setBounds(126, 287, 117, 29);
		getContentPane().add(btnAddLocal);
		
		txtrSize = new JTextArea();
		txtrSize.setText("Size");
		txtrSize.setBounds(59, 106, 81, 22);
		getContentPane().add(txtrSize);
		
		txtrSpec = new JTextArea();
		txtrSpec.setText("Spec");
		txtrSpec.setBounds(59, 148, 81, 22);
		getContentPane().add(txtrSpec);
		
		sizeField = new JTextField();
		sizeField.setBounds(203, 101, 130, 26);
		getContentPane().add(sizeField);
		sizeField.setColumns(10);
		
		specField = new JTextField();
		specField.setColumns(10);
		specField.setBounds(203, 143, 130, 26);
		getContentPane().add(specField);
		
        setTitle("Add Local");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Appartments");
		setLocationRelativeTo(null);
		setVisible(false);
		setSize(490, 383);
	}


	public int getSizeField()
	{
		return Integer.parseInt(sizeField.getText());
	}
	public int getSpecField()
	{
		return Integer.parseInt(specField.getText());
	}
	public LocalType getLocalType()
	{
		int tmp = typeComboBox.getSelectedIndex();
		switch(tmp)
		{
			case 0:
				return LocalType.BATHROOM;
			case 1:
				return LocalType.BEDROOM;
			case 2:
				return LocalType.KITCHEN;
		}
		return null;
	}

	public void setListenerAddLocal(ActionListener listenerAddLocal)
	{
		btnAddLocal.addActionListener(listenerAddLocal);
	}
	

	
}
