package com.polytech.bsm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.view.MainAppView;

public class MainAppModel 
{
	@SuppressWarnings("unused")
	private BDD bdd;
	@SuppressWarnings("unused")
	private MainAppView mainAppView;
	@SuppressWarnings("unused")
	private MainAppController mainAppController;

	private ArrayList<Flat> flatList;
	
	public MainAppModel(ArrayList<Flat> flats) throws SQLException
	{
		this.bdd = new BDD();
		flatList = flats;
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

	public ArrayList<Flat> getFlatList()
	{
		return flatList;
	}

}
