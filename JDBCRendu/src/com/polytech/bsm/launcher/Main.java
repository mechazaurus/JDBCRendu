package com.polytech.bsm.launcher;

import java.sql.SQLException;

import com.polytech.bsm.controller.MainAppController;
import com.polytech.bsm.model.BDD;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

public class Main {
	
    public static void main(String [] args) {
    	
        try {
            
        	MainAppModel mainModel = new MainAppModel();
			MainAppView mainView = new MainAppView();
            MainAppController mainController = new MainAppController(mainView, mainModel);
            mainModel.setController(mainController);
            mainModel.setView(mainView);
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
