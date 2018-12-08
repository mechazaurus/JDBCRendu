package com.polytech.bsm.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;

import com.polytech.bsm.model.LocalType;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.FrameAddLocal;
import com.polytech.bsm.view.FrameDisplayFlats;
import com.polytech.bsm.view.MainAppView;
import com.polytech.bsm.view.FrameSpecifiedSearch;
import com.polytech.bsm.view.FrameFlatCreation;

import javax.swing.*;


public class MainAppController 
{
	private MainAppView mainAppView;
	@SuppressWarnings("unused")
	private MainAppModel mainAppModel;
	//private JFrame addAppartmentView;
	private FrameSpecifiedSearch searchAppartmentView;
	private FrameDisplayFlats displayAllFlatsFrame;
	private FrameFlatCreation frameFlatCreation;


	private FrameAddLocal addLocal;
	
	
	public MainAppController(MainAppView view, MainAppModel model)
	{
		this.mainAppView = view;
		this.mainAppView.setVisible(true);
		this.mainAppModel = model;

		this.frameFlatCreation = new FrameFlatCreation();
		this.searchAppartmentView = new FrameSpecifiedSearch();
		
		//Setting Listeners for mainApp frame
		this.mainAppView.addAppartmentnListener(new MainAppController.addAppartmentButtonListener());
		this.mainAppView.addSearchListener(new MainAppController.searchAppartmentButtonListener());
		this.mainAppView.addDisplayFlatListener(new MainAppController.displayFlatsButtonListener());
		
		//Setting Listeners for searchAppartmentView
		this.searchAppartmentView.addSearchListener(new MainAppController.searchAppartmentListener());
		
			

		//Setting Listeners for addFlatView
		this.frameFlatCreation.addLocalListener(new MainAppController.addLocalListener());

		//Settings Listener for addLocal
        //this.addLocal.setListenerAddLocal(new MainAppController.addLocalButtonListener());
	}


	 
    class addAppartmentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	frameFlatCreation.setVisible(true);

                new Thread(new Runnable(){
                    public void run()
                    {
                        while(true)
                        {
                            try {
                                Thread.sleep(1000);

                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        frameFlatCreation.updateTable(mainAppModel.getLocals());
                                    }
                                });
                            }
                            catch (InterruptedException d)
                            {
                                System.out.println(d);
                            }
                        }
                    }
                }).start();

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
    
    class addLocalListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	addLocal = new FrameAddLocal();
            	addLocal.setVisible(true);
                addLocal.setListenerAddLocal(new MainAppController.addLocalButtonListener());

            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }

    class displayFlatsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                displayAllFlatsFrame = new FrameDisplayFlats(mainAppModel.getFlatList());
                displayAllFlatsFrame.setVisible(true);

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

                //TODO Send query from model
                ResultSet rs = mainAppModel.searchSpecificAppartment(nbBedRooms, nbKitchens, nbBathrooms);


                //Create new JFrame to display response
                //TODO
               
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }

    class addLocalButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                //TODO get info from add local frame
                int size = addLocal.getSizeField();
                int spec = addLocal.getSpecField();
                LocalType type = addLocal.getLocalType();

                //TODO send info to model
                mainAppModel.addLocal(type,size, spec);
                for (int i=0; i<mainAppModel.getLocals().size(); i++)
                {

                    System.out.println(mainAppModel.getLocals().get(i).toString());
                }

            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }
    
    
    
    
	
}
