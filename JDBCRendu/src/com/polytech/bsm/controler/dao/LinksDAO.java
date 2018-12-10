package com.polytech.bsm.controler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.polytech.bsm.model.ConnectionSQL;

public class LinksDAO {
	
	private Connection connection = ConnectionSQL.getInstance();
	
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
