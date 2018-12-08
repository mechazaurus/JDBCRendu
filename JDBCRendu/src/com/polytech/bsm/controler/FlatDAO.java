package com.polytech.bsm.controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT NEXTVAL('flat_idflat_seq') as id");
			
			if (resultSet.first()) {
				int id = resultSet.getInt("id");
				
				PreparedStatement preparedStatement = this.connection
						.prepareStatement("INSERT INTO flat (idflat, address, description, state)"
								+ "VALUES(?, ?, ?, ?);");
				
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, obj.getFlatAddress());
				preparedStatement.setString(3, obj.getFlatDescription());
				preparedStatement.setString(4, obj.getFlatState().toString());
			}
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

}
