package com.polytech.bsm.model;

import java.sql.SQLException;

import com.polytech.bsm.controller.MainAppController;
import com.polytech.bsm.view.MainAppView;

public class MainAppModel 
{
	private BDD bdd;
	private MainAppView mainAppView;
	private MainAppController mainAppController;
	
	public MainAppModel() throws SQLException
	{
		this.bdd = new BDD();
	}
	public void setView(MainAppView view)
	{
		this.mainAppView = view;
	}
	public void setController(MainAppController controller)
	{
		this.mainAppController = controller;
	}

}
