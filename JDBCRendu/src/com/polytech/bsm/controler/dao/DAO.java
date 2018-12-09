package com.polytech.bsm.controler.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.polytech.bsm.model.ConnectionSQL;

public abstract class DAO<T> {

	public Connection connection = ConnectionSQL.getInstance();
	
	// Get an object from it's ID
	public abstract T find(Integer id);
	
	// Create an entry in the database from an object
	public abstract T create(T obj);
	
	// Update an entry in the database from an object
	public abstract T update(T obj);
	
	// Delete an entry in the database from an object
	public abstract void delete(T obj);

	//Add record to database
	public abstract void addRecord(T obs);

	// Get all entries from the database
	public abstract ArrayList<T> findAll();
	
	public abstract Integer findLastID();

	public abstract void updateObject();

}
