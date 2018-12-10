package com.polytech.bsm.controler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.polytech.bsm.model.ConnectionSQL;

public class SearchDAO {

	private Connection connection = ConnectionSQL.getInstance();
	
	public ArrayList<Integer> searchFlat(String type, Integer spec) {
		
		ArrayList<Integer> flatIDs = new ArrayList<>();

		try {

			PreparedStatement preparedStatement = this.connection
					.prepareStatement("SELECT idFlat FROM Flat WHERE idFlat IN "
							+ "(SELECT DISTINCT li.flatid FROM Links li INNER JOIN Local lo " 
							+ "ON li.localid = lo.idLocal "
							+ "WHERE lo.type = ? AND lo.spec = ?);");
			
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, spec);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				flatIDs.add(resultSet.getInt(1));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flatIDs;
	}
}
