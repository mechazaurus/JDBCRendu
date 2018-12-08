package com.polytech.bsm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.view.MainAppView;

public class MainAppModel 
{

	//private BDD bdd;
	@SuppressWarnings("unused")
	private MainAppView mainAppView;
	@SuppressWarnings("unused")
	private MainAppController mainAppController;


	private Flat createdFlat;
	private ArrayList<Local> AddFlatlocals;




	private ArrayList<Flat> flatList;
	
	public MainAppModel(ArrayList<Flat> flats) throws SQLException
	{
		//this.bdd = new BDD();
		flatList = flats;
		createdFlat = null;
		AddFlatlocals = new ArrayList<Local>();
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

	public void addLocal(LocalType type, int size, int spec)
	{
		Local local = new Local();
		local.setLocalType(type);
		local.setLocalSpec(spec);
		local.setLocalSize(size);
		//TODO SET ID
		local.setLocalLinks(new ArrayList<Local>());
		AddFlatlocals.add(local);
        System.out.println("local Added");
	}

	public ArrayList<Local> getLocals()
    {
        return AddFlatlocals;
    }

    public void resetLocals()
	{
		AddFlatlocals = new ArrayList<>();
	}

    public void createFlat(String add, String desc, FlatState state)
	{
		int id = 0;
		for(int i=0; i<flatList.size(); i++)
		{
			if(flatList.get(i).getFlatID()>id)
			{
				id = flatList.get(i).getFlatID();
			}
		}
		Flat flat = new Flat();
		flat.setFlatID(id);
		flat.setFlatState(state);
		flat.setFlatAddress(add);
		flat.setFlatDescription(desc);
		flat.setFlatLocals(AddFlatlocals);

		flatList.add(flat);
	}


}
