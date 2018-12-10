package com.polytech.bsm.launcher;

import com.polytech.bsm.controller.MainAppController;
import com.polytech.bsm.controller.dao.FlatDAO;
import com.polytech.bsm.controller.dao.LinksDAO;
import com.polytech.bsm.controller.dao.LocalDAO;
import com.polytech.bsm.controller.dao.SearchDAO;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

import java.sql.SQLException;

public class Main {
	
    public static void main(String [] args) {
    	
        FlatDAO flatDAO = new FlatDAO();
        LocalDAO localDAO = new LocalDAO();
        LinksDAO linksDAO = new LinksDAO();
        SearchDAO searchDAO = new SearchDAO();
        
        try {
        	MainAppModel mainModel = new MainAppModel(flatDAO, localDAO, linksDAO, searchDAO);
			MainAppView mainView = new MainAppView();
            MainAppController mainController = new MainAppController(mainView, mainModel);
            mainModel.setController(mainController);
            mainModel.setView(mainView);
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
