package com.polytech.bsm.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import com.polytech.bsm.model.FlatState;
import com.polytech.bsm.model.LocalType;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.*;

import javax.swing.*;


public class MainAppController 
{
	private MainAppView mainAppView;
	private MainAppModel mainAppModel;
	//private JFrame addAppartmentView;
	private FrameSpecifiedSearch searchAppartmentView;
	private FrameDisplayFlats displayAllFlatsFrame;
	private FrameFlatCreation frameFlatCreation;


	private FrameAddLocal addLocal;
	private FrameEditLinks editLinks;
	
	
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

		this.frameFlatCreation.addCreateFlatListener(new MainAppController.addCreateFlatButton());
        this.frameFlatCreation.addEditLinkListener(new MainAppController.addEditLinkFrame());
	}


	 
    class addAppartmentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
            	frameFlatCreation.setVisible(true);
            	mainAppModel.resetLocals();

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


    class addEditLinkFrame implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                editLinks = new FrameEditLinks();
                editLinks.setLocalComboBox(mainAppModel.getLocals());
                editLinks.setLocalList(mainAppModel.getLocals(), editLinks.getCurrentLocalId());
                editLinks.setVisible(true);

                //Listeners
                editLinks.addJComboBoxListener(new MainAppController.comboBoxListener());
                //Listeners button add and remove
                editLinks.addLinkButtonListener(new MainAppController.addLink());
                editLinks.removeLinkButtonListener(new MainAppController.removeLink());
                //Listener button done
                editLinks.addButtonDoneListener(new MainAppController.doneLinks());

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
                //ResultSet rs = mainAppModel.searchSpecificAppartment(nbBedRooms, nbKitchens, nbBathrooms);


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

            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }

    class addCreateFlatButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                //TODO get info from frame
                String adress = frameFlatCreation.getAddress();
                String desc = frameFlatCreation.getDescription();
                FlatState state = frameFlatCreation.getFlatState();

                System.out.println(adress+desc+state);
                //TODO send info to model
                mainAppModel.createFlat(adress,desc,state);
                System.out.println("Flat Added");
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }



    class comboBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            try
            {
                editLinks.eraseLocalList();
                editLinks.setLocalList(mainAppModel.getLocals(), editLinks.getCurrentLocalId());
            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }

    class addLink implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                //Get local from list
                int localId = editLinks.getSelectedLocal();
                //Add Local to right list
                editLinks.addLink(localId);


            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }
    class removeLink implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                //Get local from right list
                int localID = editLinks.getSelectedLinkLocalID();
                //Remove local from right list
                editLinks.removeLink(localID);

            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }

    class doneLinks implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                //Get id of local
                int localID = editLinks.getCurrentLocalId();
                //Get id of locals to be linked
                ArrayList<Integer> localsToBeLink = editLinks.getLocalToBeLink();
                //Update Local
                mainAppModel.editLocalLinks(localsToBeLink, localID);

            }
            catch(NumberFormatException ex)
            {
                System.out.println(ex);
            }
        }
    }

    
	
}
