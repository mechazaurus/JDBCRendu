package com.polytech.bsm.launcher;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.controler.dao.FlatDAO;

import java.sql.SQLException;

import com.polytech.bsm.controler.dao.LinksDAO;
import com.polytech.bsm.controler.dao.LocalDAO;
import com.polytech.bsm.controler.dao.SearchDAO;
import com.polytech.bsm.model.MainAppModel;
import com.polytech.bsm.view.MainAppView;

public class Main {
	
    public static void main(String [] args) {
    	
        FlatDAO flatDAO = new FlatDAO();
        LocalDAO localDAO = new LocalDAO();
        LinksDAO linksDAO = new LinksDAO();
        SearchDAO searchDAO = new SearchDAO();
        
        try
        {
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
