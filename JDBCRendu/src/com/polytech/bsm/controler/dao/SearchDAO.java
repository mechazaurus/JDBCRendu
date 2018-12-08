package com.polytech.bsm.controler.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.polytech.bsm.model.ConnectionSQL;
import com.polytech.bsm.model.Flat;

public class SearchDAO {

	private Connection connection = ConnectionSQL.getInstance();
	
	public ArrayList<Flat> searchFlat() {
		
		ArrayList<Flat> flats = new ArrayList<>();
		FlatDAO flatDAO = new FlatDAO();
		
		flats = flatDAO.findAll();
		
		return null;
	}
}
