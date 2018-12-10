package com.polytech.bsm.launcher;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.controler.dao.FlatDAO;
import com.polytech.bsm.controler.dao.LinksDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.polytech.bsm.controler.dao.LocalDAO;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

public class Main {
	
    public static void main(String [] args) {
    	
        FlatDAO flatDAO = new FlatDAO();
        LocalDAO localDAO = new LocalDAO();

        try
        {
        	MainAppModel mainModel = new MainAppModel(flatDAO, localDAO);
			MainAppView mainView = new MainAppView();
            MainAppController mainController = new MainAppController(mainView, mainModel);
            mainModel.setController(mainController);
            mainModel.setView(mainView);
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
