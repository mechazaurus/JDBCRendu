package com.polytech.bsm.launcher;

import com.polytech.bsm.controler.FlatDAO;
import com.polytech.bsm.model.Flat;
import java.sql.SQLException;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.model.BDD;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

public class Main {
	
    public static void main(String [] args) {
        FlatDAO flatDAO = new FlatDAO();
		Flat flat = new Flat();
		for (int i = 1 ; i <= 5 ; i++) {
			flat = flatDAO.find(i);
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
        try {
            
        	MainAppModel mainModel = new MainAppModel();
			MainAppView mainView = new MainAppView();
            MainAppController mainController = new MainAppController(mainView);
            mainModel.setController(mainController);
            mainModel.setView(mainView);
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
