package com.polytech.bsm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.controler.dao.FlatDAO;
import com.polytech.bsm.view.MainAppView;

public class MainAppModel 
{

	//private BDD bdd;
	@SuppressWarnings("unused")
	private MainAppView mainAppView;
	@SuppressWarnings("unused")
	private MainAppController mainAppController;
	private FlatDAO flatDAO;


	private Flat createdFlat;
	private ArrayList<Local> AddFlatlocals;




	private ArrayList<Flat> flatList;
	
	public MainAppModel(FlatDAO flatdao) throws SQLException
	{
		//this.bdd = new BDD();
		flatList = flatdao.findAll();
		createdFlat = null;
		flatDAO = flatdao;
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
		//TODO SET ID ET UPDATE ID
		local.setLocalLinks(new ArrayList<Local>());
		int tmp = 0;
		for(int i=0; i<AddFlatlocals.size(); i++)
		{
			if(AddFlatlocals.get(i).getLocalID()>tmp)
			{
				tmp = AddFlatlocals.get(i).getLocalID();
			}
		}
		tmp = tmp +1;
		local.setLocalID(tmp);
		AddFlatlocals.add(local);
        System.out.println("local Added");
		System.out.println(local);
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

		Flat flat = new Flat();
		flat.setFlatID(flatDAO.findLastID()+1);
		flat.setFlatState(state);
		flat.setFlatAddress(add);
		flat.setFlatDescription(desc);
		flat.setFlatLocals(AddFlatlocals);

		//TODO Ajouter le nouvel objet dans FlatDAO
		flatDAO.addRecord(flat);
		flatDAO = new FlatDAO();

		//TODO envoyer les locaux et les liens


	}

	public void editLocalLinks(ArrayList<Integer> links, int localID)
	{
		Local tmp = null;
		Local local = getLocal(localID);
		for(int i=0; i<links.size(); i++)
		{
			tmp = getLocal(links.get(i).intValue());
			try
			{
				local.addLinkToLocal(tmp);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public Local getLocal(int localID)
	{
		for (int i= 0; i<AddFlatlocals.size(); i++)
		{
			if(AddFlatlocals.get(i).getLocalID()==localID)
			{
				return AddFlatlocals.get(i);
			}
		}
		return null;
	}

}
