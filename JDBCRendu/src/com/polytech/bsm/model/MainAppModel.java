package com.polytech.bsm.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.polytech.bsm.controler.MainAppController;
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


	public ResultSet searchSpecificAppartment(int bedrooms, int kichen, int bathrooms)
	{
		//TODO send query and return results
		return null;
	}

}
