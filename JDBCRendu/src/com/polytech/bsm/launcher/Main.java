package com.polytech.bsm.launcher;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.controler.dao.FlatDAO;
import com.polytech.bsm.model.Flat;

import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

public class Main {
	
    public static void main(String [] args) {
    	
        FlatDAO flatDAO = new FlatDAO();
        ArrayList<Flat> flats = null;
        
        flats = flatDAO.findAll();
        
        for (Flat flat: flats) {
        	if (flat != null) {
				System.out.println("===================");
				System.out.println("Flat ID : " + flat.getFlatID());
				System.out.println("Address : " + flat.getFlatAddress());
				System.out.println("Description : " + flat.getFlatDescription());
				System.out.println("State : " + flat.getFlatState().toString());
				System.out.println("===================\n");
			} else {
				System.out.println("OOPSIES");
			}
        }


		
        try
        {
        	MainAppModel mainModel = new MainAppModel(flatDAO.findAll());
			MainAppView mainView = new MainAppView();
            MainAppController mainController = new MainAppController(mainView, mainModel);
            mainModel.setController(mainController);
            mainModel.setView(mainView);
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
