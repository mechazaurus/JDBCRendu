package com.polytech.bsm.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.polytech.bsm.model.ConnectionSQL;

public class LinksDAO {
	
	private Connection connection = ConnectionSQL.getInstance();
	
	public HashMap<Integer, ArrayList<Integer>> findAllLinks() {
		
		HashMap<Integer, ArrayList<Integer>> links = new HashMap<>();
		
		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT DISTINCT flatid FROM Links");
			
			while(resultSet.next()) {
				links.put(resultSet.getInt(1), new ArrayList<Integer>());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ResultSet resultSet = this.connection
					.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Links");
			
			while (resultSet.next()) {
				links.get(resultSet.getInt(1)).add(resultSet.getInt(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return links;
	}
	
	public void createLink(Integer flat, Integer local) {
		
		try {
			
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("INSERT INTO Links (flatid, localid) "
							+ "VALUES (?, ?);");
			
			preparedStatement.setInt(1, flat);
			preparedStatement.setInt(2, local);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
