package com.polytech.bsm.controler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.model.Flat;
import com.polytech.bsm.model.Local;
import com.polytech.bsm.model.LocalType;

public class LocalDAO extends DAO<Local> {

	@Override
	public Local find(Integer id) {
		
		Local local = null;
		
		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM local WHERE idlocal=" + id);
			
		if (resultSet.first()) {
			local = new Local(id, null, resultSet.getInt(4), resultSet.getInt(5));
			
			if (resultSet.getString(3).equalsIgnoreCase("bathroom")) {
				local.setLocalType(LocalType.BATHROOM);
			} else if (resultSet.getString(3).equalsIgnoreCase("bedroom")) {
				local.setLocalType(LocalType.BEDROOM);
			} else if (resultSet.getString(3).equalsIgnoreCase("kitchen")) {
				local.setLocalType(LocalType.KITCHEN);
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return local;
	}

	@Override
	public Local create(Local obj) {

		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO Local (idlocal, type, size, spec)"
							+ "VALUES(?, ?, ?, ?);");
			
			preparedStatement.setInt(1, obj.getLocalID());
			preparedStatement.setString(2, obj.getLocalType().toString());
			preparedStatement.setInt(3, obj.getLocalSize());
			preparedStatement.setInt(4, obj.getLocalSpec());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Local update(Local obj) {

		try {
			
			this.connection
				.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE)
				.executeUpdate("UPDATE TABLE flat "
						+ "SET type=" + obj.getLocalType().toString() + " "
						+ "SET size=" + obj.getLocalSize() + " "
						+ "SET spec=" + obj.getLocalSpec() + " "
						+ "WHERE idLocal=" + obj.getLocalID());
			
			obj = this.find(obj.getLocalID());
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Local obj) {

		try {
			
			this.connection
			.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("DELETE FROM Local WHERE idLocal=" + obj.getLocalID());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Local> findAll() {

		ArrayList<Local> locals = new ArrayList<>();
		
		try {
			
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Local");
			
			while (resultSet.next()) {
				Local local = new Local(resultSet.getInt(1), null, resultSet.getInt(4), resultSet.getInt(5));
				
				if (resultSet.getString(3).equalsIgnoreCase("bathroom")) {
					local.setLocalType(LocalType.BATHROOM);
				} else if (resultSet.getString(3).equalsIgnoreCase("bedroom")) {
					local.setLocalType(LocalType.BEDROOM);
				} else if (resultSet.getString(3).equalsIgnoreCase("kitchen")) {
					local.setLocalType(LocalType.KITCHEN);
				}
				
				locals.add(local);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer findLastID() {

		Integer lastID = null;
		
		try {
			
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT max(idlocal) FROM Local");
			
			while (resultSet.next()) {
				
				lastID = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastID;
	}

	@Override
	public void addRecord(Local obj)
	{

	}

	@Override
	public void updateObject() {
	}


}
