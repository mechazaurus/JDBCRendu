package com.polytech.bsm.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD {

	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	public BDD () throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "aqwzsx85");
		statement = connection.createStatement();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
}
