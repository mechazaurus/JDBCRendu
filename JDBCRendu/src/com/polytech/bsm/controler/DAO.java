package com.polytech.bsm.controler;

import java.sql.Connection;

import com.polytech.bsm.model.ConnectionSQL;

public abstract class DAO<T> {

	public Connection connection = ConnectionSQL.getInstance();
	
	// Get an object from it's ID
	public abstract T find(long id);
	
	// Create an entry in the database from an object
	public abstract T create(T obj);
	
	// Update an entry in the database from an object
	public abstract T update(T obj);
	
	// Delete an entry in the database from an object
	public abstract T delete(T obj);
}
