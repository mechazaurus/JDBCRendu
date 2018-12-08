package com.polytech.bsm.controller;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;
import com.polytech.bsm.view.FrameSpecifiedSearch;


public class MainAppController 
{
	private MainAppView mainAppView;
	private MainAppModel mainAppModel;
	//private JFrame addAppartmentView;
	private FrameSpecifiedSearch searchAppartmentView;
	
	public MainAppController(MainAppView view, MainAppModel model)
	{
		this.mainAppView = view;
		this.mainAppView.setVisible(true);
		this.mainAppModel = model;

		this.searchAppartmentView = new FrameSpecifiedSearch();
		
		//Setting Listeners for mainApp frame
		this.mainAppView.addAppartmentnListener(new MainAppController.addAppartmentButtonListener());
		this.mainAppView.addSearchListener(new MainAppController.searchAppartmentButtonListener());
		
		//Setting Listeners for searchAppartmentView
		this.searchAppartmentView.addSearchListener(new MainAppController.searchAppartmentListener());
		
	}


	 
    class addAppartmentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	//addAppartmentView = new addAppartmentFrame;
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }
    class searchAppartmentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	searchAppartmentView.setVisible(true);
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }
    

    class searchAppartmentListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	//Get query info from view
                int nbBathrooms = searchAppartmentView.getBathroom() ;
                int nbBedRooms = searchAppartmentView.getBedRooms();
                int nbKitchens = searchAppartmentView.getKitchens();
                //Send query from model
                ResultSet rs = mainAppModel.searchSpecificAppartment(nbBedRooms, nbKitchens, nbBathrooms);


                //Create new JFrame to display response
                
               
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }
    
    
    
    
	
}
