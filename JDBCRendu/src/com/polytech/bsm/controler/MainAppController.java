package com.polytech.bsm.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;
import com.polytech.bsm.view.FrameSpecifiedSearch;


public class MainAppController 
{
	private MainAppView mainAppView;
	@SuppressWarnings("unused")
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
                //Send query from model
                //Create new JFrame to display response
                
               
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }
    
    
    
    
	
}
