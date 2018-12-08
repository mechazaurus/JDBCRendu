package com.polytech.bsm.launcher;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.controler.dao.FlatDAO;

import java.sql.SQLException;

import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

public class Main {
	
    public static void main(String [] args) {
    	
        FlatDAO flatDAO = new FlatDAO();
        
        System.out.println(flatDAO.findLastID());
		
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
