package com.polytech.bsm.view;

import com.polytech.bsm.model.Flat;
import com.polytech.bsm.model.LocalType;
import com.polytech.bsm.model.MainAppModel;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameSpecifiedSearch extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField txtSpecifiedSearch;
	private JTextField bathroomField;
	private JTextField kitchenField;
	private JTextField bedroomField;
	private JButton searchBtn;
	
	public FrameSpecifiedSearch(MainAppModel model)
	{
		getContentPane().setLayout(null);
		
		txtSpecifiedSearch = new JTextField();
		txtSpecifiedSearch.setText("Appartement Specified Search");
		txtSpecifiedSearch.setEditable(false);
		txtSpecifiedSearch.setBounds(192, 17, 198, 26);
		getContentPane().add(txtSpecifiedSearch);
		txtSpecifiedSearch.setColumns(10);
		
		JTextArea txtrHowManyBathrooms = new JTextArea();
		txtrHowManyBathrooms.setText("How many bathrooms ?");
		txtrHowManyBathrooms.setEditable(false);
		txtrHowManyBathrooms.setBounds(49, 90, 156, 16);
		getContentPane().add(txtrHowManyBathrooms);
		
		bathroomField = new JTextField();
		bathroomField.setBounds(373, 85, 130, 26);
		getContentPane().add(bathroomField);
		bathroomField.setColumns(10);
		
		JTextArea txtrHowManyKitchens = new JTextArea();
		txtrHowManyKitchens.setText("How many kitchens ?");
		txtrHowManyKitchens.setEditable(false);
		txtrHowManyKitchens.setBounds(49, 139, 156, 16);
		getContentPane().add(txtrHowManyKitchens);
		
		kitchenField = new JTextField();
		kitchenField.setColumns(10);
		kitchenField.setBounds(373, 134, 130, 26);
		getContentPane().add(kitchenField);
		
		JTextArea txtrHowManyBedrooms = new JTextArea();
		txtrHowManyBedrooms.setText("How many bedrooms ?");
		txtrHowManyBedrooms.setEditable(false);
		txtrHowManyBedrooms.setBounds(49, 185, 156, 16);
		getContentPane().add(txtrHowManyBedrooms);
		
		bedroomField = new JTextField();
		bedroomField.setColumns(10);
		bedroomField.setBounds(373, 180, 130, 26);
		getContentPane().add(bedroomField);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(211, 255, 117, 29);
		getContentPane().add(searchBtn);
		setPreferredSize(new Dimension(739, 634));
		
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setTitle("Search Appartments");
		setLocationRelativeTo(null);
		setVisible(false);
		setSize(600, 500);

		bedroomField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				bathroomField.setVisible(false);
				kitchenField.setVisible(false);
			}
		});
		bathroomField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				bedroomField.setVisible(false);
				kitchenField.setVisible(false);
			}
		});
		kitchenField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				bathroomField.setVisible(false);
				bedroomField.setVisible(false);
			}
		});

		searchButton(model);


	}
	
	public void searchButton (MainAppModel model)
	{
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int nb = 0;
				String type = null;
				FrameDisplayFlats searchFlats;
				if(getBathroomField().isVisible())
				{
					nb = Integer.valueOf(getBathroomField().getText());
					type = LocalType.BATHROOM.toString();
				}
				else if(getKitchenField().isVisible())
				{
					nb = Integer.valueOf(getKitchenField().getText());
					type = LocalType.KITCHEN.toString();
				}
				else if(getBedroomField().isVisible())
				{
					nb = Integer.valueOf(getBedroomField().getText());
					type = LocalType.BEDROOM.toString();
				}
				System.out.println(type+" "+ nb);
				ArrayList<Flat> res = model.searchFlats(type, nb);
				searchFlats = new FrameDisplayFlats(res);
				searchFlats.setVisible(true);
			}
		});
	}


	public int getBedRooms ()
	{
		return Integer.parseInt(bedroomField.getText());
	}
	public int getKitchens ()
	{
		return Integer.parseInt(kitchenField.getText());
	}
	public int getBathroom ()
	{
		return Integer.parseInt(bathroomField.getText());
	}

	public void addBedroomListener(KeyAdapter listener)
	{
		bedroomField.addKeyListener(listener);
	}
	public void addBathroomKeyListener(KeyAdapter listener)
	{
		bathroomField.addKeyListener(listener);
	}
	public void addKitchenKeyListener(KeyAdapter listener)
	{
		kitchenField.addKeyListener(listener);
	}

	public JTextField getBathroomField()
	{
		return bathroomField;
	}
	public JTextField getKitchenField()
	{
		return kitchenField;
	}
	public JTextField getBedroomField()
	{
		return bedroomField;
	}



	
}
