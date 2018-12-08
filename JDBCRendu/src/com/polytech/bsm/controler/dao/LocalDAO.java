package com.polytech.bsm.controler.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT NEXTVAL('local_idlocal_seq') as id");
			
			if (resultSet.first()) {
				int id = resultSet.getInt("id");
				
				PreparedStatement preparedStatement = this.connection
						.prepareStatement("INSERT INTO local (idlocal, type, size, spec)"
								+ "VALUES(?, ?, ?, ?);");
				
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, obj.getLocalType().toString());
				preparedStatement.setInt(3, obj.getLocalSize());
				preparedStatement.setInt(4, obj.getLocalSpec());
			}
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
						+ "WHERE idflat=" + obj.getLocalID());
			
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
			.executeUpdate("DELETE FROM flat WHERE idflat=" + obj.getLocalID());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
