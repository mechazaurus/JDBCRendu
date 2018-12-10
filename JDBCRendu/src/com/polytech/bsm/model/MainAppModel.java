package com.polytech.bsm.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.polytech.bsm.controler.MainAppController;
import com.polytech.bsm.controler.dao.FlatDAO;
import com.polytech.bsm.controler.dao.LinksDAO;
import com.polytech.bsm.controler.dao.LocalDAO;
import com.polytech.bsm.view.MainAppView;

public class MainAppModel 
{

	//private BDD bdd;
	@SuppressWarnings("unused")
	private MainAppView mainAppView;
	@SuppressWarnings("unused")
	private MainAppController mainAppController;

	private LinksDAO linksDAO;
	private FlatDAO flatDAO;
	private LocalDAO localDAO;


	private Flat createdFlat;
	private ArrayList<Local> AddFlatlocals;
	private HashMap<Integer, ArrayList<Integer>> links;




	private ArrayList<Flat> flatList;
	
	public MainAppModel(FlatDAO flatdao, LocalDAO localdao, LinksDAO linksdao) throws SQLException
	{
		//this.bdd = new BDD();
		flatList = flatdao.findAll();
		createdFlat = null;
		flatDAO = flatdao;
		AddFlatlocals = new ArrayList<Local>();
		localDAO = localdao;
		linksDAO = linksdao;
		links = linksDAO.findAllLinks();
	}
	public void setView(MainAppView view)
	{
		this.mainAppView = view;
	}
	public void setController(MainAppController controller)
	{
		this.mainAppController = controller;
	}


	public ArrayList<Flat> searchSpecificAppartment(int bedrooms, int kichen, int bathrooms)
	{
		//TODO



		return null;
	}

	public ArrayList<Flat> getFlatList()
	{
		return flatList;
	}

	public ArrayList<Local> getLocalsFromFlatID(int flatID)
	{
		for(int i=0; i<flatList.size(); i++)
		{
			if(flatID==flatList.get(i).getFlatID())
			{
				return flatList.get(i).getFlatLocals();
			}
		}
		return null;
	}

	public void addLocal(LocalType type, int size, int spec)
	{
		Local local = new Local();
		local.setLocalType(type);
		local.setLocalSpec(spec);
		local.setLocalSize(size);
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
		if(tmp<localDAO.findLastID())
		{
			tmp = localDAO.findLastID() +1;
		};
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

		//Ajouter le nouvel objet dans FlatDAO
		flatDAO.addRecord(flat);

		//envoyer les locaux
        for(int i=0; i<flat.getFlatLocals().size(); i++)
        {
            localDAO.addRecord(flat.getFlatLocals().get(i));
        }

        //update locals
		for(int i=0; i<AddFlatlocals.size(); i++)
		{
			localDAO.updateLocalLinks(AddFlatlocals.get(i).getLocalLinks(), AddFlatlocals.get(i));
		}

		//Cleaning up everything
		localDAO.deleteRedondentLocals();

		//TODO link locals to flat
		for(int i=0; i<flat.getFlatLocals().size(); i++)
		{
			linksDAO.createLink(flat.getFlatID(), flat.getFlatLocals().get(i).getLocalID());
		}




		flatDAO = new FlatDAO();
        localDAO = new LocalDAO();
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
