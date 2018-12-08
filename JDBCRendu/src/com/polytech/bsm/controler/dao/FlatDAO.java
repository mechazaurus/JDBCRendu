package com.polytech.bsm.controler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.model.Flat;
import com.polytech.bsm.model.FlatState;

public class FlatDAO extends DAO<Flat> {

	@Override
	public Flat find(Integer id) {
		
		Flat flat = null;
		
		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Flat WHERE idflat=" + id);
			
		if (resultSet.first()) {
			flat = new Flat(id, resultSet.getString(2), resultSet.getString(3));
			
			if (resultSet.getString(4).equalsIgnoreCase("ready")) {
				flat.setFlatState(FlatState.READY);
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flat;
	}

	@Override
	public Flat create(Flat obj) {

		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = this.connection
					.prepareStatement("INSERT INTO Flat (idflat, address, description, state)"
							+ "VALUES(?, ?, ?, ?);");
			preparedStatement.setInt(1, obj.getFlatID());
			preparedStatement.setString(2, obj.getFlatAddress());
			preparedStatement.setString(3, obj.getFlatDescription());
			preparedStatement.setString(4, obj.getFlatState().toString());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
				
		return obj;
	}

	@Override
	public Flat update(Flat obj) {
		
		try {
			
			this.connection
				.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE)
				.executeUpdate("UPDATE TABLE flat "
						+ "SET address=" + obj.getFlatAddress() + " "
						+ "SET description=" + obj.getFlatDescription() + " "
						+ "SET state=" + obj.getFlatState().toString() + " "
						+ "WHERE idflat=" + obj.getFlatID());
			
			obj = this.find(obj.getFlatID());
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public void delete(Flat obj) {

		try {
			
			this.connection
			.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE)
			.executeUpdate("DELETE FROM flat WHERE idflat=" + obj.getFlatID());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Flat> findAll() {
		
		ArrayList<Flat> flats = new ArrayList<>();

		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Flat");
			
			while (resultSet.next()) {
				Flat flat = new Flat(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3));
				
				if (resultSet.getString(4).equalsIgnoreCase("ready")) {
					flat.setFlatState(FlatState.READY);
				}
				
				flats.add(flat);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flats;
	}

	@Override
	public Integer findLastID() {
		
		Integer lastID = null;
		
		try {
			
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT max(idflat) FROM Flat");
			
			while(resultSet.next()) {
				lastID = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastID;
	}

}
